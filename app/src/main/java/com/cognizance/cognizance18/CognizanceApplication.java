package com.cognizance.cognizance18;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by arihant on 3/2/18.
 */

public class CognizanceApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("cognizance-db.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

    }
}
