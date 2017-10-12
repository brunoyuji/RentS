package com.example.wesleysantos.aluguel.view.adapters;

import android.graphics.drawable.Drawable;

/**
 * Created by bruno_yuji on 10/12/17.
 */
public class Product {
    String title;
    Drawable icon;
    double rate = 3.5;
    int status;
    int transactions =20;
    int rateCount = 10;

    public Product(String title,Drawable icon,int status){
        this.title = title;
        this.icon = icon;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTransactions() {
        return transactions;
    }

    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }
}
