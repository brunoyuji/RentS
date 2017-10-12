package com.example.wesleysantos.aluguel.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wesleysantos.aluguel.R;
import com.example.wesleysantos.aluguel.view.user.ProductListActivity;

public class FragmentB extends Fragment {
    private Button btn;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       new ProductListActivity(this.getContext(),this.getActivity()).setUp();
        return ProductListActivity.getView();
    }
}
