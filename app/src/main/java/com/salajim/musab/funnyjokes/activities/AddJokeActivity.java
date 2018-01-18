package com.salajim.musab.funnyjokes.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.salajim.musab.funnyjokes.models.AddJokes;
import com.salajim.musab.funnyjokes.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddJokeActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.jokeEditText)
    EditText mJokeEdittext;
    @Bind(R.id.submitButton)
    Button mSubmitButton;

    List<AddJokes> addJokes;
    DatabaseReference databaseAddJokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjoke);
        ButterKnife.bind(this);

        databaseAddJokes = FirebaseDatabase.getInstance().getReference("newJokes");

        mSubmitButton.setOnClickListener(this);
        addJokes = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        if(v == mSubmitButton) {
            addAJoke();
        }

    }

    private void addAJoke() {
        String joke = mJokeEdittext.getText().toString().trim();

        if(!TextUtils.isEmpty(joke)) {
            String id = databaseAddJokes.push().getKey();

            AddJokes addJokes = new AddJokes(id, joke);
            databaseAddJokes.child(id).setValue(addJokes);

            mJokeEdittext.setText("");

            Toast.makeText(this, "Joke added!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Field cannot be empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
