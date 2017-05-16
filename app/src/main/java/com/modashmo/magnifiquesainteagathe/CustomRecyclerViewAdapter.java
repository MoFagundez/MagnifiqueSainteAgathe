package com.modashmo.magnifiquesainteagathe;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Magnifique Sainte-Agathe
 * Created by Mauricio on May 14, 2017
 * <p>
 * Udacity Android Basics Nanodegree
 * Project 6: Tour App
 */

class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.LocationViewHolder> {

    static class LocationViewHolder extends RecyclerView.ViewHolder{

        // Class variables goes here
        CardView cardView;
        TextView nameTextView;
        TextView descriptionTextView;
        TextView addressTextView;
        TextView distanceTextView;
        ImageView imageItem;

        LocationViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);

            nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);

            descriptionTextView = (TextView) itemView.findViewById(R.id.description_text_view);

            addressTextView = (TextView) itemView.findViewById(R.id.address_text_view);

            distanceTextView = (TextView) itemView.findViewById(R.id.distance_text_view);

            imageItem = (ImageView) itemView.findViewById(R.id.image_item);
        }
    }

    private ArrayList<Location> locationsArray = new ArrayList<>();

    CustomRecyclerViewAdapter(ArrayList<Location> locationsArray) {
        this.locationsArray = locationsArray;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_view, parent, false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        holder.nameTextView.setText(locationsArray.get(position).getLocationName());
        holder.descriptionTextView.setText(locationsArray.get(position).getLocationDescription());
        holder.addressTextView.setText(locationsArray.get(position).getLocationAddress());
        holder.distanceTextView.setText(locationsArray.get(position).getLocationDistance());
        holder.imageItem.setImageResource(locationsArray.get(position).getLocationImage());
    }

    @Override
    public int getItemCount() {
        return locationsArray.size();
    }

}
