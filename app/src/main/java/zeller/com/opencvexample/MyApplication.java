package zeller.com.opencvexample;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Daniel.Xu on 2019-10-13.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
