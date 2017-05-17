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
public class FoodFunFragment extends Fragment {

    private ArrayList<Location> locationsArray;
    private RecyclerView recyclerView;

    public FoodFunFragment() {
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
        Location exampleLocation = new Location("Chez Victor", "Chez Victor offers its customers good food and good music at the same time. This restaurant prides itself on its menu.",
                "43 Lemoine Way", "3.7 Km", R.drawable.chez_victor);
        Location exampleLocation2 = new Location("Dagobert", "There is no defined dance floor here so that makes pretty much everything fair. Dance on the tables, booths, chairs.",
                "1036 Abbe Drive", "9.3 Km", R.drawable.dagobert);
        Location exampleLocation3 = new Location("Le Lepin Saute", "Located near the majestic Chateau du Cheyenne, Le Lepin Saute Restaurant offers a country elegance.",
                "1443 Medieval Place", "1.2 Km", R.drawable.le_lepin_saute);
        Location exampleLocation4 = new Location("La Drage Cabaret", "Head down to the Cartier Park to experience the hottest nightlife in Sainte-Agathe!", "77 Main Street",
                "10.5 Km", R.drawable.la_drage_cabaret);
        Location exampleLocation5 = new Location("Saint Amour", "Saint-Amour serves the best seafood particularly fresh fish, clams and oysters.", "702 Courcelles Street",
                "0.7 Km", R.drawable.saint_amour);

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
