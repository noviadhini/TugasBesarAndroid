package com.example.novia.semangat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.novia.semangat.adapter.RecyclerViewAdapterWis;
import com.example.novia.semangat.model.ImageUploadInfoWis;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayWisata extends AppCompatActivity {

    // Creating DatabaseReference.
    DatabaseReference databaseReference;

    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter ;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    // Creating List of ImageUploadInfo class.
    List<ImageUploadInfoWis> listview = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_wisata);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        // Assign id to RecyclerView.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);

        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayWisata.this));

        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(DisplayWisata.this);

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        String namaS = "wisata";
//        myRef = FirebaseDatabase.getInstance().getReference(namaT);
        databaseReference = FirebaseDatabase.getInstance().getReference(namaS);

        // Adding Add Value Event Listener to databaseReference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    ImageUploadInfoWis ImageUploadInfoWis = postSnapshot.getValue(ImageUploadInfoWis.class);

                    listview.add(ImageUploadInfoWis);
                }

                adapter = new RecyclerViewAdapterWis(getApplicationContext(), listview);

                recyclerView.setAdapter(adapter);

                // Hiding the progress dialog.
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });

        ImageButton menuBeranda = (ImageButton) findViewById(R.id.imageButton3);
        menuBeranda.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i4 = new Intent(DisplayWisata.this, VisitMalang.class);
                startActivity(i4);
            }
        });
        ImageButton menuWisata = (ImageButton) findViewById(R.id.imageButton5);
        menuWisata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i5 = new Intent(DisplayWisata.this, DisplayWisata.class);
                startActivity(i5);
            }
        });
        ImageButton menuKuliner = (ImageButton) findViewById(R.id.imageButton4);
        menuKuliner.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i6 = new Intent(DisplayWisata.this, DisplayKuliner.class);
                startActivity(i6);
            }
        });
        ImageButton menuPenginapan = (ImageButton) findViewById(R.id.imageButton6);
        menuPenginapan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i7 = new Intent(DisplayWisata.this, DisplayImagesActivity.class);
                startActivity(i7);
            }
        });
        ImageButton menuPendidikan = (ImageButton) findViewById(R.id.imageButton7);
        menuPendidikan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i8 = new Intent(DisplayWisata.this, DisplayPendidikan.class);
                startActivity(i8);
            }
        });

    }
}
