package com.example.wesleysantos.aluguel.view.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wesleysantos.aluguel.R;
import com.example.wesleysantos.aluguel.view.adapters.CategoriyArrayAdapter;
import com.example.wesleysantos.aluguel.view.adapters.ItemCategory;

import java.util.ArrayList;

public class FragmentA extends Fragment {
    private CategoriyArrayAdapter categoriyArrayAdapter;
    private ArrayList<ItemCategory> itemCategories;
    private ListView listView;
    private ListView secondListView;
    private String[] categories;
    private String[] subCategories;
    private int[] imagesCategories = {  R.drawable.ic_house,
                                        R.drawable.ic_car,
                                        R.drawable.ic_tools,
                                        R.drawable.ic_shoes };
    private String itemSearched = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_a, container, false);
        listView = (ListView)inflatedView.findViewById(R.id.lv_categories);
        secondListView = (ListView)inflatedView.findViewById(R.id.lv_sub_categories);
        categories = getResources().getStringArray(R.array.categories);
        //imagesCategories = getResources().getIntArray(R.array.imagesCategories);
        createListView();
        listView.setItemsCanFocus(true);
        listView.setItemChecked(0, true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(getContext(),"oi " + i,Toast.LENGTH_SHORT).show();
                listView.setSelection(i);
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.WHITE);
                createSecondList(i);
            }
        });

        return inflatedView;
    }

/*
    public String returnQuery() {
        secondListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), secondListView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
*/
    public String clickedItem() {
        secondListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemSearched = secondListView.getItemAtPosition(i).toString().trim();
            }
        });
        return itemSearched;
    }
    private void createListView() {

        itemCategories = new ArrayList<ItemCategory>();

        for (int i = 0; i < imagesCategories.length; i++) {
            ItemCategory item = new ItemCategory(categories[i], imagesCategories[i]);
            itemCategories.add(item);
        }
        //Cria o adapter
        categoriyArrayAdapter = new CategoriyArrayAdapter(itemCategories, getContext());

        //Define o Adapter
        listView.setAdapter(categoriyArrayAdapter);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.BLUE);

    }
    private void createSecondList(int i) {
        switch (i) {
            case 0:
                subCategories = categories = getResources().getStringArray(R.array.subcategoriesHouses);
                break;
            case 1:
                subCategories = categories = getResources().getStringArray(R.array.subcategoriesCars);
                break;
            case 2:
                subCategories = categories = getResources().getStringArray(R.array.subcategoriesTools);
                break;
            case 3:
                subCategories = categories = getResources().getStringArray(R.array.subcategoriesShoes);
                break;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, subCategories);

        //Define o Adapter
        secondListView.setAdapter(adapter);

    }
}
