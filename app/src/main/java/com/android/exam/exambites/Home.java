package com.android.exam.exambites;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
GridLayout gridLayout;
private  static final int internet=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        float config = ( metrics.widthPixels * 160 ) / metrics.xdpi;
        if (metrics.widthPixels <=480) {
            setContentView(R.layout.activity_home_w480dp);
            //Toast.makeText(this,"zero",Toast.LENGTH_LONG).show();
        } else if(config <=720){
            setContentView(R.layout.activity_home_w720dp);
            //Toast.makeText(this, "onee is working",Toast.LENGTH_LONG).show();
        }
        else if(config <= 768){
            setContentView(R.layout.activity_home_768dp);
            //Toast.makeText(this, "two is working",Toast.LENGTH_LONG).show();
        }
        else if(config <=1080){
            setContentView(R.layout.activity_home_1080dp);
            //Toast.makeText(this, "three is working",Toast.LENGTH_LONG).show();
        }
        else if(config <=1440){
            setContentView(R.layout.activity_home_1440dp);
            //Toast.makeText(this, "four is working",Toast.LENGTH_LONG).show();
        }
        else {
            setContentView(R.layout.activity_home_w480dp);
            //Toast.makeText(this, "five is working",Toast.LENGTH_LONG).show();
        }

        gridLayout=(GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);
    }


    public void startplayer(View v){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.INTERNET},internet);
            }
        }
        boolean connected=inetavail();
        if(connected) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
//            Toast.makeText(this,"Comming Soon",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"You need to connetc to internet!",Toast.LENGTH_LONG).show();

        }


    }

    private boolean inetavail(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();
    }
    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            final CardView cardView=(CardView)gridLayout.getChildAt(i);

            final int finalI= i;



            cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CardView cardView1=(CardView)view;
                        LinearLayout linearLayout=(LinearLayout) cardView.getChildAt(0);
                        TextView textView=(TextView)linearLayout.getChildAt(1);
                        if (textView.getText().toString().equals("Physics")) {
                            Intent lis = new Intent(getApplicationContext(), Liss.class);
                            startActivity(lis);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Comming Soon",Toast.LENGTH_LONG).show();
                        }
                    }
                });

        }
    }
}
