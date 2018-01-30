package com.example.novia.semangat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.novia.semangat.adapter.GambarAdapter;
import com.example.novia.semangat.model.Gambar;

import java.util.ArrayList;
import java.util.List;

public class VisitMalang extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recylerView;
    private GambarAdapter mAdapter;
    private List<Gambar> gambarList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_malang);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView btnPenginapan = (ImageView) findViewById(R.id.btnPenginapan);
        btnPenginapan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(VisitMalang.this, DisplayImagesActivity.class);
                startActivity(i);
            }
        });

        ImageView btnPendidikan = (ImageView) findViewById(R.id.btnPendidikan);
        btnPendidikan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i1 = new Intent(VisitMalang.this, DisplayPendidikan.class);
                startActivity(i1);
            }
        });

        ImageView btnKuliner = (ImageView) findViewById(R.id.btnKuliner);
        btnKuliner.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i2 = new Intent(VisitMalang.this, DisplayKuliner.class);
                startActivity(i2);
            }
        });

        ImageView btnWisata = (ImageView) findViewById(R.id.btnWisata);
        btnWisata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i3 = new Intent(VisitMalang.this, DisplayWisata.class);
                startActivity(i3);
            }
        });


        recylerView = (RecyclerView) findViewById(R.id.recyclerGambar);

        mAdapter = new GambarAdapter(gambarList);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(VisitMalang.this, LinearLayoutManager.HORIZONTAL, false);
        recylerView.setLayoutManager(horizontalLayoutManagaer);

        recylerView.setAdapter(mAdapter);
        prepareRiwayatData();

       ImageButton menuBeranda = (ImageButton) findViewById(R.id.imageButton3);
        menuBeranda.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i4 = new Intent(VisitMalang.this, VisitMalang.class);
                startActivity(i4);
            }
        });
        ImageButton menuWisata = (ImageButton) findViewById(R.id.imageButton5);
        menuWisata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i5 = new Intent(VisitMalang.this, DisplayWisata.class);
                startActivity(i5);
            }
        });
        ImageButton menuKuliner = (ImageButton) findViewById(R.id.imageButton4);
        menuKuliner.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i6 = new Intent(VisitMalang.this, DisplayKuliner.class);
                startActivity(i6);
            }
        });
        ImageButton menuPenginapan = (ImageButton) findViewById(R.id.imageButton6);
        menuPenginapan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i7 = new Intent(VisitMalang.this, DisplayImagesActivity.class);
                startActivity(i7);
            }
        });
        ImageButton menuPendidikan = (ImageButton) findViewById(R.id.imageButton7);
        menuPendidikan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i8 = new Intent(VisitMalang.this, DisplayPendidikan.class);
                startActivity(i8);
            }
        });

    }

    private void prepareRiwayatData() {
        Gambar riwayat  = new Gambar(R.drawable.kota);
        gambarList.add(riwayat);
        Gambar riwayat1  = new Gambar(R.drawable.food);
        gambarList.add(riwayat1);
        Gambar riwayat2  = new Gambar(R.drawable.univ);
        gambarList.add(riwayat2);
        Gambar riwayat3  = new Gambar(R.drawable.penginapan2);
        gambarList.add(riwayat3);


        mAdapter.notifyDataSetChanged();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.visit_malang, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
