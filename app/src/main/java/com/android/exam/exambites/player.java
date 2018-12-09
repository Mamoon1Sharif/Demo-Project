package com.android.exam.exambites;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class player extends AppCompatActivity {
String path;
    VideoView videoView;
    MediaController mediaController;
    BackgroundAsyncTask bt;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        videoView =(VideoView)findViewById(R.id.videoView);
        mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        //Uri uri=Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.accuracyprecision);
        Intent i = getIntent();
        path = i.getStringExtra("path");
        dialog=new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.loading);
        bt= new BackgroundAsyncTask();
        String newpath="android.resource://" + getPackageName()+"/"+R.raw.newtonsecondlawofmotion;
//        bt.execute(path);
        bt.execute(newpath);

    }
    @Override
    public void onBackPressed() {
        bt.cancel(true);
        this.finish();
    }

    public class BackgroundAsyncTask extends AsyncTask<String, Uri, Void> {
        Integer track = 0;
        ProgressDialog dialog;

        protected void onPreExecute() {
            dialog = new ProgressDialog(player.this);
            dialog.setMessage("Loading, Please Wait...");
            dialog.setCancelable(true);
            dialog.show();
        }

        protected void onProgressUpdate(final Uri... uri) {

            try {
                videoView.setVideoURI(uri[0]);
                videoView.setMediaController(mediaController);
                videoView.requestFocus();
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                    public void onPrepared(MediaPlayer arg0) {
                        videoView.start();
                        dialog.dismiss();
                    }
                });


            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }


        @Override
        protected Void doInBackground(String... params) {
            try {
                Uri uri = Uri.parse(params[0]);

                publishProgress(uri);
            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
//                    Intent intent=new Intent(getApplicationContext(),Quiz.class);
//                    startActivity(intent);
                    finish();
                }
            });

        }
    }
}
