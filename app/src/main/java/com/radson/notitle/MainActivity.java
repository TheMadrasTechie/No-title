package com.radson.notitle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Click  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.g_click);
        totalvalue();
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button btn1 = (Button) findViewById(R.id.button1);
        final Button btn2 = (Button) findViewById(R.id.button2);
        final Button btn3 = (Button) findViewById(R.id.button3);
        final Button btn4 = (Button) findViewById(R.id.button4);
        final Button finalbtn = (Button)findViewById(R.id.finalword);
        final LinearLayout ll1 = (LinearLayout)findViewById(R.id.ll1);
        final LinearLayout ll2 = (LinearLayout)findViewById(R.id.ll2);
        final LinearLayout ll3 = (LinearLayout)findViewById(R.id.ll3);
        final LinearLayout ll4 = (LinearLayout)findViewById(R.id.ll4);
        btn1.setText(""+sharedPreferences.getInt("btn1",0 ));
        btn1colour();
        btn2.setText("" + sharedPreferences.getInt("btn2", 0));
        btn2colour();
        btn3.setText("" + sharedPreferences.getInt("btn3", 0));
        btn3colour();
        btn4.setText("" + sharedPreferences.getInt("btn4", 0));
        btn4colour();
        finalbtn.setText(""+sharedPreferences.getInt("totval",0));
        editor.putInt("btnv1", sharedPreferences.getInt("btn1", 0));
        editor.putInt("btnv2", sharedPreferences.getInt("btn2", 0));
        editor.putInt("btnv3",sharedPreferences.getInt("btn3",0));
        editor.putInt("btnv4",sharedPreferences.getInt("btn4",0));
        editor.commit();

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setLooping(false);
                if (sharedPreferences.getString("bv", "").equals("bv1")) {
                    colour_changer();
                    editor.putInt("n1" , 0);
                    editor.commit();
                } else {
                    if (sharedPreferences.getString("kw", "").equals("kw")) {
                        ll1.setBackgroundColor(Color.BLACK);
                        editor.putInt("n2", sharedPreferences.getInt("btn1", 0));
                        editor.putString("kw", " ");
                        editor.commit();
                        xx();
                        editor.putInt("btn1", sharedPreferences.getInt("final", 0));
                        editor.commit();
                        btn1.setText("" + sharedPreferences.getInt("final", 0));
                        btn1colour();
                        colour_changer();
                        totalvalue();
                    } else {
                        ll1.setBackgroundColor(Color.BLACK);
                        editor.putInt("n1", sharedPreferences.getInt("btn1", 0));
                        editor.putString("kw", "kw");
                        editor.putString("bv", "bv1");
                        editor.commit();
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setLooping(false);
                if (sharedPreferences.getString("bv", "").equals("bv2")) {
                    colour_changer();
                    editor.putInt("n1" , 0);
                    editor.commit();
                } else {
                    if (sharedPreferences.getString("kw", "").equals("kw")) {
                        ll2.setBackgroundColor(Color.BLACK);
                        editor.putInt("n2", sharedPreferences.getInt("btn2", 0));
                        editor.putString("kw", " ");
                        editor.commit();
                        xx();
                        editor.putInt("btn2", sharedPreferences.getInt("final", 0));
                        editor.commit();
                        btn2.setText("" + sharedPreferences.getInt("final", 0));
                        btn2colour();
                        colour_changer();
                        totalvalue();
                    } else {
                        ll2.setBackgroundColor(Color.BLACK);
                        editor.putInt("n1", sharedPreferences.getInt("btn2", 0));
                        editor.putString("kw", "kw");
                        editor.putString("bv", "bv2");
                        editor.commit();
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setLooping(false);
                if (sharedPreferences.getString("bv", "").equals("bv3")) {
                    colour_changer();
                    editor.putInt("n1" , 0);
                    editor.commit();
                } else {
                    if (sharedPreferences.getString("kw", "").equals("kw")) {
                        ll3.setBackgroundColor(Color.BLACK);
                        editor.putInt("n2", sharedPreferences.getInt("btn3", 0));
                        editor.putString("kw", " ");
                        editor.commit();
                        xx();
                        editor.putInt("btn3", sharedPreferences.getInt("final", 0));
                        editor.commit();
                        btn3.setText("" + sharedPreferences.getInt("final", 0));
                        btn3colour();
                        colour_changer();
                        totalvalue();
                    } else {
                        ll3.setBackgroundColor(Color.BLACK);
                        editor.putInt("n1", sharedPreferences.getInt("btn3", 0));
                        editor.putString("kw", "kw");
                        editor.putString("bv", "bv3");
                        editor.commit();
                    }
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setLooping(false);
                if (sharedPreferences.getString("bv", "").equals("bv4")) {
                    colour_changer();
                    editor.putInt("n1" , 0);
                    editor.commit();
                } else {
                    if (sharedPreferences.getString("kw", "").equals("kw")) {
                        ll4.setBackgroundColor(Color.BLACK);
                        editor.putInt("n2", sharedPreferences.getInt("btn4", 0));
                        editor.putString("kw", " ");
                        editor.commit();
                        xx();
                        editor.putInt("btn4", sharedPreferences.getInt("final", 0));
                        editor.commit();
                        btn4.setText("" + sharedPreferences.getInt("final", 0));
                        btn4colour();
                        colour_changer();
                        totalvalue();
                    } else {
                        ll4.setBackgroundColor(Color.BLACK);
                        editor.putInt("n1", sharedPreferences.getInt("btn4", 0));
                        editor.putString("kw", "kw");
                        editor.putString("bv", "bv4");
                        editor.commit();
                    }
                }
            }
        });
    }
    void totalvalue(){
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.g_click);
        mediaPlayer.start();
        mediaPlayer.setLooping(false);
        final MediaPlayer gamewin = MediaPlayer.create(this, R.raw.game_level_complete);
        final MediaPlayer gameloose = MediaPlayer.create(this, R.raw.game_loose);
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button btn1 = (Button) findViewById(R.id.button1);
        final Button btn2 = (Button) findViewById(R.id.button2);
        final Button btn3 = (Button) findViewById(R.id.button3);
        final Button btn4 = (Button) findViewById(R.id.button4);
        final Button addword = (Button)findViewById(R.id.addedword);
        int toastvalue = sharedPreferences.getInt("btn1",0)+sharedPreferences.getInt("btn2",0)+sharedPreferences.getInt("btn3",0)+sharedPreferences.getInt("btn4",0);
        addword.setText("" + toastvalue);
        if(sharedPreferences.getInt("totval",0)<(sharedPreferences.getInt("btn1" , 0)+sharedPreferences.getInt("btn2" , 0)+sharedPreferences.getInt("btn3" , 0)+sharedPreferences.getInt("btn4" , 0)))
        {
            gameloose.start();
            gameloose.setLooping(false);
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            btn4.setClickable(false);
            View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.gaameovr , null);
            AlertDialog.Builder alertbuilder = new AlertDialog.Builder(MainActivity.this);
            alertbuilder.setView(view);
            alertbuilder.setPositiveButton("Select Levels", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent play = new Intent(getApplicationContext(), Click.class);
                    startActivity(play);
                    finish();
                }
            });
            alertbuilder.setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent play = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(play);
                    editor.putInt("btn1", sharedPreferences.getInt("btnv1", 0));
                    editor.putInt("btn2", sharedPreferences.getInt("btnv2", 0));
                    editor.putInt("btn3", sharedPreferences.getInt("btnv3", 0));
                    editor.putInt("btn4", sharedPreferences.getInt("btnv4", 0));
                    editor.commit();
                    finish();
                }
            });
            alertbuilder.setCancelable(false);
            Dialog dialog = alertbuilder.create();
            dialog.show();
        }else        if(sharedPreferences.getInt("totval",0)==(sharedPreferences.getInt("btn1" , 0)+sharedPreferences.getInt("btn2" , 0)+sharedPreferences.getInt("btn3" , 0)+sharedPreferences.getInt("btn4" , 0)))
        {
            gamewin.start();
            gamewin.setLooping(false);
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            btn4.setClickable(false);
            View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.promptview , null);
            AlertDialog.Builder alertbuilder = new AlertDialog.Builder(MainActivity.this);
            alertbuilder.setView(view);
            alertbuilder.setPositiveButton("Select Levels", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent play = new Intent(getApplicationContext(), Click.class);
                    startActivity(play);
                    finish();
                }
            });
            alertbuilder.setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent play = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(play);
                    editor.putInt("btn1", sharedPreferences.getInt("btnv1", 0));
                    editor.putInt("btn2", sharedPreferences.getInt("btnv2", 0));
                    editor.putInt("btn3", sharedPreferences.getInt("btnv3", 0));
                    editor.putInt("btn4", sharedPreferences.getInt("btnv4", 0));
                    editor.commit();
                    finish();
                }
            });
            alertbuilder.setCancelable(false);
            Dialog dialog = alertbuilder.create();
            level_lock();
            dialog.show();
        }

    }
    void colour_changer(){
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final LinearLayout ll1 = (LinearLayout)findViewById(R.id.ll1);
        final LinearLayout ll2 = (LinearLayout)findViewById(R.id.ll2);
        final LinearLayout ll3 = (LinearLayout)findViewById(R.id.ll3);
        final LinearLayout ll4 = (LinearLayout)findViewById(R.id.ll4);
        ll1.setBackgroundColor(Color.WHITE);
        ll2.setBackgroundColor(Color.WHITE);
        ll3.setBackgroundColor(Color.WHITE);
        ll4.setBackgroundColor(Color.WHITE);
        editor.putString("bv", " ");
        editor.commit();
    }
void xx() {
    final SharedPreferences sharedPreferences = getSharedPreferences("shp",
            Context.MODE_PRIVATE);
    final SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("final", sharedPreferences.getInt("n1", 0) + sharedPreferences.getInt("n2", 0));
    editor.commit();
}
    void btn1colour()
    {
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button btn1 = (Button) findViewById(R.id.button1);
        if(sharedPreferences.getInt("btn1",0)%9==0)
        {
            btn1.setBackgroundColor(Color.BLUE);
        }
        if(sharedPreferences.getInt("btn1",0)%9==1)
        {
            btn1.setBackgroundColor(Color.CYAN);
        }
        if(sharedPreferences.getInt("btn1",0)%9==2)
        {
            btn1.setBackgroundColor(Color.WHITE);

        }
        if(sharedPreferences.getInt("btn1",0)%9==3)
        {
            btn1.setBackgroundColor(Color.GREEN);
        }
        if(sharedPreferences.getInt("btn1",0)%9==4)
        {
            btn1.setBackgroundColor(Color.MAGENTA);
        }
        if(sharedPreferences.getInt("btn1",0)%9==5)
        {
            btn1.setBackgroundColor(Color.RED);
        }
        if(sharedPreferences.getInt("btn1",0)%9==6)
        {
            btn1.setBackgroundColor(Color.YELLOW);
        }
        if(sharedPreferences.getInt("btn1",0)%9==7)
        {
            btn1.setBackgroundColor(Color.GRAY);
        }
        if(sharedPreferences.getInt("btn1",0)%9==8)
        {
            btn1.setBackgroundColor(Color.LTGRAY);
        }
    }
    void btn2colour()
    {
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button btn2 = (Button) findViewById(R.id.button2);
        if(sharedPreferences.getInt("btn2",0)%9==0)
        {
            btn2.setBackgroundColor(Color.BLUE);
        }
        if(sharedPreferences.getInt("btn2",0)%9==1)
        {
            btn2.setBackgroundColor(Color.CYAN);
        }
        if(sharedPreferences.getInt("btn2",0)%9==2)
        {
            btn2.setBackgroundColor(Color.WHITE);
         }
        if(sharedPreferences.getInt("btn2",0)%9==3)
        {
            btn2.setBackgroundColor(Color.GREEN);
        }
        if(sharedPreferences.getInt("btn2",0)%9==4)
        {
            btn2.setBackgroundColor(Color.MAGENTA);
        }
        if(sharedPreferences.getInt("btn2",0)%9==5)
        {
            btn2.setBackgroundColor(Color.RED);
        }
        if(sharedPreferences.getInt("btn2",0)%9==6)
        {
            btn2.setBackgroundColor(Color.YELLOW);
        }
        if(sharedPreferences.getInt("btn2",0)%9==7)
        {
            btn2.setBackgroundColor(Color.GRAY);
        }
        if(sharedPreferences.getInt("btn2",0)%9==8)
        {
            btn2.setBackgroundColor(Color.LTGRAY);
        }
    }
    void btn3colour()
    {
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button btn3 = (Button) findViewById(R.id.button3);
        if(sharedPreferences.getInt("btn3",0)%9==0)
        {
            btn3.setBackgroundColor(Color.BLUE);
        }
        if(sharedPreferences.getInt("btn3",0)%9==1)
        {
            btn3.setBackgroundColor(Color.CYAN);
        }
        if(sharedPreferences.getInt("btn3",0)%9==2)
        {
            btn3.setBackgroundColor(Color.WHITE);
        }
        if(sharedPreferences.getInt("btn3",0)%9==3)
        {
            btn3.setBackgroundColor(Color.GREEN);
        }
        if(sharedPreferences.getInt("btn3",0)%9==4)
        {
            btn3.setBackgroundColor(Color.MAGENTA);
        }
        if(sharedPreferences.getInt("btn3",0)%9==5)
        {
            btn3.setBackgroundColor(Color.RED);
        }
        if(sharedPreferences.getInt("btn3",0)%9==6)
        {
            btn3.setBackgroundColor(Color.YELLOW);
        }
        if(sharedPreferences.getInt("btn3",0)%9==7)
        {
            btn3.setBackgroundColor(Color.GRAY);
        }
        if(sharedPreferences.getInt("btn3",0)%9==8)
        {
            btn3.setBackgroundColor(Color.LTGRAY);
        }
    }
    void btn4colour()
    {
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button btn4 = (Button) findViewById(R.id.button4);
        if(sharedPreferences.getInt("btn4",0)%9==0)
        {
            btn4.setBackgroundColor(Color.BLUE);
        }
        if(sharedPreferences.getInt("btn4",0)%9==1)
        {
            btn4.setBackgroundColor(Color.CYAN);
        }
        if(sharedPreferences.getInt("btn4",0)%9==2)
        {
            btn4.setBackgroundColor(Color.WHITE);
        }
        if(sharedPreferences.getInt("btn4",0)%9==3)
        {
            btn4.setBackgroundColor(Color.GREEN);
        }
        if(sharedPreferences.getInt("btn4",0)%9==4)
        {
            btn4.setBackgroundColor(Color.MAGENTA);
        }
        if(sharedPreferences.getInt("btn4",0)%9==5)
        {
            btn4.setBackgroundColor(Color.RED);
        }
        if(sharedPreferences.getInt("btn4",0)%9==6)
        {
            btn4.setBackgroundColor(Color.YELLOW);
        }
        if(sharedPreferences.getInt("btn4",0)%9==7)
        {
            btn4.setBackgroundColor(Color.GRAY);
        }
        if(sharedPreferences.getInt("btn4",0)%9==8)
        {
            btn4.setBackgroundColor(Color.LTGRAY);
        }
    }

    void level_lock()
    {
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.getInt("Leveltittlename",0)>sharedPreferences.getInt("layoutlevelname0",0)){editor.putInt("layoutlevelname0",sharedPreferences.getInt("Leveltittlename",0));editor.commit();}
        if(sharedPreferences.getInt("Leveltittlename1",0)>sharedPreferences.getInt("layoutlevelname1",0)){editor.putInt("layoutlevelname1",sharedPreferences.getInt("Leveltittlename1",0));editor.commit();}
        if(sharedPreferences.getInt("Leveltittlename2",0)>sharedPreferences.getInt("layoutlevelname2",0)){editor.putInt("layoutlevelname2",sharedPreferences.getInt("Leveltittlename2",0));editor.commit();}
        if(sharedPreferences.getInt("Leveltittlename3",0)>sharedPreferences.getInt("layoutlevelname3",0)){editor.putInt("layoutlevelname3",sharedPreferences.getInt("Leveltittlename3",0));editor.commit();}
        if(sharedPreferences.getInt("Leveltittlename4",0)>sharedPreferences.getInt("layoutlevelname4",0)){editor.putInt("layoutlevelname4",sharedPreferences.getInt("Leveltittlename4",0));editor.commit();}
        if(sharedPreferences.getInt("Leveltittlename5",0)>sharedPreferences.getInt("layoutlevelname5",0)){editor.putInt("layoutlevelname5",sharedPreferences.getInt("Leveltittlename5",0));editor.commit();}
        if(sharedPreferences.getInt("Leveltittlename6",0)>sharedPreferences.getInt("layoutlevelname6",0)){editor.putInt("layoutlevelname6",sharedPreferences.getInt("Leveltittlename6",0));editor.commit();}
    }
}





