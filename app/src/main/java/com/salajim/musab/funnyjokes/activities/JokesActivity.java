package com.salajim.musab.funnyjokes.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.salajim.musab.funnyjokes.R;
import com.salajim.musab.funnyjokes.adapters.PagerAdapter;
import com.salajim.musab.funnyjokes.models.AddJokes;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JokesActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ArrayList<AddJokes> mAddJokes = new ArrayList<>();
    private PagerAdapter mPagerAdapter;

    FirebaseDatabase database;
    DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        ButterKnife.bind(this);

        //We pull out our ArrayList<Product> Parcelable using the unwrap() method
        mAddJokes = Parcels.unwrap(getIntent().getParcelableExtra("addJokes"));

        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("newJokes");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    mAddJokes.add(dataSnapshot1.getValue(AddJokes.class));
                }

                int startingPosition = getIntent().getIntExtra("position", 0);
                mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mAddJokes);
                mViewPager.setAdapter(mPagerAdapter);
                mViewPager.setCurrentItem(startingPosition);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
