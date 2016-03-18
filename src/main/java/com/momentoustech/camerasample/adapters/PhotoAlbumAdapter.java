package com.momentoustech.camerasample.adapters;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.momentoustech.camerasample.R;
import com.momentoustech.camerasample.adapters.viewholder.PhotoAlbumHolder;
import com.momentoustech.camerasample.adapters.viewholder.PhotoAlbumPictureHolder;
import com.momentoustech.camerasample.adapters.viewholder.PhotoAlbumVideoHolder;
import com.momentoustech.camerasample.model.MediaContent;
import com.momentoustech.camerasample.model.VideoContent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by Ricardo on 3/16/2016.
 */
public class PhotoAlbumAdapter extends RecyclerView.Adapter<PhotoAlbumHolder> {

    private static final int VIDEO_ITEM = 1;
    private static final int PICTURE_ITEM = 2;
    private static final String DATE_FORMAT_PATTERN = "dd-MM-yyyy";

    private final LayoutInflater inflater;
    private final Collection<MediaContent> items;
    private final ContentResolver contentResolver;

    public PhotoAlbumAdapter(Context context, Collection<MediaContent> contentToDrawAsAList) {
        this.inflater = LayoutInflater.from(context);
        this.items = contentToDrawAsAList;
        this.contentResolver = context.getContentResolver();
    }

    @Override
    public PhotoAlbumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PhotoAlbumHolder holder = null;

        switch (viewType){
            case VIDEO_ITEM:
                holder = new PhotoAlbumVideoHolder(this.inflater.inflate(R.layout.photo_album_video_item, parent, false));
                break;
            case PICTURE_ITEM:
                holder = new PhotoAlbumPictureHolder(this.inflater.inflate(R.layout.photo_album_picture_item, parent, false));
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(PhotoAlbumHolder viewHolder, int position) {
        MediaContent contentItem = ((ArrayList<MediaContent>)this.items).get(position);

        viewHolder.author.setText(contentItem.getAuthor());

        DateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.getDefault());
        viewHolder.creationDate.setText(format.format(contentItem.getCreationDate()));

        if(viewHolder instanceof PhotoAlbumVideoHolder){
            viewHolder.thumbnail.setImageBitmap(ThumbnailUtils.createVideoThumbnail(contentItem.getUri(), MediaStore.Video.Thumbnails.MINI_KIND));

            ((PhotoAlbumVideoHolder) viewHolder).playVideoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: RM - Invoke VideoInFullScreenActivity
                }
            });
        }else{
            viewHolder.thumbnail.setImageURI(Uri.parse(contentItem.getUri()));
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if(this.items !=null && this.items.size()>0){
            count = this.items.size();
        }

        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int viewType;
        MediaContent aMediaContent = ((ArrayList<MediaContent>)this.items).get(position);

        if (aMediaContent instanceof VideoContent){
            viewType = VIDEO_ITEM;
        }else{
            viewType = PICTURE_ITEM;
        }

        return viewType;
    }
}
