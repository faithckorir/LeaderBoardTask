package com.finixtore.leaderboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ScoreboardAdapter mScoreboardAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<Person> personScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.leaderboardrv);
        mScoreboardAdapter=new ScoreboardAdapter();
        personScores=new ArrayList<>();

        Person person=new Person("fay","123");
        personScores.add(person);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mScoreboardAdapter);
        DataFromFireBase();


    }
    public void DataFromFireBase(){
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if (dataSnapshot.exists()){
                    String name = dataSnapshot.child("name").getValue().toString();
                    String points = dataSnapshot.child("points").getValue().toString();
                    Log.d("onChildAdded: ",name);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
