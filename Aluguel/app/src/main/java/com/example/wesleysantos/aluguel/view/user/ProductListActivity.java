package com.example.wesleysantos.aluguel.view.user;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wesleysantos.aluguel.R;
import com.example.wesleysantos.aluguel.view.adapters.Product;
import com.example.wesleysantos.aluguel.view.adapters.ProductAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductListActivity extends AppCompatActivity {
    List<Product> products = new ArrayList<>();
    final Context c;
    final Activity ac;
    public ProductListActivity(Context c,Activity ac){
        this.c = c;
        this.ac = ac;
    }


    private static  View v ;
    public void setUp(){
        createList();
        final ProductAdapter adapter = new ProductAdapter(products,c);
        final ListView list = new ListView(c);
        list.setEmptyView(LayoutInflater.from(c).inflate(R.layout.product_empty_view,null));
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = (Product) adapterView.getItemAtPosition(i);
                if(p != null){
                    //Toast.makeText(c,p.getTitle(),Toast.LENGTH_SHORT).show();
                    products.remove(p);
                    adapter.notifyDataSetChanged();
                    if(adapter.isEmpty()){
                        
                    }

                }

            }
        });
        v = list;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // setContentView(list);

    }
public static View getView(){
    return v;
}
    void createList(){
        Random r = new Random();
        for(int i = 0;i<10;i++){
            Product p = new Product("product "+i, c.getResources().getDrawable(R.drawable.no_imageicon_product),(r.nextInt(2)));
            products.add(p);
        }
    }


}
