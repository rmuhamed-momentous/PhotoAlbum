package com.momentoustech.camerasample.adapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ricardo on 3/17/2016.
 */
public class PhotoAlbumHolder extends RecyclerView.ViewHolder {
    public TextView author;
    public TextView creationDate;
    public ImageView thumbnail;

    public PhotoAlbumHolder(View itemView) {
        super(itemView);
    }
}
