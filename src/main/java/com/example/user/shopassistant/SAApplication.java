package com.example.user.shopassistant;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmChangeListener;

/**
 * Created by User on 02.12.2016.
 */

public class SAApplication extends MultiDexApplication {
    public static final String TAG = "CApplication";

    public static Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        setRealm();
    }

    private void setRealm() {
        realm = Realm.getInstance(this);
        realm.setAutoRefresh(true);
        realm.addChangeListener(new RealmChangeListener() {
            @Override
            public void onChange() {

            }
        });
        Log.i(TAG, "Realm was set.");
    }
}
