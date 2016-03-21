package com.momentoustech.camerasample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.momentoustech.camerasample.model.VideoContent;

/**
 * Created by Ricardo on 3/18/2016.
 */
public class PlayVideoActivity extends AppCompatActivity {
    private VideoContent videoContent;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        this.setContentView(R.layout.activity_play_video);

        this.getVideoContentFromExtras();

        VideoView v = (VideoView) findViewById(R.id.video_player);

    }

    private void getVideoContentFromExtras() {
        if(this.getIntent().getExtras()!=null && !this.getIntent().getExtras().isEmpty()){

        }
    }


}
