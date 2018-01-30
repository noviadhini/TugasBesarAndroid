package com.example.novia.semangat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.novia.semangat.adapter.GambarAdapter;
import com.example.novia.semangat.model.Gambar;

import java.util.ArrayList;
import java.util.List;


public class OneFragment extends Fragment  implements NavigationView.OnNavigationItemSelectedListener
{
    Activity activity;
    private RecyclerView productListView;
    private GambarAdapter mAdapter;
    List<Gambar> products;
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_one, container, false);
       // prepareRiwayatData();
        View view = inflater.inflate(R.layout.fragment_one, container, false);
//        recylerView = (RecyclerView) container.findViewById(R.id.recyclerGambar);
    //        productListView = (RecyclerView) view.findViewById(R.id.recyclerGambar);
    //
    //        mAdapter = new GambarAdapter(products);
    //        productListView.setAdapter(mAdapter);
    //        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
    //        productListView.setLayoutManager(horizontalLayoutManagaer);





//        recylerView.setAdapter(mAdapter);
        prepareRiwayatData();



        ImageView btnPenginapan = (ImageView) view.findViewById(R.id.btnWisata);
        btnPenginapan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), DisplayImagesActivity.class);
                startActivity(i);
            }
        });

        ImageView btnPendidikan = (ImageView) view.findViewById(R.id.btnWisata);
        btnPendidikan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), DisplayPendidikan.class);
                startActivity(i);
            }
        });

        ImageView btnKuliner = (ImageView) view.findViewById(R.id.btnWisata);
        btnKuliner.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), DisplayKuliner.class);
                startActivity(i);
            }
        });

        ImageView btnWisata = (ImageView) view.findViewById(R.id.btnWisata);
        btnWisata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), DisplayWisata.class);
                startActivity(i);
            }
        });

        return view;






    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private void prepareRiwayatData()
    {
        Gambar riwayat  = new Gambar(R.drawable.kota);

        Gambar riwayat1  = new Gambar(R.drawable.food);

        Gambar riwayat2  = new Gambar(R.drawable.univ);

        Gambar riwayat3  = new Gambar(R.drawable.penginapan2);

//        mAdapter.notifyDataSetChanged();

        products = new ArrayList<Gambar>();
        products.add(riwayat);
        products.add(riwayat1);
        products.add(riwayat2);
        products.add(riwayat3);


    }
}
