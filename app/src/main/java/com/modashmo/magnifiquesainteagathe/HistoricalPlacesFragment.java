package com.modashmo.magnifiquesainteagathe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Magnifique Sainte-Agathe
 * Created by Mauricio on May 14, 2017
 * <p>
 * Udacity Android Basics Nanodegree
 * Project 6: Tour App
 */
public class HistoricalPlacesFragment extends Fragment {

    private ArrayList<Location> locationsArray;
    private RecyclerView recyclerView;

    public HistoricalPlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initialiseData();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        // Create the RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        // Create the LinearLayoutManager to be used with the RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        // Attach the LinearLayoutManager to the RecyclerView
        recyclerView.setLayoutManager(linearLayoutManager);
        // Create custom adapter
        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(locationsArray, recyclerViewClickListener);
        // Set the adapter correctly to display information to the user
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void initialiseData() {
        // Create instances of Location class. This would be ideally fetched remotely via RESTful API, however this is not the intent of this exercise.
        // strings.xml were also not used ON PURPOSE for the creation of he objects, given the first statement above.
        Location exampleLocation = new Location("Old Sainte-Agathe", "History is everywhere in Sainte-Agathe, down on every street, at every monument and inside every historical building.",
                "Downtown", "0.2 Km", R.drawable.walls);
        Location exampleLocation2 = new Location("French & British", "Explore the visible signs of the two major nations who built the city and region of Sainte-Agathe.",
                "12 Rivier Drive", "1.3 Km", R.drawable.french_british);
        Location exampleLocation3 = new Location("The Citadel", "A key part of the city's fortifications, the star-shaped Citadel showcases Sainte-Agathe's military history.",
                "69 Hiver Place", "1.7 Km", R.drawable.citadel);
        Location exampleLocation4 = new Location("New France Festival", "Early August is the time to be whisked back to the days of New France in the authentic surroundings of Sainte-Agathe.",
                "Downtown", "0.5 Km", R.drawable.new_france);
        Location exampleLocation5 = new Location("Religious Tourism", "Churches are to Sainte-Agathe what castles are to Europe: architectural marvels.",
                "666 McDermot Street", "7.1 Km", R.drawable.religious);

        // Initiate an ArrayList with the objects created above
        locationsArray = new ArrayList<>(Arrays.asList(exampleLocation, exampleLocation2, exampleLocation3, exampleLocation4, exampleLocation5));
    }

    CustomRecyclerViewAdapter.OnItemClickListener recyclerViewClickListener = new CustomRecyclerViewAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Location item) {
            // Toast for testing purposes only -- it should call a new Activity with detailed description
            Toast.makeText(getContext(), item.getLocationName(), Toast.LENGTH_SHORT).show();
        }
    };

}
