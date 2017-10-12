package com.example.wesleysantos.aluguel.view.start_up;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.wesleysantos.aluguel.R;
import com.example.wesleysantos.aluguel.view.fragments.MainActivity;

public class LoadActivity extends AppCompatActivity {

    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout mainLayout = new RelativeLayout(this);
        createStartView();
        mainLayout.addView(logo);
        setContentView(mainLayout);
    }
    /*
        @description - sets a view with an image in the center of the screen
     */
    private void createStartView(){

        logo = new ImageView(this);

        logo.setImageDrawable(Drawable.createFromPath("/res/mipmap-xxxhdpi/logo.png"));

        logo.setScaleType(ImageView.ScaleType.FIT_CENTER);
        logo.setImageResource(R.mipmap.logo);
        logo.setMinimumHeight((int)(getScreenSize().widthPixels*0.65));
        logo.setMinimumWidth((int)(getScreenSize().widthPixels*0.65));
        RelativeLayout.LayoutParams layoutParams =new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        logo.setLayoutParams(layoutParams);
        blink(logo,1600,3);
    }
    /*
        @description - this method is responsible for the animation when the app is opened
     */
    private void blink(View target, long period, final int times){

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(target,"alpha",1f,.3f);
        fadeIn.setDuration(period);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(target,"alpha",.3f,1f);
        fadeOut.setDuration(period);

        AnimatorSet animation = new AnimatorSet();
        animation.play(fadeOut).after(fadeIn);
        animation.addListener(new BlinkAnimatorListenerAdapter(times));
        animation.start();
    }
    /*
        @description - this method gets the screen dimensions
        @return - screen dimensions
     */
    private DisplayMetrics getScreenSize(){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }
    /*
        @description - class to set the blinking behavior - how many times the function blink will be called - of the animation
     */
    private class BlinkAnimatorListenerAdapter extends AnimatorListenerAdapter {
        private int times;

        private BlinkAnimatorListenerAdapter(int times){
            this.times = times;
        }

        @Override
        public void onAnimationEnd(Animator animation) {

            if(times>1){
                animation.start();
                times--;
            }else{
                Intent i = new Intent(LoadActivity.this, MainActivity.class);
                finish();
                startActivity(i);
            }


        }
    }
}
