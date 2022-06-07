package dam.gtidic.examenfinal2122.usecases.adventure;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import dam.gtidic.examenfinal2122.usecases.game.math.GameActivityMath;
import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class AdventureViewModel extends ViewModel {

    public MutableLiveData<String> livesLiveData;

    public AdventureViewModel(){
        this.livesLiveData = new MutableLiveData<>();

        //fix per que s'ensenyi també que vides = 0
        int lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        livesLiveData.postValue(String.valueOf(lives) + " vides");

    }

    //4. Infinite lives (2 points)
    public void onClickPurchaseLivesBt(){

        int lives = PreferencesProvider.providePreferences().getInt("lives", 0);

        lives++;

        PreferencesProvider.providePreferences().edit().putInt("lives",
                lives).commit();

        Log.d("AdventrueViewModel",
                "He actualitzat shared prefs. Aara el valor es: " + lives);
        //Intent intent = new Intent(userActivity, GameActivityMath.class);
        //userActivity.startActivity(intent);
        livesLiveData.postValue(String.valueOf(lives) + " vides");
    }



    //getters i setters

    public MutableLiveData<String> getLivesLiveData() {
        return livesLiveData;
    }

    public void setLivesLiveData(MutableLiveData<String> livesLiveData) {
        this.livesLiveData = livesLiveData;
    }
}
