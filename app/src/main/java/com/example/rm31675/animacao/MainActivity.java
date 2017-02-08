package com.example.rm31675.animacao;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private EditText etNome;
    private EditText etPwd;
    private Animation translate;
    private Animation animacao;
    private ImageView imgRyu;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = (EditText) findViewById(R.id.etName);
        etPwd = (EditText) findViewById(R.id.etPwd);
        imgRyu = (ImageView) findViewById(R.id.imgRyu);

        animacao = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacao);
        mediaPlayer = MediaPlayer.create(this, R.raw.hadouken);

        TextView tvLabelHello = (TextView) findViewById(R.id.labelhello);
        tvLabelHello.startAnimation(animacao);
    }

    public void validateLogin(View v) {
        translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
        if(!etPwd.getText().toString().equals("1234")){
            etPwd.startAnimation(translate);
        } else {
            imgRyu.setBackgroundResource(R.drawable.hadouken);
            AnimationDrawable frameAnimation = (AnimationDrawable) imgRyu.getBackground();
            frameAnimation.start();
        }

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        mediaPlayer.start();
    }
}
