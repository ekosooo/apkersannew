package com.example.apkersan2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apkersan2.R;
import com.example.apkersan2.model.DataBerita;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaHolder> {

    List<DataBerita> semuaBeritaList;
    Context mContext;
    String judul, konten, penulis, gambar, created_at;
    String path = "http://192.168.1.6:8000/berita/";

    public BeritaAdapter(Context mContext, List<DataBerita> beritaList){
        this.mContext = mContext;
        this.semuaBeritaList = beritaList;
    }

    @NonNull
    @Override
    public BeritaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita, parent, false);
        final BeritaHolder beritaHolder = new BeritaHolder(view);
        return  beritaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaHolder holder, int position){
        final DataBerita semuaberitaItem = semuaBeritaList.get(position);
        holder.TvJudul.setText(semuaberitaItem.getJudulBerita());
        Picasso.get().load(path + semuaberitaItem.getGambar()).into(holder.IvBerita);
    }

    @Override
    public int getItemCount(){
        return semuaBeritaList.size();
    }

    public class BeritaHolder extends RecyclerView.ViewHolder{

        public TextView TvJudul;
        public ImageView IvBerita;

        public BeritaHolder(@NonNull View itemView){
            super(itemView);

            TvJudul     = itemView.findViewById(R.id.TvJudulBerita);
            IvBerita    = itemView.findViewById(R.id.IvBerita);

            ButterKnife.bind(this, itemView);
        }

    }

}
