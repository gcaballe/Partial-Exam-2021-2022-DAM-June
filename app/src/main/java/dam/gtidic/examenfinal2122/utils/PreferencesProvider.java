package dam.gtidic.examenfinal2122.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesProvider {

    private static SharedPreferences sPreferences;

    public static SharedPreferences providePreferences() {
        return sPreferences;
    }

    public static void init(Context context) {
        String SHARED_PREFERENCES = "mPreferences";
        sPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }
}
