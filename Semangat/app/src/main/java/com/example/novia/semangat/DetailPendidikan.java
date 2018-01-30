package com.example.novia.semangat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.novia.semangat.model.ImageUploadInfoPen;
import com.example.novia.semangat.model.ImageUploadInfoWis;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailPendidikan extends AppCompatActivity {

    private static final int REQUEST_PHONE_CALL =1 ;

    private TextView txtnama1,txtAlamat1,txtTelp1,txtdeskripsi1;
    private String nama, alamat, telp, deskripsi;
    DatabaseReference databaseReference;
    ImageView foto, btn_panah;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pendidikan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtnama1 = (TextView) findViewById(R.id.txtNama1);
        txtAlamat1 = (TextView) findViewById(R.id.txtAlamat);
        txtTelp1 = (TextView) findViewById(R.id.txtTlpn);
        txtdeskripsi1 = (TextView) findViewById(R.id.txtDeskripsi);

        Intent i = this.getIntent();

        nama = i.getExtras().getString("imageName");
        alamat  = i.getExtras().getString("alamat");
        telp = i.getExtras().getString("telp");
        deskripsi = i.getExtras().getString("deskripsi");



        ImageView map = (ImageView) findViewById(R.id.btnMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent a = new Intent(DetailPendidikan.this,MapsActivity2.class);
                a.putExtra("alamat", alamat); //ketambahan
                startActivity(a);
            }
        });

        TextView viewM = (TextView) findViewById(R.id.viewMap);
        viewM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent a = new Intent(DetailPendidikan.this,MapsActivity2.class);
                a.putExtra("alamat", alamat); //ketambahan
                startActivity(a);
            }
        });


        txtnama1.setText(nama);
        txtAlamat1.setText(alamat);
        txtTelp1.setText(telp);
        txtTelp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTelepon();
            }
        });

        txtdeskripsi1.setText(deskripsi);
//        foto = (ImageView) findViewById(R.id.foto);
        final ImageView gambar = (ImageView) findViewById(R.id.foto);
        // Adding Add Value Event Listener to databaseReference.
        String namaS = "pendidikan";
        databaseReference = FirebaseDatabase.getInstance().getReference(namaS);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()){
                    final ImageUploadInfoPen i = postSnapshot.getValue(ImageUploadInfoPen.class);


                    if (i.getImageName().equals(nama))
                    {
                        url = i.getImageURL();
                        Glide.with(getApplicationContext()).load(url).into(gambar);
//
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.

            }
        });
        ImageView btn_share= (ImageView) findViewById(R.id.btnShare);
        btn_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                share();
//                Picasso.with(getApplicationContext()).load(url).into(target1);
//                Picasso.with(getApplicationContext()).load(url).into(target1);// aku manggil modelnya error


            }
        });

        TextView txtAlamat44 = (TextView) findViewById(R.id.txtAlamat44);
        txtAlamat44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
        ImageView btn_panah= (ImageView) findViewById(R.id.btnPanah);
        btn_panah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(DetailPendidikan.this, DisplayWisata.class);
                startActivity(intent);

            }
        });

//        callbackManager = CallbackManager.Factory.create();
//        shareDialog = new ShareDialog(this);
    }
    public void callTelepon()
    {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+telp+""));

        if (ContextCompat.checkSelfPermission(DetailPendidikan.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(DetailPendidikan.this, new String[]{android.Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }
        else
        {
            startActivity(callIntent);
        }
    }

    public void share()
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, (R.string.app_name));
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, ""+nama+" "+alamat);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
