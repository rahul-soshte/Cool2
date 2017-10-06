package com.xl.hunter.planmap;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
ArrayList<CenterPlaces> object;
    private GoogleMap mMap;
    //   Vector locations=new Vector();
    ArrayList<Marker> markers=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        object = (ArrayList<CenterPlaces>) args.getSerializable("ARRAYLIST");


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    /*

    public void onMapSearch(View view) {
        EditText locationSearch = (EditText) findViewById(R.id.editText);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;
        if ( location!= null || !location.equals("")) {
            Geocoder geocoder=new Geocoder(this);
            try{
                addressList=geocoder.getFromLocationName(location, 1);

            }catch(IOException e){
                e.printStackTrace();
            }
            Address address=addressList.get(0);
            LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }

    */
    public void onFindCenter(View view)
    {

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
        PlotUserPoints();
/*
        // Add a marker in Sydney and move the camera
        LatLng Chembur = new LatLng(19.062053, 72.883436);
        LatLng Mulund = new LatLng(19.172554, 72.942554);
        LatLng Dadar = new LatLng(19.021324, 72.842418);
        LatLng CST = new LatLng(18.941067, 72.836639);
        mMap.addMarker(new MarkerOptions().position(Chembur).title("Chembur"));
        mMap.addMarker(new MarkerOptions().position(Mulund).title("Mulund"));
        mMap.addMarker(new MarkerOptions().position(Dadar).title("Dadar"));
        mMap.addMarker(new MarkerOptions().position(CST).title("CST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chembur));

        LatLngBounds bound = new LatLngBounds(CST, Mulund);


        bound.including(Chembur);
        bound.including(Dadar);
        LatLng centroid;


        centroid = bound.getCenter();
        mMap.addMarker(new MarkerOptions().position(centroid).title("Centroid"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        */
//        mMap.setMyLocationEnabled(true);

//Vector locations=new Vector();
// getcenter
//LatLng //getcenter
// OTHER CODE
//LatLng object
        //Vector to store the LatLng object
        //Vector locations=new Vector();
        //locations.addElement(LatLng);
        //LatLng Centroid= new LatLng();
        //Centroid=bound.getCenter();
        //mMap.addMarker(new MarkerOptions().position(Centroid).title("Centroid"));

        //Vector to store the LatLng object
        //Vector locations=new Vector(LatLng);
        //locations.addElement(LatLng);
    }
    public void PlotUserPoints()
    {
        if(!object.isEmpty() && object !=null )
        {
            for(int i=0;i<object.size();i++)
            {
              //  user_coordinates.get(i).getGpsLat();
                LatLng latLng = new LatLng(object.get(i).getLatitude(),object.get(i).getLongitude());

                Marker marker=mMap.addMarker(new MarkerOptions().position(latLng).title(object.get(i).getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                markers.add(marker);

                // mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            }

        }

        if(markers.size()==1)
        {

            CameraPosition cameraPosition=new CameraPosition.Builder().target(markers.get(0).getPosition()).zoom(12).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
  //          String type="Suggestion";
//            new GetCenterofUsers().execute(type,Double.toString(markers.get(0).getPosition().latitude),Double.toString(markers.get(0).getPosition().longitude));
        }
        else {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();

            for (Marker marker : markers) {

                builder.include(marker.getPosition());

            }

            LatLngBounds bounds = builder.build();

            int padding = 50; // offset from edges of the map in pixels

            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);

            mMap.animateCamera(cu);

            LatLng latLng;

            latLng = bounds.getCenter();

            mMap.addMarker(new MarkerOptions().position(latLng).title("Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        }
    }
}
