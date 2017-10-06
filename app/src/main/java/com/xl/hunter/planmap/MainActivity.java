package com.xl.hunter.planmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
private List<CenterPlaces> centerPlaces=new ArrayList<>();
    private RecyclerView recyclerView;
    private CenterPlacesAdapter mAdapter;
    Button findCenter;
    CenterPlaces centerPlacesObj;

    private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findCenter=(Button)findViewById(R.id.button2);
        findCenter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!centerPlaces.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST", (Serializable) centerPlaces);
                    intent.putExtra("BUNDLE", args);
                    //intent.putExtra("centerPlaces",centerPlaces);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"No Added Place",Toast.LENGTH_SHORT).show();
                }

            }
        });

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName());
                LatLng placeone=place.getLatLng();
                centerPlaces.add(new CenterPlaces((place.getName()).toString(),placeone.longitude,placeone.latitude));
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        mAdapter = new CenterPlacesAdapter(centerPlaces);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
}
