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
public class PhotoAlbumPictureHolder extends PhotoAlbumHolder{


    public PhotoAlbumPictureHolder(View itemView) {
        super(itemView);

        this.author = (TextView) itemView.findViewById(R.id.photo_album_picture_author_label);
        this.creationDate = (TextView) itemView.findViewById(R.id.photo_album_picture_creation_date_label);
        this.thumbnail = (ImageView) itemView.findViewById(R.id.photo_album_picture_item_image);
    }
}
