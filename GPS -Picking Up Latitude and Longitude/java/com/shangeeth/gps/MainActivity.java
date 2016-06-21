package com.shangeeth.gpstest;

import android.app.Activity;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    protected String latitude;
    protected String longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn =(Button)findViewById(R.id.button);
        final TextView tv_latitude=(TextView)findViewById(R.id.textView);
        final TextView tv_longitude=(TextView)findViewById(R.id.textView2);
       final GPSTracker gpsTracker=new GPSTracker(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Latitude",String.valueOf(gpsTracker.getLatitude()));
        tv_latitude.setText(String.valueOf(gpsTracker.getLatitude()));
                tv_longitude.setText(String.valueOf(gpsTracker.getLongitude()));


            }
        });

    }
   /* public String[] getLocation(){
        LocationManager service=(LocationManager)getSystemService(LOCATION_SERVICE);
        Criteria criteria= new Criteria();
        String best= service.getBestProvider(criteria,true);
        Location location=service.getLastKnownLocation(best);
        boolean enabled=service.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(!enabled)
        {
            Intent in=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(in);
            latitude="Not set";
            longitude="Not set";
        }
        else{
            latitude=String.valueOf(location.getLatitude());
            longitude=String.valueOf(location.getLongitude());
        }
        String[] array= new String[2];
        array[0]=latitude;
        array[1]=longitude;
        return array;
    }*/
}
