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
public class EventsFragment extends Fragment {

    private ArrayList<Location> locationsArray;
    private RecyclerView recyclerView;

    public EventsFragment() {
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
        Location exampleLocation = new Location("Festival d’été", "Every year, the Festival d’été attracts over one million festivalgoers to Sainte-Agathe's historic district for concerts.",
                "Downtown", "1.1 Km", R.drawable.summer);
        Location exampleLocation2 = new Location("Grands Feux Loto", "From the bank of the Red River, enjoy the magnificent show of the Grands Feux Loto-Sainte-Agathe.",
                "Red River Bank", "3.0 Km", R.drawable.fireworks);
        Location exampleLocation3 = new Location("Nouvelle-France", "An entertaining atmosphere, numerous activities for gourmets and 400 shows, reenactments and lectures.",
                "Downtown", "1.9 Km", R.drawable.france);
        Location exampleLocation4 = new Location("Carnaval", "Come experience one of the world's largest winter carnivals in beautiful Sainte-Agathe.",
                "Downtown", "1.8 Km", R.drawable.winter);
        Location exampleLocation5 = new Location("Wine Festival", "On the menu for this major public event: selection of Bordeaux wines, savoury foods grown or made in Sainte-Agathe.",
                "4479 West Portage Avenue", "12.8 Km", R.drawable.wine);

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
