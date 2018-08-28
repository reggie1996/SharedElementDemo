package com.chaochaowu.sharedelementdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = this;

        ArrayList arrayList = new ArrayList<String>();
        for (int i = 0; i<10 ;i++){
            arrayList.add( i+ "" );
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new RecyclerViewAdapter(this, arrayList);
        mAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ImageView imageView, TextView textView, TextView textViewLong) {
                Intent i = new Intent(mContext, DetailActivity.class);
                i.putExtra("pos",position + "");
                android.support.v4.util.Pair<View, String> image = new android.support.v4.util.Pair(imageView, "image");
                android.support.v4.util.Pair<View, String> text = new android.support.v4.util.Pair(textView, "text");
                android.support.v4.util.Pair<View, String> longtext = new android.support.v4.util.Pair(textViewLong, "longtext");
                ActivityOptionsCompat optionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, image,text,longtext);
                startActivity(i,optionsCompat.toBundle());
            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }

}
