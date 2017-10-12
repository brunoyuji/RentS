package com.example.wesleysantos.aluguel.view.adapters;

/**
 * Created by bruno_yuji on 10/12/17.
 */
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.wesleysantos.aluguel.R;

import java.util.List;

/**
 * Created by bruno_yuji on 9/25/17.
 */

public class ProductAdapter extends BaseAdapter {
    List<Product> productList;
    Context ctx;

    public ProductAdapter(List<Product> list, Context ctx) {
        this.ctx = ctx;
        productList = list;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Product getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Product product = productList.get(i);

        ViewHolder holder = null;

        if (view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.product_view_item, null);
            holder = new ViewHolder();
            holder.productIcon = (ImageView) view.findViewById(R.id.product_icon);
            holder.title = (TextView) view.findViewById(R.id.product_title);
            holder.status = (TextView) view.findViewById(R.id.product_status);
            holder.price = (TextView) view.findViewById(R.id.product_price);
            holder.rating = (RatingBar) view.findViewById(R.id.product_ratingbar);
            holder.rateCount = (TextView) view.findViewById(R.id.rate_count);
            holder.transactions = (TextView) view.findViewById(R.id.transactions);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Resources res = ctx.getResources();

        holder.title.setText(product.title);

        switch (product.status) {
            case 0:
                holder.status.setText("Unavaliable");
                holder.status.setTextColor(res.getColor(R.color.app_red));
                break;
            case 1:
                holder.status.setText("Avaliable");
                holder.status.setTextColor(res.getColor(R.color.app_green));
                break;
            default:
                holder.status.setText("Ops");
                Log.i("Status", String.valueOf(product.status));
        }
        holder.price.setText("$ 12.50");
        holder.productIcon.setImageDrawable(product.icon);
        holder.rating.setRating(new Float(product.rate));
        holder.rateCount.setText(String.valueOf(product.rateCount));
        holder.transactions.setText("Transactions: " + product.transactions);
        return view;
    }

    static class ViewHolder {
        ImageView productIcon;
        TextView title, status, price, rateCount, transactions;
        RatingBar rating;
    }
}