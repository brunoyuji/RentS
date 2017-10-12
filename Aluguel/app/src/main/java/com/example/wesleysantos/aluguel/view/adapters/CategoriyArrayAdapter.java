package com.example.wesleysantos.aluguel.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wesleysantos.aluguel.R;

import java.util.ArrayList;

/**
 * Created by wesleysantos on 23/03/17.
 */

public class CategoriyArrayAdapter extends BaseAdapter {
    private final ArrayList<ItemCategory> arrayAdapter;
    private Context context;

    public CategoriyArrayAdapter(ArrayList<ItemCategory> arrayAdapter, Context context) {
        this.arrayAdapter = arrayAdapter;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayAdapter.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayAdapter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //infla o layout para podermos preencher os dados
        view = inflater.inflate(R.layout.item_list, null);

        if (view != null) {
            ImageView imgView = (ImageView) view.findViewById(R.id.image);
            TextView txtTitle = (TextView) view.findViewById(R.id.name);

            ItemCategory item = arrayAdapter.get(i);
            imgView.setImageResource(item.getImage());
            txtTitle.setText(item.getName());
        }
        return view;
    }
}
