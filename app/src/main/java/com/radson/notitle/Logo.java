package com.radson.notitle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.radson.notitle.Click;
import com.radson.notitle.R;

/**
 * Created by SUNDAR on 13-01-2016.
 */
public class Logo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);

        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        String levelname = " "+sharedPreferences.getInt("levelnumber", 0);

            editor.putInt("levelnumber",700);
            editor.commit();



            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    Intent asdf = new Intent(getApplicationContext(),
                            Click.class);
                    startActivity(asdf);
                    finish();
                }
            }, 3000);
        }
    }

