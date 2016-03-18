package com.momentoustech.camerasample.model;

import android.net.Uri;

import java.util.Date;

/**
 * Created by Ricardo on 3/16/2016.
 */
public class VideoContent extends MediaContent{
    private int duration;
    private int quality;


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
