package com.salajim.musab.funnyjokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Musab on 1/17/2018.
 */

public class NewJokesFragment extends Fragment {
    public static final String TAG = "NewJokesFragment";

    FirebaseDatabase database;
    DatabaseReference mRef;
    private ArrayList<AddJokes> mAddJokes = new ArrayList<>();
    private JokesAdapter mAdapter;

    RecyclerView recyclerView;

    public NewJokesFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_jokes, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("newJokes");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    mAddJokes.add(dataSnapshot1.getValue(AddJokes.class));
                }

                mAdapter = new JokesAdapter(getActivity(), mAddJokes);
                recyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }
}
