package com.wrp.transition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Scene mAScene;
    Scene mAnotherScene;
    ViewGroup mSceneRoot;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Transition transition = new Fade(Fade.IN);
        transition.setDuration(2000);
// Create the scene root for the scenes in this app
        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);

// Create the scenes
        mAScene = Scene.getSceneForLayout(mSceneRoot, R.layout.a_scene, this);
        mAnotherScene =
                Scene.getSceneForLayout(mSceneRoot, R.layout.another_scene, this);


        TransitionManager.go(mAScene, transition);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transition transition1 = new Fade(Fade.OUT);
                transition1.setDuration(2000);
                TransitionManager.go(mAScene,transition1);
            }
        });


    }
}
