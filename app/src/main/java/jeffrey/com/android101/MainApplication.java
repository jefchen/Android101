package jeffrey.com.android101;

import android.app.Application;
import com.activeandroid.ActiveAndroid;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
