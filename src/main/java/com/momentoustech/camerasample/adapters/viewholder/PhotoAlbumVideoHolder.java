package com.momentoustech.camerasample.adapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.momentoustech.camerasample.R;
import com.momentoustech.camerasample.adapters.PhotoAlbumAdapter;

/**
 * Created by Ricardo on 3/16/2016.
 */
public class PhotoAlbumVideoHolder extends PhotoAlbumHolder{

    public final ImageButton playVideoButton;


    public PhotoAlbumVideoHolder(View itemView) {
        super(itemView);

        this.author = (TextView) itemView.findViewById(R.id.photo_album_video_item_author_label);
        this.creationDate = (TextView) itemView.findViewById(R.id.photo_album_video_item_creation_date_label);
        this.thumbnail = (ImageView) itemView.findViewById(R.id.photo_album_video_item_thumbnail);
        this.playVideoButton = (ImageButton) itemView.findViewById(R.id.photo_album_video_item_play);
    }
}
