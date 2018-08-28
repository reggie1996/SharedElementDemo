package com.chaochaowu.sharedelementdemo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String pos = intent.getStringExtra("pos");
        textView.setText(pos);
        if (Integer.parseInt(pos) % 2 == 0) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.img));
        } else {
            imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.img2));
        }
    }
}
