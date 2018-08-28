package com.chaochaowu.sharedelementdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * @author chaochaowu
 * @Description :
 * @classes :
 * @time Create at 8/27/2018 10:21 AM
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<String> datas;
    private OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if( position % 2 == 0 ){
            Glide.with(mContext).load(R.drawable.img)
                    .into(holder.imageView);
        }else {
            Glide.with(mContext).load(R.drawable.img2)
                    .into(holder.imageView);
        }

        holder.textView.setText(datas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position, holder.imageView, holder.textView, holder.textViewLong);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView textViewLong;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textViewLong = itemView.findViewById(R.id.textViewLong);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position, ImageView imageView, TextView textView, TextView textViewLong);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

}
