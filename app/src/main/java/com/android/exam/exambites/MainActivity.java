package com.android.exam.exambites;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SurfaceView mCameraView;
    TextView mTextView;
    CameraSource mCameraSource;

    private static final String TAG = "MainActivity";
    private static final int requestPermissionID = 101;
    Chapters chapters;
    List<Topics> topics;
    Topics topic;
    StringBuilder sb;
    animationspath apth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mCameraView = findViewById(R.id.surfaceView);
        mTextView = findViewById(R.id.text_view);
        topics=new ArrayList<Topics>();
        //topic=new Topics("Accuracy Vs Precision Audio Story","https://firebasestorage.googleapis.com/v0/b/cheklist-1b8ba.appspot.com/o/level%2F9th%2Fchapters%2Fchapter1%2FAccuracy%20vs%20Precision%20Audio%20Story.mp4?alt=media&token=7fc2851a-78d1-45b5-825e-531c2e487a9e");
        //topics.add(topic);
        apth=new animationspath();
        topics=apth.getanimationslit();
                //chapters=new Chapters("Chapter One",topics);
        startCameraSource();
    }
    public void runmy(){
        Intent intent=new Intent(this,player.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != requestPermissionID) {
            Log.d(TAG, "Got unexpected permission result: " + requestCode);
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            try {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mCameraSource.start(mCameraView.getHolder());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void startCameraSource() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // yourMethod();
                runmy();
            }
        }, 5000);
        //Create the TextRecognizer
        final TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();

        if (!textRecognizer.isOperational()) {
            Log.w(TAG, "Detector dependencies not loaded yet");
        } else {

            //Initialize camerasource to use high resolution and set Autofocus on.
            mCameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280, 1024)
                    .setAutoFocusEnabled(true)
                    .setRequestedFps(2.0f)
                    .build();

            /**
             * Add call back to SurfaceView and check if camera permission is granted.
             * If permission is granted we can start our cameraSource and pass it to surfaceView
            */
            mCameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    try {

                        if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    requestPermissionID);
                            return;
                        }
                        mCameraSource.start(mCameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    mCameraSource.stop();
                }
            });

            //Set the TextRecognizer's Processor.
            textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
                @Override
                public void release() {

                }/**
                 * Detect all the text from camera using TextBlock and the values into a stringBuilder
                 * which will then be set to the textView.
                 * */
                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {
                    final SparseArray<TextBlock> items = detections.getDetectedItems();
//                    sb=new StringBuilder();
//
//                    for (int i = 0; i < items.size(); ++i) {
//                        TextBlock item = items.valueAt(i);
//                        if (item != null && item.getValue() != null) {
//                            sb.append(item.getValue());
//                            sb.append(",");
//
//                        }
                    }
//                    List<Topics> list=new ArrayList();
//                    if(sb!=null) {
//                        String s = sb.toString();
//                        Log.d("like",s);
//
//                        String[] listofallwords = s.split(",");
//                        if(s.toLowerCase().contains("physics") || "physics".contains(s.toLowerCase())){
//                            Intent intent=new Intent(getApplicationContext(),player.class);
//                            intent.putExtra("path","android.resource://" + getPackageName() + "/" +R.raw.whatisphysics);
//                            startActivity(intent);
//                            Thread thread=Thread.currentThread();
//                            thread.destroy();
//                            finish();
//
//                        }

//                        if (listofallwords.length == 1) {

//                        for (int word = 0; word < topics.size(); word++) {
//                            if (listofallwords[word].toLowerCase().contains(topics.get(word).topicName.toLowerCase())) {
//                                    s="";
//                                    sb=new StringBuilder();
//                                   // finish();
//                                    Intent intent = new Intent(getApplicationContext(), player.class);
//                                    intent.putExtra("path", topics.get(word).topicPath);
//                                    startActivity(intent);
//                                    MainActivity.this.finish();
//                                    Thread thread=Thread.currentThread();
//                                    thread.destroy();
//                                    break;
//                            }
//                        }
//                        } else if (listofallwords.length > 0) {
//                         //   mCameraSource.stop();
//                            s="";
//                            sb=new StringBuilder();
//
//                            MainActivity.this.finish();
//                            finish();
//                            Intent j = new Intent(getApplicationContext(), Listshow.class);
//                            j.putExtra("list", listofallwords);
//                            startActivity(j);
//                            Thread thread=Thread.currentThread();
//                            thread.destroy();
//
//                        }
//                    }

//                }
            });
        }
    }
}