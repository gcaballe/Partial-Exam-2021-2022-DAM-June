package dam.gtidic.examenfinal2122.usecases.adventure;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class AdventureViewModel extends ViewModel {

    public MutableLiveData<String> livesLiveData;



    public MutableLiveData<Boolean> isAdventureEnabled;

    public AdventureViewModel(){
        this.livesLiveData = new MutableLiveData<>();
        this.isAdventureEnabled = new MutableLiveData<>();

        //fix per que s'ensenyi també que vides = 0
        int lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        livesLiveData.postValue(String.valueOf(lives) + " vides");

        if(lives == 0) isAdventureEnabled.postValue(false);

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

        if(lives != 0) isAdventureEnabled.postValue(true);
    }

    /* ho poso així per testejar
    public boolean comprobarEnabled(){
        //String lives = livesLiveData.getValue();
        int lives = PreferencesProvider.providePreferences().getInt("lives", 0);

        Log.d("AdventureViewModel", "les vides són " + lives);
        return !(lives == 25); //!lives.equals("25 vides");
    }*/

    //getters i setters

    public MutableLiveData<String> getLivesLiveData() {
        return livesLiveData;
    }

    public void setLivesLiveData(MutableLiveData<String> livesLiveData) {
        this.livesLiveData = livesLiveData;
    }

    public MutableLiveData<Boolean> getIsAdventureEnabled() {
        return isAdventureEnabled;
    }

    public void setIsAdventureEnabled(MutableLiveData<Boolean> isAdventureEnabled) {
        this.isAdventureEnabled = isAdventureEnabled;
    }
}
