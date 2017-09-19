package com.pandey.learnhindinumbers;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNumberTapped(View view)
    {
        int buttonId = view.getId();
        String musicNameID = view.getResources().getResourceEntryName(buttonId);
        int musicId = getResources().getIdentifier(musicNameID, "raw", "com.pandey.learnhindinumbers");

        stopPlaying();
        mediaPlayer = MediaPlayer.create(this, musicId);
        mediaPlayer.start();
    }

    // stop media player if playing
    private void stopPlaying() {
        Log.i("INDEX", "currentMedia: "+mediaPlayer);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
