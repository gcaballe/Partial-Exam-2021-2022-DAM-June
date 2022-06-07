package dam.gtidic.examenfinal2122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import dam.gtidic.examenfinal2122.usecases.adventure.AdventureActivity;
import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(this.getClass().getSimpleName(), " -> onCreate()");

        //4. Infinite lives (2 points)
        //PreferencesProvider.providePreferences().edit().putInt("lives",
        //        0).commit();


        setup();
        data();
    }

    // Private methods
    private void setup(){
        Log.d(this.getClass().getSimpleName(), " -> setup()");
        Log.d(this.getClass().getSimpleName(), " ... init Shared Preferences()");
        PreferencesProvider.init(this);

        int lives = PreferencesProvider.providePreferences().getInt("lives", -1);
        if(lives == -1) {
            PreferencesProvider.providePreferences().edit().putInt("lives", 0).apply();
        }
    }

    private void data(){
        showHome();
        finish();
    }

    private void showHome(){
        startActivity(new Intent(this, AdventureActivity.class));
    }

}