package com.momentoustech.camerasample.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.momentoustech.camerasample.R;
import com.momentoustech.camerasample.adapters.viewholder.PhotoAlbumViewHolder;
import com.momentoustech.camerasample.model.MediaContent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ricardo on 3/16/2016.
 */
public class PhotoAlbumAdapter extends RecyclerView.Adapter<PhotoAlbumViewHolder> {

    private final LayoutInflater inflater;
    private final Collection<MediaContent> items;

    public PhotoAlbumAdapter(Context context, Collection<MediaContent> contentToDrawAsAList) {
        this.inflater = LayoutInflater.from(context);
        this.items = contentToDrawAsAList;
    }

    @Override
    public PhotoAlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = this.inflater.inflate(R.layout.photo_album_picture_item, parent, false);

        return new PhotoAlbumViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(PhotoAlbumViewHolder viewHolder, int position) {
        MediaContent contentItem = ((ArrayList<MediaContent>)this.items).get(position);
        if(contentItem!=null){
            viewHolder.author.setText(contentItem.getAuthor());

            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            viewHolder.creationDate.setText(format.format(contentItem.getCreationDate()));

            viewHolder.image.setImageURI(Uri.parse(contentItem.getUri()));
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
}
