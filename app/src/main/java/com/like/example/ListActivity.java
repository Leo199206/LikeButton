package com.like.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.like.example.adapters.ListAdapter;
import com.like.example.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {
    private ActivityListBinding binding;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ListAdapter(this);
        binding.listView.setAdapter(adapter);

    }
}
