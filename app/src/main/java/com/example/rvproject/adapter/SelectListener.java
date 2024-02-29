package com.example.rvproject.adapter;

import com.example.rvproject.modalclass.MainToyModalclass;

import java.util.ArrayList;

public interface SelectListener {

    void onItemClicked(MainToyModalclass modalclass);

    void onItemClicked(int position, ArrayList<MainToyModalclass> modalclasses);
}
