package com.radson.notitle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class Click extends AppCompatActivity {
    private  InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
        final LinearLayout fblike = (LinearLayout)findViewById(R.id.fblike);
        fblike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent fblike = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Radsonapps/"));
                startActivity(fblike);

            }
        });
        ads();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2805037520028203/7794385978");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startGame();
            }
        });
        startGame();
    }
    private void showInterstitial() {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this, "Select a Level", Toast.LENGTH_SHORT).show();
            startGame();
        }
    }
    private void startGame() {
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
        }

        final TextView Qm = (TextView)findViewById(R.id.textVie2);
        Qm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ss = new Intent(Click.this, Instruct.class);
                startActivity(ss);
                showInterstitial();
            }
        });
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("levelname", sharedPreferences.getInt("levelnumber", 0));
        editor.commit();
        animationn();
        final Button next_btn = (Button)findViewById(R.id.lvlnxtbtn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("levelname", sharedPreferences.getInt("levelname", 0) + 1);
                editor.commit();
                final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.g_click);
                mediaPlayer.start();
                mediaPlayer.setLooping(false);
                int levelnum = sharedPreferences.getInt("levelname", 0);
                editor.putInt("levelnumber", levelnum);
                editor.commit();
                showInterstitial();
                animationn();
            }
        });
        final Button prev_btn = (Button)findViewById(R.id.lvlprebtn);
        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("levelname", sharedPreferences.getInt("levelname", 0) - 1);
                editor.commit();
                final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.g_click);
                mediaPlayer.start();
                mediaPlayer.setLooping(false);
                int levelnum = sharedPreferences.getInt("levelname",0);
                editor.putInt("levelnumber",levelnum);
                editor.commit();
                showInterstitial();
                animationn();
            }
        });

    }

    void animationn()
    {
        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final LinearLayout lvl1 = (LinearLayout)findViewById(R.id.levelnames1);
        final LinearLayout lvl2 = (LinearLayout)findViewById(R.id.levelnames2);
        final LinearLayout lvl3 = (LinearLayout)findViewById(R.id.levelnames3);
        final LinearLayout lvl4 = (LinearLayout)findViewById(R.id.levelnames4);
        final LinearLayout lvl5 = (LinearLayout)findViewById(R.id.levelnames5);
        final LinearLayout lvl6= (LinearLayout)findViewById(R.id.levelnames6);
        final LinearLayout lvl7 = (LinearLayout)findViewById(R.id.levelnames7);
        lvl1.setVisibility(LinearLayout.GONE);
        lvl2.setVisibility(LinearLayout.GONE);
        lvl3.setVisibility(LinearLayout.GONE);
        lvl4.setVisibility(LinearLayout.GONE);
        lvl5.setVisibility(LinearLayout.GONE);
        lvl6.setVisibility(LinearLayout.GONE);
        lvl7.setVisibility(LinearLayout.GONE);
        if(sharedPreferences.getInt("levelname",0)%7==0)
        {
            lvl1.setVisibility(LinearLayout.VISIBLE);
            editor.putInt("layoutname", 0);
            editor.commit();
            layout1();
        }
        if(sharedPreferences.getInt("levelname",0)%7==1)
        {
            lvl2.setVisibility(LinearLayout.VISIBLE);
            editor.putInt("layoutname", 1);
            editor.commit();
            layout2();
        }
        if(sharedPreferences.getInt("levelname",0)%7==2)
        {
            lvl3.setVisibility(LinearLayout.VISIBLE);
            editor.putInt("layoutname", 2);
            editor.commit();
            layout3();
        }
        if(sharedPreferences.getInt("levelname",0)%7==3)
        {
            lvl4.setVisibility(LinearLayout.VISIBLE);editor.putInt("layoutname", 3);
            editor.commit();layout4();
        }
        if(sharedPreferences.getInt("levelname",0)%7==4)
        {
            lvl5.setVisibility(LinearLayout.VISIBLE);
            editor.putInt("layoutname", 4);
            editor.commit();
            layout5();
        }
        if(sharedPreferences.getInt("levelname",0)%7==5)
        {
            lvl6.setVisibility(LinearLayout.VISIBLE);editor.putInt("layoutname", 5);
            editor.commit();
            layout6();
        }
        if(sharedPreferences.getInt("levelname",0)%7==6)
        {
            lvl7.setVisibility(LinearLayout.VISIBLE);
            editor.putInt("layoutname", 6);
            editor.commit();
            layout7();
        }
    }
    void layout1(){

        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button lvln1 = (Button)findViewById(R.id.lvlbutton1);
        final Button lvln2 = (Button)findViewById(R.id.lvlbutton2);
        final Button lvln3 = (Button)findViewById(R.id.lvlbutton3);
        final Button lvln4 = (Button)findViewById(R.id.lvlbutton4);
        final Button lvln5 = (Button)findViewById(R.id.lvlbutton5);
        final Button lvln6 = (Button)findViewById(R.id.lvlbutton6);
        final Button lvln7 = (Button)findViewById(R.id.lvlbutton7);
        final Button lvln8 = (Button)findViewById(R.id.lvlbutton8);
        final Button lvln9 = (Button)findViewById(R.id.lvlbutton9);
        final Button lvln10 = (Button)findViewById(R.id.lvlbutton10);
        final Button lvln11 = (Button)findViewById(R.id.lvlbutton11);
        final Button lvln12 = (Button)findViewById(R.id.lvlbutton12);
        final Button lvln13 = (Button)findViewById(R.id.lvlbutton13);
        final Button lvln14 = (Button)findViewById(R.id.lvlbutton14);
        final Button lvln15 = (Button)findViewById(R.id.lvlbutto15);
        final Button lvln16 = (Button)findViewById(R.id.lvlbutton16);
        final Button lvln17 = (Button)findViewById(R.id.lvlbutton17);
        final Button lvln18 = (Button)findViewById(R.id.lvlbutton18);
        final Button lvln19 = (Button)findViewById(R.id.lvlbutto19);
        final Button lvln20 = (Button)findViewById(R.id.lvlbutton20);
        lvln2.setEnabled(false);lvln3.setEnabled(false);lvln4.setEnabled(false);lvln5.setEnabled(false);
        lvln6.setEnabled(false);lvln7.setEnabled(false);lvln8.setEnabled(false);lvln9.setEnabled(false);lvln10.setEnabled(false);
        lvln11.setEnabled(false);lvln12.setEnabled(false);lvln13.setEnabled(false);lvln14.setEnabled(false);lvln15.setEnabled(false);
        lvln16.setEnabled(false);lvln17.setEnabled(false);lvln18.setEnabled(false);lvln19.setEnabled(false);lvln20.setEnabled(false);
        if(sharedPreferences.getInt("layoutlevelname0",0)>0){lvln2.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>1){lvln3.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname0",0)>2){lvln4.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>3){lvln5.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname0",0)>4){lvln6.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>5){lvln7.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname0",0)>6){lvln8.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>7){lvln9.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname0",0)>8){lvln10.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>9){lvln11.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname0",0)>10){lvln12.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>11){lvln13.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname0",0)>12){lvln14.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>13){lvln15.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname0",0)>14){lvln16.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>15){lvln17.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname0",0)>16){lvln18.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>17){lvln19.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname0",0)>18){lvln20.setEnabled(true);}
        lvln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 1);editor.putInt("btn2", 0);editor.putInt("btn3", 0);editor.putInt("btn4", 1);editor.putInt("totval", 5);editor.putInt("Leveltittlename",1);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();finish();
            }
        });
        lvln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2);editor.putInt("btn2", 1);editor.putInt("btn3", 0);editor.putInt("btn4", 1);editor.putInt("totval", 10);editor.putInt("Leveltittlename",2);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();finish();
            }
        });
        lvln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 3);editor.putInt("btn2", 1);editor.putInt("btn3", 2);editor.putInt("btn4", 1);editor.putInt("totval", 15);editor.putInt("Leveltittlename",3);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2);editor.putInt("btn2", 3);editor.putInt("btn3", 1);editor.putInt("btn4", 2);editor.putInt("totval", 20);editor.putInt("Leveltittlename",4);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4);editor.putInt("btn2", 1);editor.putInt("btn3", 0);editor.putInt("btn4", 2);editor.putInt("totval", 23);editor.putInt("Leveltittlename",5);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4);editor.putInt("btn2", 2);editor.putInt("btn3", 3);editor.putInt("btn4", 1);editor.putInt("totval", 25);editor.putInt("Leveltittlename",6);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4);editor.putInt("btn2", 6);editor.putInt("btn3", 0);editor.putInt("btn4", 2);editor.putInt("totval", 28);editor.putInt("Leveltittlename",7);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 3);editor.putInt("btn2", 2);editor.putInt("btn3", 4);editor.putInt("btn4", 5);editor.putInt("totval", 31);editor.putInt("Leveltittlename",8);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 3);editor.putInt("btn2", 0);editor.putInt("btn3", 2);editor.putInt("btn4", 6);editor.putInt("totval", 35);editor.putInt("Leveltittlename",9);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2);editor.putInt("btn2", 3);editor.putInt("btn3", 3);editor.putInt("btn4", 2);editor.putInt("totval", 36);editor.putInt("Leveltittlename",10);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4);editor.putInt("btn2", 2);editor.putInt("btn3", 3);editor.putInt("btn4", 7);editor.putInt("totval", 40);editor.putInt("Leveltittlename",11);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 8);editor.putInt("btn2", 2);editor.putInt("btn3", 10);editor.putInt("btn4", 5);editor.putInt("totval", 44);editor.putInt("Leveltittlename",12);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 3);editor.putInt("btn2", 8);editor.putInt("btn3", 6);editor.putInt("btn4", 4);editor.putInt("totval", 47);editor.putInt("Leveltittlename",13);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2);editor.putInt("btn2", 6);editor.putInt("btn3", 5);editor.putInt("btn4", 11);editor.putInt("totval", 50);editor.putInt("Leveltittlename",14);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 5);editor.putInt("btn2", 7);editor.putInt("btn3", 12);editor.putInt("btn4", 2);editor.putInt("totval", 52);editor.putInt("Leveltittlename",15);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 7);editor.putInt("btn2", 2);editor.putInt("btn3", 9);editor.putInt("btn4", 11);editor.putInt("totval", 55);editor.putInt("Leveltittlename",16);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4);editor.putInt("btn2", 9);editor.putInt("btn3", 10);editor.putInt("btn4", 7);editor.putInt("totval", 59);editor.putInt("Leveltittlename",17);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 7);editor.putInt("btn2", 8);editor.putInt("btn3", 14);editor.putInt("btn4", 5);editor.putInt("totval", 63);editor.putInt("Leveltittlename",18);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 7);editor.putInt("btn2", 13);editor.putInt("btn3", 5);editor.putInt("btn4", 6);editor.putInt("totval", 65);editor.putInt("Leveltittlename",19);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2);editor.putInt("btn2", 10);editor.putInt("btn3", 13);editor.putInt("btn4", 12);editor.putInt("totval", 70);editor.putInt("Leveltittlename",20);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
    }
    void layout2(){

        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("layoutname" , 1);editor.commit();
        final Button lvln1 = (Button)findViewById(R.id.lvlbutton21);
        final Button lvln2 = (Button)findViewById(R.id.lvlbutton22);
        final Button lvln3 = (Button)findViewById(R.id.lvlbutton23);
        final Button lvln4 = (Button)findViewById(R.id.lvlbutton24);
        final Button lvln5 = (Button)findViewById(R.id.lvlbutton25);
        final Button lvln6 = (Button)findViewById(R.id.lvlbutton26);
        final Button lvln7 = (Button)findViewById(R.id.lvlbutton27);
        final Button lvln8 = (Button)findViewById(R.id.lvlbutton28);
        final Button lvln9 = (Button)findViewById(R.id.lvlbutton29);
        final Button lvln10 = (Button)findViewById(R.id.lvlbutton30);
        final Button lvln11 = (Button)findViewById(R.id.lvlbutton31);
        final Button lvln12 = (Button)findViewById(R.id.lvlbutton32);
        final Button lvln13 = (Button)findViewById(R.id.lvlbutton33);
        final Button lvln14 = (Button)findViewById(R.id.lvlbutton34);
        final Button lvln15 = (Button)findViewById(R.id.lvlbutto35);
        final Button lvln16 = (Button)findViewById(R.id.lvlbutton36);
        final Button lvln17 = (Button)findViewById(R.id.lvlbutton37);
        final Button lvln18 = (Button)findViewById(R.id.lvlbutton38);
        final Button lvln19 = (Button)findViewById(R.id.lvlbutto39);
        final Button lvln20 = (Button)findViewById(R.id.lvlbutton40);
        lvln2.setEnabled(false);lvln3.setEnabled(false);lvln4.setEnabled(false);lvln5.setEnabled(false);
        lvln6.setEnabled(false);lvln7.setEnabled(false);lvln8.setEnabled(false);lvln9.setEnabled(false);lvln10.setEnabled(false);
        lvln11.setEnabled(false);lvln12.setEnabled(false);lvln13.setEnabled(false);lvln14.setEnabled(false);lvln15.setEnabled(false);
        lvln16.setEnabled(false);lvln17.setEnabled(false);lvln18.setEnabled(false);lvln19.setEnabled(false);lvln20.setEnabled(false);
        if(sharedPreferences.getInt("layoutlevelname1",0)>20){lvln2.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>21){lvln3.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname1",0)>22){lvln4.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>23){lvln5.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname1",0)>24){lvln6.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>25){lvln7.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname1",0)>26){lvln8.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>27){lvln9.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname1",0)>28){lvln10.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>29){lvln11.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname1",0)>30){lvln12.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>31){lvln13.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname1",0)>32){lvln14.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>33){lvln15.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname1",0)>34){lvln16.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>35){lvln17.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname1",0)>36){lvln18.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>37){lvln19.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname1",0)>38){lvln20.setEnabled(true);}
        lvln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4);editor.putInt("btn2", 12);editor.putInt("btn3", 5);editor.putInt("btn4", 11);editor.putInt("totval", 75);editor.putInt("Leveltittlename1",21);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 12);editor.putInt("btn2",8);editor.putInt("btn3", 9);editor.putInt("btn4", 13);editor.putInt("totval", 80);editor.putInt("Leveltittlename1",22);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 3);editor.putInt("btn2", 9);editor.putInt("btn3", 14);editor.putInt("btn4", 15);editor.putInt("totval", 85);editor.putInt("Leveltittlename1",23);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 16);editor.putInt("btn2", 13);editor.putInt("btn3", 15);editor.putInt("btn4", 9);editor.putInt("totval", 90);editor.putInt("Leveltittlename1",24);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 7);editor.putInt("btn2", 14);editor.putInt("btn3", 10);editor.putInt("btn4", 17);editor.putInt("totval", 95);editor.putInt("Leveltittlename1",25);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 6);editor.putInt("btn2", 12);editor.putInt("btn3", 18);editor.putInt("btn4", 11);editor.putInt("totval", 100);editor.putInt("Leveltittlename1",26);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 14);editor.putInt("btn2", 11);editor.putInt("btn3", 10);editor.putInt("btn4", 5);editor.putInt("totval", 105);editor.putInt("Leveltittlename1",27);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 10);editor.putInt("btn2", 0);editor.putInt("btn3", 14);editor.putInt("btn4", 15);editor.putInt("totval", 111);editor.putInt("Leveltittlename1",28);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 13);editor.putInt("btn2", 19);editor.putInt("btn3", 8);editor.putInt("btn4", 16);editor.putInt("totval", 117);editor.putInt("Leveltittlename1",29);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 10);editor.putInt("btn2", 8);editor.putInt("btn3", 12);editor.putInt("btn4", 19);editor.putInt("totval", 125);editor.putInt("Leveltittlename1",30);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 10);editor.putInt("btn2", 9);editor.putInt("btn3", 13);editor.putInt("btn4", 17);editor.putInt("totval", 132);editor.putInt("Leveltittlename1",31);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 8);editor.putInt("btn2", 12);editor.putInt("btn3", 16);editor.putInt("btn4", 15);editor.putInt("totval", 140);editor.putInt("Leveltittlename1",32);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 13);editor.putInt("btn2", 8);editor.putInt("btn3", 16);editor.putInt("btn4", 14);editor.putInt("totval", 147);editor.putInt("Leveltittlename1",33);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 12);editor.putInt("btn2", 6);editor.putInt("btn3", 15);editor.putInt("btn4", 11);editor.putInt("totval", 150);editor.putInt("Leveltittlename1",34);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 5);editor.putInt("btn2", 9);editor.putInt("btn3", 19);editor.putInt("btn4", 12);editor.putInt("totval", 155);editor.putInt("Leveltittlename1",35);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 17);editor.putInt("btn2", 12);editor.putInt("btn3", 9);editor.putInt("btn4", 11);editor.putInt("totval", 160);editor.putInt("Leveltittlename1",36);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 14);editor.putInt("btn2", 9);editor.putInt("btn3", 10);editor.putInt("btn4", 17);editor.putInt("totval", 168);editor.putInt("Leveltittlename1",37);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 11);editor.putInt("btn2", 8);editor.putInt("btn3", 9);editor.putInt("btn4", 15);editor.putInt("totval", 175);editor.putInt("Leveltittlename1",38);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 19);editor.putInt("btn2", 13);editor.putInt("btn3", 5);editor.putInt("btn4", 11);editor.putInt("totval", 185);editor.putInt("Leveltittlename1",39);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 6);editor.putInt("btn2", 17);editor.putInt("btn3", 14);editor.putInt("btn4", 18);editor.putInt("totval", 190);editor.putInt("Leveltittlename1",40);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
    }
    void layout3(){

        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button lvln1 = (Button)findViewById(R.id.lvlbutton41);
        final Button lvln2 = (Button)findViewById(R.id.lvlbutton42);
        final Button lvln3 = (Button)findViewById(R.id.lvlbutto43);
        final Button lvln4 = (Button)findViewById(R.id.lvlbutton44);
        final Button lvln5 = (Button)findViewById(R.id.lvlbutton45);
        final Button lvln6 = (Button)findViewById(R.id.lvlbutton46);
        final Button lvln7 = (Button)findViewById(R.id.lvlbutton47);
        final Button lvln8 = (Button)findViewById(R.id.lvlbutton48);
        final Button lvln9 = (Button)findViewById(R.id.lvlbutton49);
        final Button lvln10 = (Button)findViewById(R.id.lvlbutton50);
        final Button lvln11 = (Button)findViewById(R.id.lvlbutton51);
        final Button lvln12 = (Button)findViewById(R.id.lvlbutton52);
        final Button lvln13 = (Button)findViewById(R.id.lvlbutton53);
        final Button lvln14 = (Button)findViewById(R.id.lvlbutton54);
        final Button lvln15 = (Button)findViewById(R.id.lvlbutto55);
        final Button lvln16 = (Button)findViewById(R.id.lvlbutton56);
        final Button lvln17 = (Button)findViewById(R.id.lvlbutton57);
        final Button lvln18 = (Button)findViewById(R.id.lvlbutton58);
        final Button lvln19 = (Button)findViewById(R.id.lvlbutto59);
        final Button lvln20 = (Button)findViewById(R.id.lvlbutton60);
        lvln2.setEnabled(false);lvln3.setEnabled(false);lvln4.setEnabled(false);lvln5.setEnabled(false);
        lvln6.setEnabled(false);lvln7.setEnabled(false);lvln8.setEnabled(false);lvln9.setEnabled(false);lvln10.setEnabled(false);
        lvln11.setEnabled(false);lvln12.setEnabled(false);lvln13.setEnabled(false);lvln14.setEnabled(false);lvln15.setEnabled(false);
        lvln16.setEnabled(false);lvln17.setEnabled(false);lvln18.setEnabled(false);lvln19.setEnabled(false);lvln20.setEnabled(false);
        if(sharedPreferences.getInt("layoutlevelname2",0)>0){lvln2.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>1){lvln3.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname2",0)>2){lvln4.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>3){lvln5.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname2",0)>4){lvln6.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>5){lvln7.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname2",0)>6){lvln8.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>7){lvln9.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname2",0)>8){lvln10.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>9){lvln11.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname2",0)>10){lvln12.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>11){lvln13.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname2",0)>12){lvln14.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>13){lvln15.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname2",0)>14){lvln16.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>15){lvln17.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname2",0)>16){lvln18.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>17){lvln19.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname2",0)>18){lvln20.setEnabled(true);}
        lvln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 5);editor.putInt("btn2", 12);editor.putInt("btn3", 20);editor.putInt("btn4", 21);editor.putInt("totval", 200);editor.putInt("Leveltittlename2",1);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 12);editor.putInt("btn2",10);editor.putInt("btn3", 19);editor.putInt("btn4", 13);editor.putInt("totval", 210);editor.putInt("Leveltittlename2",2);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 10);editor.putInt("btn2", 10);editor.putInt("btn3", 20);editor.putInt("btn4", 15);editor.putInt("totval", 220);editor.putInt("Leveltittlename2",3);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 12);editor.putInt("btn2", 23);editor.putInt("btn3", 15);editor.putInt("btn4", 15);editor.putInt("totval", 230);editor.putInt("Leveltittlename2",4);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 11);editor.putInt("btn2", 14);editor.putInt("btn3", 20);editor.putInt("btn4", 22);editor.putInt("totval", 240);editor.putInt("Leveltittlename2",5);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 15);editor.putInt("btn2", 20);editor.putInt("btn3", 12);editor.putInt("btn4", 21);editor.putInt("totval", 250);editor.putInt("Leveltittlename2",6);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 24);editor.putInt("btn2", 21);editor.putInt("btn3", 20);editor.putInt("btn4", 15);editor.putInt("totval", 265);editor.putInt("Leveltittlename2",7);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 11);editor.putInt("btn2", 20);editor.putInt("btn3", 24);editor.putInt("btn4", 25);editor.putInt("totval", 280);editor.putInt("Leveltittlename2",8);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 23);editor.putInt("btn2", 21);editor.putInt("btn3", 13);editor.putInt("btn4", 22);editor.putInt("totval", 290);editor.putInt("Leveltittlename2",9);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 20);editor.putInt("btn2", 18);editor.putInt("btn3", 22);editor.putInt("btn4", 29);editor.putInt("totval", 300);editor.putInt("Leveltittlename2",10);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 15);editor.putInt("btn2", 19);editor.putInt("btn3", 23);editor.putInt("btn4", 12);editor.putInt("totval", 315);editor.putInt("Leveltittlename2",11);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 25);editor.putInt("btn2", 20);editor.putInt("btn3", 15);editor.putInt("btn4", 15);editor.putInt("totval", 330);editor.putInt("layoutlevelname2",12);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 23);editor.putInt("btn2", 22);editor.putInt("btn3", 20);editor.putInt("btn4", 25);editor.putInt("totval", 350);editor.putInt("layoutlevelname2",13);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 22);editor.putInt("btn2", 16);editor.putInt("btn3", 15);editor.putInt("btn4", 31);editor.putInt("totval", 375);editor.putInt("layoutlevelname2",14);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 25);editor.putInt("btn2", 28);editor.putInt("btn3", 29);editor.putInt("btn4", 22);editor.putInt("totval", 400);editor.putInt("layoutlevelname2",15);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 17);editor.putInt("btn2", 22);editor.putInt("btn3", 19);editor.putInt("btn4", 21);editor.putInt("totval", 425);editor.putInt("layoutlevelname2",16);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 24);editor.putInt("btn2", 19);editor.putInt("btn3", 15);editor.putInt("btn4", 20);editor.putInt("totval", 450);editor.putInt("layoutlevelname2",17);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 21);editor.putInt("btn2", 28);editor.putInt("btn3", 19);editor.putInt("btn4", 15);editor.putInt("totval", 475);editor.putInt("layoutlevelname2",18);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 19);editor.putInt("btn2", 23);editor.putInt("btn3", 25);editor.putInt("btn4", 21);editor.putInt("totval", 490);editor.putInt("layoutlevelname2",19);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 16);editor.putInt("btn2", 17);editor.putInt("btn3", 24);editor.putInt("btn4", 18);editor.putInt("totval", 510);editor.putInt("layoutlevelname2",20);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
    }
    void layout4(){

        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button lvln1 = (Button)findViewById(R.id.lvlbutton61);
        final Button lvln2 = (Button)findViewById(R.id.lvlbutton62);
        final Button lvln3 = (Button)findViewById(R.id.lvlbutton63);
        final Button lvln4 = (Button)findViewById(R.id.lvlbutton64);
        final Button lvln5 = (Button)findViewById(R.id.lvlbutton65);
        final Button lvln6 = (Button)findViewById(R.id.lvlbutton66);
        final Button lvln7 = (Button)findViewById(R.id.lvlbutton67);
        final Button lvln8 = (Button)findViewById(R.id.lvlbutton68);
        final Button lvln9 = (Button)findViewById(R.id.lvlbutton69);
        final Button lvln10 = (Button)findViewById(R.id.lvlbutton70);
        final Button lvln11 = (Button)findViewById(R.id.lvlbutton71);
        final Button lvln12 = (Button)findViewById(R.id.lvlbutton72);
        final Button lvln13 = (Button)findViewById(R.id.lvlbutton73);
        final Button lvln14 = (Button)findViewById(R.id.lvlbutton74);
        final Button lvln15 = (Button)findViewById(R.id.lvlbutto75);
        final Button lvln16 = (Button)findViewById(R.id.lvlbutton76);
        final Button lvln17 = (Button)findViewById(R.id.lvlbutton77);
        final Button lvln18 = (Button)findViewById(R.id.lvlbutton78);
        final Button lvln19 = (Button)findViewById(R.id.lvlbutto79);
        final Button lvln20 = (Button)findViewById(R.id.lvlbutton80);
        lvln2.setEnabled(false);lvln3.setEnabled(false);lvln4.setEnabled(false);lvln5.setEnabled(false);
        lvln6.setEnabled(false);lvln7.setEnabled(false);lvln8.setEnabled(false);lvln9.setEnabled(false);lvln10.setEnabled(false);
        lvln11.setEnabled(false);lvln12.setEnabled(false);lvln13.setEnabled(false);lvln14.setEnabled(false);lvln15.setEnabled(false);
        lvln16.setEnabled(false);lvln17.setEnabled(false);lvln18.setEnabled(false);lvln19.setEnabled(false);lvln20.setEnabled(false);
        if(sharedPreferences.getInt("layoutlevelname3",0)>0){lvln2.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>1){lvln3.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname3",0)>2){lvln4.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>3){lvln5.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname3",0)>4){lvln6.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>5){lvln7.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname3",0)>6){lvln8.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>7){lvln9.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname3",0)>8){lvln10.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>9){lvln11.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname3",0)>10){lvln12.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>11){lvln13.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname3",0)>12){lvln14.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>13){lvln15.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname3",0)>14){lvln16.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>15){lvln17.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname3",0)>16){lvln18.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>17){lvln19.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname3",0)>18){lvln20.setEnabled(true);}
        lvln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 5);editor.putInt("btn2", 15);editor.putInt("btn3", 25);editor.putInt("btn4", 20);editor.putInt("totval", 525);editor.putInt("Leveltittlename3",1);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 32);editor.putInt("btn2",30);editor.putInt("btn3", 19);editor.putInt("btn4", 23);editor.putInt("totval", 550);editor.putInt("Leveltittlename3",2);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 22);editor.putInt("btn2", 23);editor.putInt("btn3", 31);editor.putInt("btn4", 35);editor.putInt("totval", 575);editor.putInt("Leveltittlename3",3);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 22);editor.putInt("btn2", 28);editor.putInt("btn3", 33);editor.putInt("btn4", 15);editor.putInt("totval", 600);editor.putInt("Leveltittlename3",4);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 31);editor.putInt("btn2", 34);editor.putInt("btn3", 30);editor.putInt("btn4", 32);editor.putInt("totval", 625);editor.putInt("Leveltittlename3",5);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 35);editor.putInt("btn2", 30);editor.putInt("btn3", 32);editor.putInt("btn4", 31);editor.putInt("totval", 650);editor.putInt("Leveltittlename3",6);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 34);editor.putInt("btn2", 31);editor.putInt("btn3", 20);editor.putInt("btn4", 35);editor.putInt("totval", 665);editor.putInt("Leveltittlename3",7);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 21);editor.putInt("btn2", 31);editor.putInt("btn3", 34);editor.putInt("btn4", 25);editor.putInt("totval",675);editor.putInt("Leveltittlename3",8);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 33);editor.putInt("btn2", 21);editor.putInt("btn3", 33);editor.putInt("btn4", 22);editor.putInt("totval", 700);editor.putInt("Leveltittlename3",9);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 30);editor.putInt("btn2", 28);editor.putInt("btn3", 32);editor.putInt("btn4", 29);editor.putInt("totval", 725);editor.putInt("Leveltittlename3",10);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 25);editor.putInt("btn2", 29);editor.putInt("btn3", 33);editor.putInt("btn4", 36);editor.putInt("totval", 750);editor.putInt("Leveltittlename3",11);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 37);editor.putInt("btn2", 28);editor.putInt("btn3", 33);editor.putInt("btn4", 35);editor.putInt("totval", 775);editor.putInt("Leveltittlename3",12);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 33);editor.putInt("btn2", 20);editor.putInt("btn3", 39);editor.putInt("btn4", 39);editor.putInt("totval", 800);editor.putInt("Leveltittlename3",13);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 22);editor.putInt("btn2", 36);editor.putInt("btn3", 35);editor.putInt("btn4", 38);editor.putInt("totval", 825);editor.putInt("Leveltittlename3",14);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 37);editor.putInt("btn2", 28);editor.putInt("btn3", 40);editor.putInt("btn4", 13);editor.putInt("totval", 850);editor.putInt("Leveltittlename3",15);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 32);editor.putInt("btn2", 35);editor.putInt("btn3", 29);editor.putInt("btn4", 31);editor.putInt("totval", 875);editor.putInt("Leveltittlename3",16);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 34);editor.putInt("btn2", 40);editor.putInt("btn3", 26);editor.putInt("btn4", 37);editor.putInt("totval", 900);editor.putInt("Leveltittlename3",17);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 31);editor.putInt("btn2", 26);editor.putInt("btn3", 29);editor.putInt("btn4", 35);editor.putInt("totval", 925);editor.putInt("Leveltittlename3",18);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 37);editor.putInt("btn2", 33);editor.putInt("btn3", 40);editor.putInt("btn4", 41);editor.putInt("totval", 950);editor.putInt("Leveltittlename3",19);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 36);editor.putInt("btn2", 37);editor.putInt("btn3", 34);editor.putInt("btn4", 40);editor.putInt("totval", 1000);editor.putInt("Leveltittlename3",20);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
    }
    void layout5(){

        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button lvln1 = (Button)findViewById(R.id.lvlbutton81);
        final Button lvln2 = (Button)findViewById(R.id.lvlbutton82);
        final Button lvln3 = (Button)findViewById(R.id.lvlbutton83);
        final Button lvln4 = (Button)findViewById(R.id.lvlbutton84);
        final Button lvln5 = (Button)findViewById(R.id.lvlbutton85);
        final Button lvln6 = (Button)findViewById(R.id.lvlbutton86);
        final Button lvln7 = (Button)findViewById(R.id.lvlbutton87);
        final Button lvln8 = (Button)findViewById(R.id.lvlbutton88);
        final Button lvln9 = (Button)findViewById(R.id.lvlbutton89);
        final Button lvln10 = (Button)findViewById(R.id.lvlbutton90);
        final Button lvln11 = (Button)findViewById(R.id.lvlbutton91);
        final Button lvln12 = (Button)findViewById(R.id.lvlbutton92);
        final Button lvln13 = (Button)findViewById(R.id.lvlbutton93);
        final Button lvln14 = (Button)findViewById(R.id.lvlbutton94);
        final Button lvln15 = (Button)findViewById(R.id.lvlbutto95);
        final Button lvln16 = (Button)findViewById(R.id.lvlbutton96);
        final Button lvln17 = (Button)findViewById(R.id.lvlbutton97);
        final Button lvln18 = (Button)findViewById(R.id.lvlbutton98);
        final Button lvln19 = (Button)findViewById(R.id.lvlbutto99);
        final Button lvln20 = (Button)findViewById(R.id.lvlbutton100);
        lvln2.setEnabled(false);lvln3.setEnabled(false);lvln4.setEnabled(false);lvln5.setEnabled(false);
        lvln6.setEnabled(false);lvln7.setEnabled(false);lvln8.setEnabled(false);lvln9.setEnabled(false);lvln10.setEnabled(false);
        lvln11.setEnabled(false);lvln12.setEnabled(false);lvln13.setEnabled(false);lvln14.setEnabled(false);lvln15.setEnabled(false);
        lvln16.setEnabled(false);lvln17.setEnabled(false);lvln18.setEnabled(false);lvln19.setEnabled(false);lvln20.setEnabled(false);
        if(sharedPreferences.getInt("layoutlevelname4",0)>0){lvln2.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>1){lvln3.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname4",0)>2){lvln4.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>3){lvln5.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname4",0)>4){lvln6.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>5){lvln7.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname4",0)>6){lvln8.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>7){lvln9.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname4",0)>8){lvln10.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>9){lvln11.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname4",0)>10){lvln12.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>11){lvln13.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname4",0)>12){lvln14.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>13){lvln15.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname4",0)>14){lvln16.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>15){lvln17.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname4",0)>16){lvln18.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>17){lvln19.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname4",0)>18){lvln20.setEnabled(true);}
        lvln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 34);editor.putInt("btn2", 42);editor.putInt("btn3", 40);editor.putInt("btn4", 31);editor.putInt("totval", 1050);editor.putInt("Leveltittlename4",1);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 42);editor.putInt("btn2",40);editor.putInt("btn3", 39);editor.putInt("btn4", 33);editor.putInt("totval", 1100);editor.putInt("Leveltittlename4",2);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 43);editor.putInt("btn2", 45);editor.putInt("btn3", 30);editor.putInt("btn4", 43);editor.putInt("totval", 1150);editor.putInt("Leveltittlename4",3);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 38);editor.putInt("btn2", 39);editor.putInt("btn3", 44);editor.putInt("btn4", 45);editor.putInt("totval", 1200);editor.putInt("Leveltittlename4",4);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 41);editor.putInt("btn2", 36);editor.putInt("btn3", 40);editor.putInt("btn4", 43);editor.putInt("totval",1250);editor.putInt("Leveltittlename4",5);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 35);editor.putInt("btn2", 43);editor.putInt("btn3", 42);editor.putInt("btn4", 41);editor.putInt("totval", 1300);editor.putInt("Leveltittlename4",6);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 44);editor.putInt("btn2", 41);editor.putInt("btn3", 40);editor.putInt("btn4", 45);editor.putInt("totval", 1350);editor.putInt("Leveltittlename4",7);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 48);editor.putInt("btn2", 45);editor.putInt("btn3", 47);editor.putInt("btn4", 46);editor.putInt("totval", 1400);editor.putInt("Leveltittlename4",8);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 43);editor.putInt("btn2", 49);editor.putInt("btn3", 48);editor.putInt("btn4", 45);editor.putInt("totval", 1575);editor.putInt("Leveltittlename4",9);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 50);editor.putInt("btn2", 48);editor.putInt("btn3", 42);editor.putInt("btn4", 49);editor.putInt("totval", 1650);editor.putInt("Leveltittlename4",10);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 50);editor.putInt("btn2", 49);editor.putInt("btn3", 48);editor.putInt("btn4", 42);editor.putInt("totval", 1700);editor.putInt("Leveltittlename4",11);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 50);editor.putInt("btn2", 41);editor.putInt("btn3", 49);editor.putInt("btn4", 45);editor.putInt("totval", 1800);editor.putInt("Leveltittlename4",12);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 48);editor.putInt("btn2", 47);editor.putInt("btn3", 50);editor.putInt("btn4", 44);editor.putInt("totval", 1900);editor.putInt("Leveltittlename4",13);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 50);editor.putInt("btn2", 53);editor.putInt("btn3", 52);editor.putInt("btn4", 51);editor.putInt("totval", 2000);editor.putInt("Leveltittlename4",14);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 50);editor.putInt("btn2", 48);editor.putInt("btn3", 49);editor.putInt("btn4", 52);editor.putInt("totval", 2100);editor.putInt("Leveltittlename4",15);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 47);editor.putInt("btn2", 52);editor.putInt("btn3", 49);editor.putInt("btn4", 51);editor.putInt("totval", 2200);editor.putInt("Leveltittlename4",16);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 54);editor.putInt("btn2", 50);editor.putInt("btn3", 56);editor.putInt("btn4", 55);editor.putInt("totval", 2300);editor.putInt("Leveltittlename4",17);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 51);editor.putInt("btn2", 58);editor.putInt("btn3", 56);editor.putInt("btn4", 55);editor.putInt("totval", 2400);editor.putInt("Leveltittlename4",18);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 59);editor.putInt("btn2", 53);editor.putInt("btn3", 55);editor.putInt("btn4", 60);editor.putInt("totval", 2500);editor.putInt("Leveltittlename4",19);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 60);editor.putInt("btn2", 59);editor.putInt("btn3", 54);editor.putInt("btn4", 58);editor.putInt("totval", 2600);editor.putInt("Leveltittlename4",20);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
    }
    void layout6(){

        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button lvln1 = (Button)findViewById(R.id.lvlbutton101);
        final Button lvln2 = (Button)findViewById(R.id.lvlbutton102);
        final Button lvln3 = (Button)findViewById(R.id.lvlbutton103);
        final Button lvln4 = (Button)findViewById(R.id.lvlbutton104);
        final Button lvln5 = (Button)findViewById(R.id.lvlbutton105);
        final Button lvln6 = (Button)findViewById(R.id.lvlbutton106);
        final Button lvln7 = (Button)findViewById(R.id.lvlbutton107);
        final Button lvln8 = (Button)findViewById(R.id.lvlbutton108);
        final Button lvln9 = (Button)findViewById(R.id.lvlbutton109);
        final Button lvln10 = (Button)findViewById(R.id.lvlbutton110);
        final Button lvln11 = (Button)findViewById(R.id.lvlbutton111);
        final Button lvln12 = (Button)findViewById(R.id.lvlbutto112);
        final Button lvln13 = (Button)findViewById(R.id.lvlbutton113);
        final Button lvln14 = (Button)findViewById(R.id.lvlbutton114);
        final Button lvln15 = (Button)findViewById(R.id.lvlbutto115);
        final Button lvln16 = (Button)findViewById(R.id.lvlbutton116);
        final Button lvln17 = (Button)findViewById(R.id.lvlbutton117);
        final Button lvln18 = (Button)findViewById(R.id.lvlbutton118);
        final Button lvln19 = (Button)findViewById(R.id.lvlbutto119);
        final Button lvln20 = (Button)findViewById(R.id.lvlbutton120);
        lvln2.setEnabled(false);lvln3.setEnabled(false);lvln4.setEnabled(false);lvln5.setEnabled(false);
        lvln6.setEnabled(false);lvln7.setEnabled(false);lvln8.setEnabled(false);lvln9.setEnabled(false);lvln10.setEnabled(false);
        lvln11.setEnabled(false);lvln12.setEnabled(false);lvln13.setEnabled(false);lvln14.setEnabled(false);lvln15.setEnabled(false);
        lvln16.setEnabled(false);lvln17.setEnabled(false);lvln18.setEnabled(false);lvln19.setEnabled(false);lvln20.setEnabled(false);
        if(sharedPreferences.getInt("layoutlevelname5",0)>0){lvln2.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>1){lvln3.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname5",0)>2){lvln4.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>3){lvln5.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname5",0)>4){lvln6.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>5){lvln7.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname5",0)>6){lvln8.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>7){lvln9.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname5",0)>8){lvln10.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>9){lvln11.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname5",0)>10){lvln12.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>11){lvln13.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname5",0)>12){lvln14.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>13){lvln15.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname5",0)>14){lvln16.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>15){lvln17.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname5",0)>16){lvln18.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>17){lvln19.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname5",0)>18){lvln20.setEnabled(true);}
        lvln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 85);editor.putInt("btn2", 90);editor.putInt("btn3", 80);editor.putInt("btn4", 75);editor.putInt("totval", 2750);editor.putInt("Leveltittlename5",1);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 92);editor.putInt("btn2",100);editor.putInt("btn3", 90);editor.putInt("btn4", 73);editor.putInt("totval", 3000);editor.putInt("Leveltittlename5",2);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 98);editor.putInt("btn2", 94);editor.putInt("btn3", 80);editor.putInt("btn4", 125 );editor.putInt("totval", 3250);editor.putInt("Leveltittlename5",3);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 102);editor.putInt("btn2", 93);editor.putInt("btn3", 87);editor.putInt("btn4", 130);editor.putInt("totval", 3500);editor.putInt("Leveltittlename5",4);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 87);editor.putInt("btn2", 94);editor.putInt("btn3", 100);editor.putInt("btn4", 92);editor.putInt("totval", 3750);editor.putInt("Leveltittlename5",5);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 3);editor.putInt("btn2", 327);editor.putInt("btn3", 20);editor.putInt("btn4", 360);editor.putInt("totval", 4000);editor.putInt("Leveltittlename5",6);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 250);editor.putInt("btn2", 200);editor.putInt("btn3", 211);editor.putInt("btn4", 101);editor.putInt("totval", 4250);editor.putInt("Leveltittlename5",7);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 300);editor.putInt("btn2", 250);editor.putInt("btn3", 52);editor.putInt("btn4", 333);editor.putInt("totval", 4500);editor.putInt("Leveltittlename5",8);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 200);editor.putInt("btn2", 150);editor.putInt("btn3", 224);editor.putInt("btn4", 222);editor.putInt("totval", 4750);editor.putInt("Leveltittlename5",9);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 150);editor.putInt("btn2", 118);editor.putInt("btn3", 120);editor.putInt("btn4", 129);editor.putInt("totval", 5000);editor.putInt("Leveltittlename5",10);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 155);editor.putInt("btn2", 119);editor.putInt("btn3", 123);editor.putInt("btn4", 150);editor.putInt("totval", 5250);editor.putInt("Leveltittlename5",11);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 125);editor.putInt("btn2", 170);editor.putInt("btn3", 155);editor.putInt("btn4",165);editor.putInt("totval", 5500);editor.putInt("Leveltittlename5",12);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 165);editor.putInt("btn2", 220);editor.putInt("btn3", 205);editor.putInt("btn4", 225);editor.putInt("totval", 5750);editor.putInt("Leveltittlename5",13);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 220);editor.putInt("btn2", 265);editor.putInt("btn3", 150);editor.putInt("btn4", 250);editor.putInt("totval", 6000);editor.putInt("Leveltittlename5",14);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 250);editor.putInt("btn2", 275);editor.putInt("btn3", 290);editor.putInt("btn4", 225);editor.putInt("totval", 6250);editor.putInt("Leveltittlename5",15);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 375);editor.putInt("btn2", 410);editor.putInt("btn3", 345);editor.putInt("btn4", 210);editor.putInt("totval", 6500);editor.putInt("Leveltittlename5",16);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 480);editor.putInt("btn2", 380);editor.putInt("btn3", 515);editor.putInt("btn4", 305);editor.putInt("totval", 7000);editor.putInt("Leveltittlename5",17);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 415);editor.putInt("btn2", 385);editor.putInt("btn3", 395);editor.putInt("btn4", 450);editor.putInt("totval", 7000);editor.putInt("Leveltittlename5",18);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 330);editor.putInt("btn2", 330);editor.putInt("btn3", 420);editor.putInt("btn4", 525);editor.putInt("totval", 7500);editor.putInt("Leveltittlename5",19);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 400);editor.putInt("btn2", 500);editor.putInt("btn3",500);editor.putInt("btn4", 600);editor.putInt("totval", 8000);editor.putInt("Leveltittlename5",20);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
    }
    void layout7(){

        final SharedPreferences sharedPreferences = getSharedPreferences("shp",
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button lvln1 = (Button)findViewById(R.id.lvlbutton121);
        final Button lvln2 = (Button)findViewById(R.id.lvlbutton122);
        final Button lvln3 = (Button)findViewById(R.id.lvlbutton123);
        final Button lvln4 = (Button)findViewById(R.id.lvlbutton124);
        final Button lvln5 = (Button)findViewById(R.id.lvlbutton125);
        final Button lvln6 = (Button)findViewById(R.id.lvlbutton126);
        final Button lvln7 = (Button)findViewById(R.id.lvlbutton127);
        final Button lvln8 = (Button)findViewById(R.id.lvlbutton128);
        final Button lvln9 = (Button)findViewById(R.id.lvlbutton129);
        final Button lvln10 = (Button)findViewById(R.id.lvlbutton130);
        final Button lvln11 = (Button)findViewById(R.id.lvlbutton131);
        final Button lvln12 = (Button)findViewById(R.id.lvlbutton132);
        final Button lvln13 = (Button)findViewById(R.id.lvlbutton133);
        final Button lvln14 = (Button)findViewById(R.id.lvlbutton134);
        final Button lvln15 = (Button)findViewById(R.id.lvlbutto135);
        final Button lvln16 = (Button)findViewById(R.id.lvlbutton136);
        final Button lvln17 = (Button)findViewById(R.id.lvlbutton137);
        final Button lvln18 = (Button)findViewById(R.id.lvlbutton138);
        final Button lvln19 = (Button)findViewById(R.id.lvlbutto139);
        final Button lvln20 = (Button)findViewById(R.id.lvlbutton140);
        lvln2.setEnabled(false);lvln3.setEnabled(false);lvln4.setEnabled(false);lvln5.setEnabled(false);
        lvln6.setEnabled(false);lvln7.setEnabled(false);lvln8.setEnabled(false);lvln9.setEnabled(false);lvln10.setEnabled(false);
        lvln11.setEnabled(false);lvln12.setEnabled(false);lvln13.setEnabled(false);lvln14.setEnabled(false);lvln15.setEnabled(false);
        lvln16.setEnabled(false);lvln17.setEnabled(false);lvln18.setEnabled(false);lvln19.setEnabled(false);lvln20.setEnabled(false);
        if(sharedPreferences.getInt("layoutlevelname6",0)>0){lvln2.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>1){lvln3.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname6",0)>2){lvln4.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>3){lvln5.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname6",0)>4){lvln6.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>5){lvln7.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname6",0)>6){lvln8.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>7){lvln9.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname6",0)>8){lvln10.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>9){lvln11.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname6",0)>10){lvln12.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>11){lvln13.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname6",0)>12){lvln14.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>13){lvln15.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname6",0)>14){lvln16.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>15){lvln17.setEnabled(true);}
        if(sharedPreferences.getInt("layoutlevelname6",0)>16){lvln18.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>17){lvln19.setEnabled(true);}if(sharedPreferences.getInt("layoutlevelname6",0)>18){lvln20.setEnabled(true);}
        lvln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 620);editor.putInt("btn2", 480);editor.putInt("btn3", 555);editor.putInt("btn4", 600);editor.putInt("totval", 8500);editor.putInt("Leveltittlename6",1);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 720);editor.putInt("btn2",700);editor.putInt("btn3", 580);editor.putInt("btn4", 650);editor.putInt("totval", 9000);editor.putInt("Leveltittlename6",2);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 750);editor.putInt("btn2", 725);editor.putInt("btn3", 800);editor.putInt("btn4", 675);editor.putInt("totval", 9500);editor.putInt("Leveltittlename6",3);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 825);editor.putInt("btn2", 850);editor.putInt("btn3", 775);editor.putInt("btn4", 950);editor.putInt("totval", 10000);editor.putInt("Leveltittlename6",4);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 800);editor.putInt("btn2", 875);editor.putInt("btn3", 975);editor.putInt("btn4", 1000);editor.putInt("totval", 11000);editor.putInt("Leveltittlename6",5);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 900);editor.putInt("btn2", 950);editor.putInt("btn3", 1050);editor.putInt("btn4", 1100);editor.putInt("totval", 12000);editor.putInt("Leveltittlename6",6);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 950);editor.putInt("btn2", 1050);editor.putInt("btn3", 1200);editor.putInt("btn4", 1150);editor.putInt("totval", 13000);editor.putInt("Leveltittlename6",7);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 1400);editor.putInt("btn2", 1350);editor.putInt("btn3", 1150);editor.putInt("btn4", 1250);editor.putInt("totval", 14000);editor.putInt("Leveltittlename6",8);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 1375);editor.putInt("btn2", 1125);editor.putInt("btn3", 800);editor.putInt("btn4", 1650);editor.putInt("totval", 16500);editor.putInt("Leveltittlename6",9);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 1175);editor.putInt("btn2", 1825);editor.putInt("btn3", 1250);editor.putInt("btn4", 1500);editor.putInt("totval", 19000);editor.putInt("Leveltittlename6",10);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 1850);editor.putInt("btn2", 1925);editor.putInt("btn3", 1250);editor.putInt("btn4", 1650);editor.putInt("totval", 21000);editor.putInt("Leveltittlename6",11);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 1850);editor.putInt("btn2", 1625);editor.putInt("btn3", 2000);editor.putInt("btn4", 1550);editor.putInt("totval", 23000);editor.putInt("Leveltittlename6",12);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 1595);editor.putInt("btn2", 2150);editor.putInt("btn3", 1755);editor.putInt("btn4", 1800);editor.putInt("totval", 25000);editor.putInt("Leveltittlename6",13);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2400);editor.putInt("btn2", 2100);editor.putInt("btn3", 1800);editor.putInt("btn4", 2300);editor.putInt("totval", 27500);editor.putInt("Leveltittlename6",14);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2050);editor.putInt("btn2", 1950);editor.putInt("btn3", 1900);editor.putInt("btn4", 2500);editor.putInt("totval", 30000);editor.putInt("Leveltittlename6",15);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2000);editor.putInt("btn2", 2250);editor.putInt("btn3", 2750);editor.putInt("btn4", 3000);editor.putInt("totval", 35000);editor.putInt("Leveltittlename6",16);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4400);editor.putInt("btn2", 2900);editor.putInt("btn3", 3400);editor.putInt("btn4", 3700);editor.putInt("totval", 50000);editor.putInt("Leveltittlename6",17);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4000);editor.putInt("btn2", 3750);editor.putInt("btn3", 4750);editor.putInt("btn4", 5000);editor.putInt("totval", 75000);editor.putInt("Leveltittlename6",18);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 2500);editor.putInt("btn2", 5000);editor.putInt("btn3", 7500);editor.putInt("btn4", 10000);editor.putInt("totval", 100000);editor.putInt("Leveltittlename6",19);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
        lvln20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Game = new Intent(Click.this,MainActivity.class);
                startActivity(Main_Game);
                editor.putInt("btn1", 4437);editor.putInt("btn2", 9277);editor.putInt("btn3", 108);editor.putInt("btn4", 4430);editor.putInt("totval", 99999);editor.putInt("Leveltittlename6",20);
                editor.putInt("final", 0);editor.putInt("n1", 0);editor.putInt("n2", 0);editor.commit();
            }
        });
    }

    public void ads()
    {


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}
