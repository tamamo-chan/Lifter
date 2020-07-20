package com.example.lifter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import com.example.lifter.ui.main.CountUpTimer;
import com.example.lifter.ui.main.MediaPlayerWrapper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.lifter.ui.main.SectionsPagerAdapter;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    CountUpTimer timer;
    Snackbar snack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","onStart invoked");
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    public void startSnackbar(View view) {

        if (snack != null) {
            snack.dismiss();
            timer.cancel();
            MediaPlayerWrapper.stop();
        }

        snack = Snackbar.make(view, String.valueOf(1),Snackbar.LENGTH_INDEFINITE);
        timer = new CountUpTimer(300000) {
            public void onTick(int second) {
                if (second % 90 == 0 && second != 0) {
                    MediaPlayerWrapper.play(context, R.raw.boxing_bell);
                }
                String text = String.format(Locale.getDefault(), "%02d:%s", TimeUnit.SECONDS.toMinutes(second) % 60, (second % 60));
                snack.setText(text);
            }
        };
        snack.setAction("End countup", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snack.dismiss();
                timer.cancel();
                MediaPlayerWrapper.stop();
            }
        });
        snack.show();

        timer.start();
        timer.onFinish();
        TextView text = (TextView) view;

        if (text.getText().toString().equals("")) {
            text.setText(Integer.toString(8));
            text.setTypeface(null, Typeface.BOLD);
            text.setTextSize(32);
            text.setTextColor(Color.BLACK);
        } else {
            int i =  Integer.parseInt(text.getText().toString());
            i = i-1 % 9;

            if (i < 0) {
                i += 9;
            }

            text.setText(Integer.toString(i));
            text.setTypeface(null, Typeface.BOLD);
        }
    };

}