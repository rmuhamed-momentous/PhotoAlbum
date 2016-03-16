package com.momentoustech.camerasample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.momentoustech.camerasample.adapters.PhotoAlbumAdapter;
import com.momentoustech.camerasample.model.MediaContent;
import com.momentoustech.camerasample.model.PictureContent;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int RECORD_VIDEO_ACTIVITY_REQUEST_CODE = 200;

    private static final String VIDEO_FILE_URI = "vid-%s.3gp";
    private static final String IMAGE_FILE_URI = "img-%s.png";

    private File imageFile;
    private File videoFile;

    private Collection<MediaContent> photoAlbum;
    private PhotoAlbumAdapter adapterForRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.setSupportActionBar((Toolbar) this.findViewById(R.id.toolbar));

        this.photoAlbum = new ArrayList<>();
        this.setupLayout();
    }

    private void setupLayout() {

        this.findViewById(R.id.fab_video).setOnClickListener(this);

        this.findViewById(R.id.fab_camera).setOnClickListener(this);

        RecyclerView photos = (RecyclerView) this.findViewById(R.id.photos_recycler);
        photos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        this.adapterForRecycler = new PhotoAlbumAdapter(this, this.photoAlbum);
        photos.setAdapter(this.adapterForRecycler);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_camera:
                this.launchCamera();
                break;
            case R.id.fab_video:
                this.launchVideoRecorder();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE:
                    this.displayImage();

                    break;
                case RECORD_VIDEO_ACTIVITY_REQUEST_CODE:
                    Toast.makeText(this, "WS not implemented yet", Toast.LENGTH_SHORT).show();
                    break;
            }
        }else{
            Snackbar.make(this.getWindow().getDecorView(), "Operation cancelled", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void launchVideoRecorder() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        File picturesPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        this.videoFile = new File(picturesPath, String.format(VIDEO_FILE_URI, UUID.randomUUID().toString()));

        // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT,  this.videoFile.toURI()); // set the image file name

        // start the image capture Intent
        this.startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    private void launchCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File picturesPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        this.imageFile = new File(picturesPath, String.format(IMAGE_FILE_URI, UUID.randomUUID().toString()));

        // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT,  Uri.fromFile(this.imageFile)); // set the image file name

        // start the image capture Intent
        this.startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    private void displayImage() {
        if(this.imageFile!=null){
            PictureContent pictureContent = new PictureContent();
            pictureContent.setAuthor(this.getString(R.string.dummy_author_label));
            pictureContent.setCreationDate(new Date());
            pictureContent.setUri(Uri.fromFile(this.imageFile).toString());

            this.photoAlbum.add(pictureContent);
            this.adapterForRecycler.notifyDataSetChanged();
        }
    }
}
