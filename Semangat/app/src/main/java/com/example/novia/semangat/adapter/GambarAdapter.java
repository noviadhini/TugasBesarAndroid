package com.example.novia.semangat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.novia.semangat.R;
import com.example.novia.semangat.model.Gambar;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 1/22/2018.
 */

public class GambarAdapter extends RecyclerView.Adapter<GambarAdapter.MyViewHolder>
{
    List<Gambar> list;

    public GambarAdapter(List<Gambar> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gambar,parent,false);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.isigambar,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Gambar gambar = this.list.get(position);
        holder.gambar.setImageResource(gambar.getPhotoid());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView gambar;
        public MyViewHolder(View itemView)
        {
            super(itemView);

            gambar = (ImageView) itemView.findViewById(R.id.btnWisata);
        }
    }
}
