package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseReferance;
    private PictureAdapter mPictureAdapter;
    private RecyclerView mRecView;
    private List<Upload> mUpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);


        //defining properties for pictures in Recycler View
        mRecView = findViewById(R.id.recycler_1);
        mRecView.setLayoutManager(new LinearLayoutManager(DatabaseActivity.this));
        mRecView.setHasFixedSize(true);
        mUpl= new ArrayList<>();

        //path to databasefiles. Pictures are saved in "uploads" folder.
        mDatabaseReferance = FirebaseDatabase.getInstance().getReference("uploads");

        mDatabaseReferance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnap) {
            for (DataSnapshot postSnapshot : dataSnap.getChildren()) {
                Upload upload = postSnapshot.getValue(Upload.class);
                mUpl.add(upload);
            }
                mPictureAdapter = new PictureAdapter(DatabaseActivity.this, mUpl);
            mRecView.setAdapter((mPictureAdapter));
            }
            // if error happens display a message
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DatabaseActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

        //brings the user to "addActivity"
    public void startAdd(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}