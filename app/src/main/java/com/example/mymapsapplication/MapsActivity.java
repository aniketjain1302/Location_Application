package com.example.mymapsapplication;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CustomCap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mymapsapplication.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    final String TAG="GPS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ArrayList<Double> list = (ArrayList<Double>) getIntent().getSerializableExtra("list");
        ArrayList<Double> list2 = (ArrayList<Double>) getIntent().getSerializableExtra("list2");

        Log.d("Lat", String.valueOf(list)+"\n"+list2);
        LatLng Brisbane = new LatLng(list.get(0), list2.get(0));

        int j = list.size() - 1;

        for (int m = 1; m < j; m++) {

            LatLng TamWorth = new LatLng(list.get(m), list2.get(m));
            m+=1;
            LatLng NewCastle = new LatLng(list.get(m), list2.get(m));

            mMap.addPolyline((new PolylineOptions()).add(Brisbane, NewCastle, TamWorth).
                    // below line is use to specify the width of poly line.
                            width(10f)
                    // below line is use to add color to our poly line.
                    .color(Color.RED)).setStartCap(new CustomCap(BitmapDescriptorFactory.fromResource(R.drawable.start),200));
                    // below line is to make our poly line geodesic.
//                    .geodesic(true));
            // on below line we will be starting the drawing of polyline.
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Brisbane, 13));

            Brisbane=NewCastle;

          }

    }

}