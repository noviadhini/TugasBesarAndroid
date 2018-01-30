package com.example.novia.semangat.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.novia.semangat.DetailPendidikan;
import com.example.novia.semangat.R;
import com.example.novia.semangat.model.ImageUploadInfoPen;


import java.util.List;

/**
 * Created by TOSHIBA-97 on 1/27/2018.
 */

public class RecyclerViewAdapterPen extends RecyclerView.Adapter<RecyclerViewAdapterPen.ViewHolder> {

    Context context;
    List<ImageUploadInfoPen> MainImageUploadInfoListPen;

    public RecyclerViewAdapterPen(Context context, List<ImageUploadInfoPen> TempList) {

        this.MainImageUploadInfoListPen = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_pen, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterPen.ViewHolder holder, int position) {
        final ImageUploadInfoPen UploadInfo = MainImageUploadInfoListPen.get(position);

        holder.imageNameTextView.setText(UploadInfo.getImageName());
        //Loading image from Glide library.
        Glide.with(context).load(UploadInfo.getImageURL()).into(holder.imageView);
        holder.imageNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                openDetailActivity(UploadInfo.getImageName(),UploadInfo.getAlamat(), UploadInfo.getTelp(), UploadInfo.deskripsi );

            }




        });
    }

    @Override
    public int getItemCount()  {
    return MainImageUploadInfoListPen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView imageNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.btnWisata);

            imageNameTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView);
        }
    }
    public void openDetailActivity(String...details){
        Intent i = new Intent(context, DetailPendidikan.class);
        i.putExtra("imageName",details[0]);
        i.putExtra("alamat", details[1]);
        i.putExtra("telp", details[2]);
        i.putExtra("deskripsi", details[3]);


        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
