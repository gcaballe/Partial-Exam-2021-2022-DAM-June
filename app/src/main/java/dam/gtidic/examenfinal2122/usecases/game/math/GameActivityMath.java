package dam.gtidic.examenfinal2122.usecases.game.math;

import android.content.Intent;
import android.util.Log;
import android.view.ViewStub;

import androidx.lifecycle.ViewModelProvider;


import dam.gtidic.examenfinal2122.R;
import dam.gtidic.examenfinal2122.usecases.game.GameActivity;
import dam.gtidic.examenfinal2122.usecases.game.level.math.MathLevelViewModel;


public class GameActivityMath extends GameActivity {

    private static final String TAG = "GameActivityMath";

    @Override
    public void setViewModel() {
        viewModel = new ViewModelProvider(this).get(MathLevelViewModel.class);
    }

    @Override
    public void inflateGameModeLayout() {
        Log.d(TAG, "...inflating @layout_math");
        ViewStub vs = binding.VSlevelLayout.getViewStub();
        vs.setLayoutResource(R.layout.math_layout);
        binding.VSlevelLayout.getViewStub().inflate();
    }

    @Override
    public void reload() {
        startActivity(new Intent(this, GameActivityMath.class));
    }

}