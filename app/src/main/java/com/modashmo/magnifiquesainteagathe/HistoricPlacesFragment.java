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
 * Created by Mauricio recyclerViewClickListener May 14, 2017
 * <p>
 * Udacity Android Basics Nanodegree
 * Project 6: Tour App
 */
public class HistoricPlacesFragment extends Fragment {

    private ArrayList<Location> locationsArray;
    private RecyclerView recyclerView;

    public HistoricPlacesFragment() {
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
        Location exampleLocation = new Location("Schooly McSchoolface", "A school, with teachers and students, where they spend the day doing school things.",
                "123 School Way", "3.7 Km", R.drawable.image_placeholder);
        Location exampleLocation2 = new Location("Shopping McSpendface", "A shopping where people spend the money they don't have recyclerViewClickListener stuff they don't need in order to fulfill their hopeless dreams.",
                "123 Loser Drive", "9.3 Km", R.drawable.image_placeholder);
        Location exampleLocation3 = new Location("Museum McOldface", "A museum with a bunch of old stuff however important history of our old society.", "123 Medieval Place",
                "1.2 Km", R.drawable.image_placeholder);
        Location exampleLocation4 = new Location("Gas McStationface", "A place where people like to feed their vroom vrooms.", "123 Pollution Avenue",
                "10.5 Km", R.drawable.image_placeholder);
        Location exampleLocation5 = new Location("Botchoco McFluffyface", "A place where botchocos like to hangout and do botchoquices. Rafael owns the place.", "123 McFaggot Street",
                "0.7 Km", R.drawable.image_placeholder);

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
