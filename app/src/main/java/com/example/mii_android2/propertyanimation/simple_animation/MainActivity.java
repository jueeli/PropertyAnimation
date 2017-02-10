package com.example.mii_android2.propertyanimation.simple_animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mii_android2.propertyanimation.R;

public class MainActivity extends AppCompatActivity {

    Button btn_rotate, btn_scale, btn_trans, btn_set;
    ImageView img_ball;
    Animator a_rotate, a_scale, a_trans, a_alpha;
    CoordinatorLayout coordinatorLayout;
    LinearLayout rd_layout;
    int ctr=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_rotate = (Button) findViewById(R.id.btn_rotate);
        btn_scale = (Button) findViewById(R.id.btn_scale);
        btn_trans = (Button) findViewById(R.id.btn_translate);
        btn_set= (Button) findViewById(R.id.btn_set);
        rd_layout= (LinearLayout) findViewById(R.id.rd_layout);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        img_ball = (ImageView) findViewById(R.id.img_ball);


        rd_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim;

                if (ctr%2==0){

                    anim=ObjectAnimator.ofObject(rd_layout,"backgroundColor",new ArgbEvaluator(), Color.CYAN,Color.RED);
                }
                else {
                    anim=ObjectAnimator.ofObject(rd_layout,"backgroundColor",new ArgbEvaluator(), Color.RED,Color.CYAN);

                }

                anim.setDuration(2000);
                anim.start();
                ctr++;
            }
        });

        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animator animate = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.set);
                animate.setTarget(img_ball);
                animate.start();

            }
        });


        btn_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a_rotate = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rotate);
                a_rotate.setTarget(img_ball);
                a_rotate.start();
            }
        });

        btn_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a_scale = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.scale);
                a_scale.setTarget(img_ball);
                a_scale.start();
            }
        });

        btn_trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a_trans = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.trans);
                a_trans.setTarget(img_ball);
                a_trans.start();
            }
        });


    }

    Animator.AnimatorListener animationOutListener
            = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {


            if (animator == a_rotate) {
                Snackbar.make(coordinatorLayout, "Start Rotate Animation", Snackbar.LENGTH_LONG).show();

            }

            if (animator == a_scale) {
                Snackbar.make(coordinatorLayout, "Start Scale Animation", Snackbar.LENGTH_LONG).show();

            }

            if (animator == a_trans) {
                Snackbar.make(coordinatorLayout, "Start Translate Animation", Snackbar.LENGTH_LONG).show();

            }

        }

        @Override
        public void onAnimationEnd(Animator animator) {

        }

        @Override
        public void onAnimationCancel(Animator animator) {

        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }
    };
}