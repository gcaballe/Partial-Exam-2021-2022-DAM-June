package dam.gtidic.examenfinal2122.usecases.game;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import dam.gtidic.examenfinal2122.databinding.ActivityGameBinding;
import dam.gtidic.examenfinal2122.usecases.adventure.AdventureActivity;

public abstract class GameActivity extends AppCompatActivity {

    protected GameViewModel viewModel;
    protected ActivityGameBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setViewModel();

        setup();
        data();

    }

    // Public methods
    public abstract  void setViewModel();
    public abstract void inflateGameModeLayout();
    public abstract void reload();

    // Private methods
    private void setup(){
       binding.setViewModel(viewModel);
       binding.setLifecycleOwner(this);
       inflateGameModeLayout();

        this.getOnBackPressedDispatcher().addCallback(this,
                new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }

    private void data() {
        if (viewModel.moreLevels()) {

            viewModel.isLevelValid().observe(this, passed -> {
                Log.d(this.getClass().getSimpleName(), "is level passed? " + passed);
                if (passed) {
                    showNext();
                } else {
                    showHome();
                }
            });

        } else {
            showHome();
        }
    }

    private void showNext(){
        Log.d(this.getClass().getSimpleName(), "there are more level in this adventure? " + viewModel.moreLevels());
        if ( viewModel.moreLevels()){
            reload();
            finish();
        }else{
            showHome();
        }
    }

    private void showHome(){
        Intent i = new Intent(this, AdventureActivity.class);
        startActivity(i);
        finish();
    }

}