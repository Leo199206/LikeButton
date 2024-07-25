package com.like.example;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.like.LikeButton;
import com.like.OnAnimationEndListener;
import com.like.OnLikeListener;
import com.like.example.databinding.ActivityMainBinding;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.iconics.IconicsDrawable;


public class MainActivity extends AppCompatActivity implements OnLikeListener,
        OnAnimationEndListener {

    public static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        binding.content.starButton.setOnAnimationEndListener(this);
        binding.content.starButton.setOnLikeListener(this);
        binding.content.likeButton.setOnLikeListener(this);
        binding.content.likeButton.setOnAnimationEndListener(this);
        binding.content.smileButton.setOnLikeListener(this);
        binding.content.smileButton.setOnAnimationEndListener(this);
        binding.content.thumbButton.setOnLikeListener(this);
        binding.content.thumbButton.setOnAnimationEndListener(this);
        binding.content.thumbButton.setLiked(true);
        binding.content.vectorButton.setLikeDrawableTintColor(Color.GREEN);
        binding.content.vectorButton.setUnLikeDrawableTintColor(Color.BLACK);
        usingCustomIcons();

    }

    public void usingCustomIcons() {

        //shown when the button is in its default state or when unLiked.
        binding.content.smileButton.setUnlikeDrawable(new BitmapDrawable(getResources(), new IconicsDrawable(this, CommunityMaterial.Icon.cmd_emoticon).colorRes(android.R.color.darker_gray).sizeDp(25).toBitmap()));

        //shown when the button is liked!
        binding.content.smileButton.setLikeDrawable(new BitmapDrawable(getResources(), new IconicsDrawable(this, CommunityMaterial.Icon.cmd_emoticon).colorRes(android.R.color.holo_purple).sizeDp(25).toBitmap()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void liked(LikeButton likeButton) {
        Toast.makeText(this, "Liked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void unLiked(LikeButton likeButton) {
        Toast.makeText(this, "Disliked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(LikeButton likeButton) {
        Log.d(TAG, "Animation End for %s" + likeButton);
    }

    public void navigateToList() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
