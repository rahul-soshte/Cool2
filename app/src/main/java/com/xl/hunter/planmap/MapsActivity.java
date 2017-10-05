package com.xl.hunter.planmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //   Vector locations=new Vector();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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
        mMap.setMyLocationEnabled(true);

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
}
