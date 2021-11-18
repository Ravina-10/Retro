package com.example.retro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class imageWinnerRec extends RecyclerView.Adapter<BindHolder> {
    Context context;
    ArrayList<imageWinnerModel> showlist;
   public imageWinnerRec(Context context,ArrayList<imageWinnerModel> listshow){
        this.context=context;
        this.showlist=listshow;
    }
    public  void update(ArrayList<imageWinnerModel> listshsow){
       this.showlist=listshsow;
        Collections.sort(this.showlist, new Comparator<imageWinnerModel>() {
            @Override
            public int compare(imageWinnerModel o1, imageWinnerModel o2) {
                return Integer.valueOf(o1.getDate().compareTo(o2.getDate()));
            }
        });
        Collections.reverse(showlist);
       notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BindHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.winnerpic_row,parent,false);
        return new BindHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BindHolder holder, int position) {
        Glide.with(context).load(this.showlist.get(position).getImageurl()).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return this.showlist.size();
    }
}
class BindHolder extends RecyclerView.ViewHolder{
    ImageView im;
    public BindHolder(@NonNull View itemView) {
        super(itemView);
        im=itemView.findViewById(R.id.winner_pic);

    }
}
