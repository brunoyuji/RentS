package com.example.wesleysantos.aluguel.view.products;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.wesleysantos.aluguel.view.fragments.MainActivity;
import com.example.wesleysantos.aluguel.R;
import com.example.wesleysantos.aluguel.view.adapters.ImageAdapter;

public class ProductFullActivity extends AppCompatActivity {
    private ImageAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;
    private Button btnFavorite;
    private Button btnRent;
    private TextView txtPrice;
    private TextView txtDescription;
    private TextView txtDistance;
    private TextView txtAdress;
    private TextView txtRatingNumber;
    private RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_full);
        final Toolbar toolbar = (Toolbar)findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        android.support.design.widget.CollapsingToolbarLayout collapsingToolbarLayout = (android.support.design.widget.CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);


        mCustomPagerAdapter = new ImageAdapter(getApplicationContext());

        mViewPager = (ViewPager) findViewById(R.id.mvieww);
        mViewPager.setAdapter(mCustomPagerAdapter);

        txtAdress = (TextView)findViewById(R.id.txt_adress);
        txtDescription = (TextView)findViewById(R.id.txt_description);
        txtDistance = (TextView)findViewById(R.id.txt_distance);
        txtRatingNumber = (TextView)findViewById(R.id.txt_rating_number);
        rating = (RatingBar) findViewById(R.id.ratingBar);

    }
    @Override
    public void onBackPressed() {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        finish();
        startActivity(it);
    }
}
