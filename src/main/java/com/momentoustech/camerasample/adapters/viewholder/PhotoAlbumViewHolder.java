package com.momentoustech.camerasample.adapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.momentoustech.camerasample.R;

/**
 * Created by Ricardo on 3/16/2016.
 */
public class PhotoAlbumViewHolder extends RecyclerView.ViewHolder{

    public TextView author;
    public TextView creationDate;
    public ImageView image;

    public PhotoAlbumViewHolder(View itemView) {
        super(itemView);

        this.author = (TextView) itemView.findViewById(R.id.photo_album_picture_author_label);
        this.creationDate = (TextView) itemView.findViewById(R.id.photo_album_picture_creation_date_label);
        this.image = (ImageView) itemView.findViewById(R.id.photo_album_picture_item_image);
    }
}
