package com.example.wesleysantos.aluguel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ItemSearchedActivity extends AppCompatActivity {
    private ListView lvItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_searched);
        lvItems = (ListView)findViewById(R.id.lv_items_search);
    }

    public void createList() {
        
    }
}
