package dam.gtidic.examenfinal2122.usecases.adventure;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;

import dam.gtidic.examenfinal2122.CalendarUtils;
import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class AdventureViewModel extends ViewModel {

    public MutableLiveData<String> livesLiveData;



    public MutableLiveData<Boolean> isAdventureEnabled;

    public AdventureViewModel(){
        this.livesLiveData = new MutableLiveData<>();
        this.isAdventureEnabled = new MutableLiveData<>();

        checkNewLifesPerDay();


        //fix per que s'ensenyi també que vides = 0
        int lives = PreferencesProvider.providePreferences().getInt("lives", 0);

        livesLiveData.postValue(String.valueOf(lives) + " vides");

        if(lives == 0) isAdventureEnabled.postValue(false);

    }

    private void checkNewLifesPerDay() {

        long millis = System.currentTimeMillis();
        Date ara = new Date(millis);

        long lastO = PreferencesProvider.providePreferences().getLong("lastOnline", 0);
        Date lastDate = new Date(lastO);

        if(!CalendarUtils.isSameDay(ara, lastDate)){
            PreferencesProvider.providePreferences().edit().putInt("lives",
                    3).commit();
        }

        //Guardo el lastOnline time
        PreferencesProvider.providePreferences().edit().putLong("lastOnline",
                millis).commit();
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


    //7. Resetting the game play (0.5 points)
    public void onClickResetLivesBt(){

        boolean result = PreferencesProvider.providePreferences().edit().putInt("current_level",
                0).commit();

        Log.d("AdventureViewModel", "Sha fet correctament el apply(). result = " + result);
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
