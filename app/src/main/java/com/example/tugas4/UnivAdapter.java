package com.example.tugas4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UnivAdapter extends RecyclerView.Adapter<UnivAdapter.ViewHolder> {

    private Context context;
    private ArrayList<UnivModel> univModels;

    public UnivAdapter(ArrayList<UnivModel> listData, Context context) {
        this.context = context;
    }

    public ArrayList<UnivModel> getUnivModels() {
        return univModels;
    }

    public void setUnivModels(ArrayList<UnivModel> univModels) {
        this.univModels = univModels;
    }

    @NonNull
    @Override
    public UnivAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_univ,viewGroup,false);
        return new ViewHolder(itRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(getUnivModels().get(i).getPhoto()).into(viewHolder.ivPhotoPlayer);
        viewHolder.tvNamePlayer.setText(getUnivModels().get(i).getPlayer_name());

        viewHolder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("photo", getUnivModels().get(i).getPhoto());
                intent.putExtra("name", getUnivModels().get(i).getPlayer_name());
                intent.putExtra("preview", getUnivModels().get(i).getPreview());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getUnivModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivPhotoPlayer;
        private TextView tvNamePlayer;
        private Button visit;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivPhotoPlayer = itemView.findViewById(R.id.pic_photo);
            tvNamePlayer = itemView.findViewById(R.id.tx_name);
            visit = itemView.findViewById(R.id.btn_detail);
        }
    }
}