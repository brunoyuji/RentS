package com.example.wesleysantos.aluguel.view.adapters;

import android.content.Context;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wesleysantos.aluguel.R;

public class ImageAdapter extends PagerAdapter {
    private Context context;

    private int[] GalImages = new int[] {
            R.drawable.ic_logo,
            R.drawable.ic_baseball,
            R.drawable.ic_chess,
            R.drawable.ic_golf,
            R.drawable.ic_hockey,
            R.drawable.ic_pingpong
    };

    public ImageAdapter(Context context)
    {
        this.context=context;
    }

    @Override
    public int getCount() {
        return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==  object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        int padding = context.getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
        imageView.setPadding(padding, padding, padding, padding);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(GalImages[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}