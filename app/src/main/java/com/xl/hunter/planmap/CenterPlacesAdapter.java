package com.xl.hunter.planmap;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 6/10/17.
 */

public class CenterPlacesAdapter extends RecyclerView.Adapter<CenterPlacesAdapter.MyViewHolder> {
    private List<CenterPlaces> centerPlaces;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, year, genre;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);

            }
    }
    public CenterPlacesAdapter(List<CenterPlaces> centerPlaces) {
        this.centerPlaces = centerPlaces;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      //  Movie movie = moviesList.get(position);

        CenterPlaces centerPlaces1=centerPlaces.get(position);
        holder.name.setText(centerPlaces1.getName());

    }

    @Override
    public int getItemCount() {
        return centerPlaces.size();
    }
}
