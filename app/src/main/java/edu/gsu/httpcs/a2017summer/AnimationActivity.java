package edu.gsu.httpcs.a2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity {

    private Animation alphAnimation, scaleAnimation, rotateAnimation, transAnimation, setAnimation;

    @BindView(R.id.activity_animation_tv)
    TextView textView;

    @OnClick(R.id.activity_animation_alpha)
    public void alpha (View v) {
        textView.startAnimation(alphAnimation);
    }
    @OnClick(R.id.activity_animation_scale)
    public void scale (View v) {
        textView.startAnimation(scaleAnimation);
    }
    @OnClick(R.id.activity_animation_rotate)
    public void rotate (View v) {
        textView.startAnimation(rotateAnimation);
    }
    @OnClick(R.id.activity_animation_trans)
    public void trans (View v) {
        textView.startAnimation(transAnimation);
    }
    @OnClick(R.id.activity_animation_set)
    public void set (View v) {
        textView.startAnimation(setAnimation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initialAnimation();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortToast("You clicked TextView.");
            }
        });

    }

    private void initialAnimation() {
        alphAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        transAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
    }
}
