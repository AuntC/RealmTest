package com.example.guocheng.realm.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.guocheng.realm.R;
import com.example.guocheng.realm.RealmApplication;

import java.util.Timer;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by guocheng on 16-7-26.
 */
public class RealmActivity extends AppCompatActivity {
    private Handler handler;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        Realm.getDefaultInstance();
        handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getInstance();
            }
        }).start();
    }


    public void getInstance() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                realm = Realm.getDefaultInstance();
            }
        }, 5000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
