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
public class ShoppingFragment extends Fragment {

    private ArrayList<Location> locationsArray;
    private RecyclerView recyclerView;

    public ShoppingFragment() {
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
        Location exampleLocation = new Location("Farmer's Market", "Are you passionate about supporting local? Do you love a good farmers’ market?  This is the place for you!",
                "12 School Way", "3.7 Km", R.drawable.farmers);
        Location exampleLocation2 = new Location("Laurier Mall", "265 stores showcasing the latest fashion, tech and lifestyle trends, 35 assorted restaurants and many special events.",
                "1669 La Salle Drive", "9.3 Km", R.drawable.laurier);
        Location exampleLocation3 = new Location("Shopping Beauport", "In the heart of beautiful Sainte-Agathe, it offers a distinguished contemporary brands and unique boutiques.",
                "589 Hampshire Avenue", "1.2 Km", R.drawable.beauport);
        Location exampleLocation4 = new Location("Galleria Centre", "Your community shopping centre. Connect. Discover. Shop.",
                "1212B Pollution Avenue", "10.5 Km", R.drawable.galleria);
        Location exampleLocation5 = new Location("Botchoco", "Botchoco Mall highlights a dynamic mix of popular, brand name and specialty retail in one convenient, easily accessible location.",
                "2424 McFluffy Street", "0.7 Km", R.drawable.botchoco);

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
