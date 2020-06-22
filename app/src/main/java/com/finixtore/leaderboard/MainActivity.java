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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ScoreboardAdapter mScoreboardAdapter;
    private RecyclerView mRecyclerView;
     ArrayList<Person> personScores;

    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.leaderboardrv);
        mScoreboardAdapter=new ScoreboardAdapter();
        mDatabaseReference= FirebaseDatabase.getInstance().getReference("shop");

     personScores =new ArrayList<>();

        DataFromFireBase();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);

        System.out.println("size"+personScores.size());
        Person fay=new Person("fat","123");
        Person fay1=new Person("fat","123");Person fay2=new Person("fat","123");
       /* personScores.add(fay);
        personScores.add(fay1);
        personScores.add(fay2);
        mScoreboardAdapter.setNotes(personScores);*/

        mRecyclerView.setAdapter(mScoreboardAdapter);



    }
    public void DataFromFireBase(){



        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            ArrayList<Person> test=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("reached here 1");

                for(DataSnapshot templateSnapshot : dataSnapshot.getChildren()){
                    //for(DataSnapshot snap : templateSnapshot.getChildren()){
                    Person person=templateSnapshot.getValue(Person.class);
                    if (person.name!=null&&person.points!=null){
                        System.out.println(person.name);
//personScores.add(person);
                            test.add(person);

                    // }
                }
            }

                mScoreboardAdapter.setNotes(test);
                System.out.println("size test"+personScores.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });
    }
}
