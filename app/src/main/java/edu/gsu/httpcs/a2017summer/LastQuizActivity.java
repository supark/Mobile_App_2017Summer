package edu.gsu.httpcs.a2017summer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpcs.a2017summer.util.UtilLog;

public class LastQuizActivity extends BaseActivity implements View.OnTouchListener  {

    private GestureDetector gestureDetector;
    private int sumX=0, sumY=0;
    private ValueAnimator repeatAnimator;


    @BindView(R.id.quiz5_blank)
    TextView tv;

    public void startAnimator() {
        repeatAnimator = doAnimatorListener();
//        repeatAnimator.setStartDelay(3000);//it start after 3 seconds
        repeatAnimator.start();
    }


    public void cancelAnimator() {
        repeatAnimator.cancel();
        repeatAnimator.removeAllListeners();
        repeatAnimator.removeAllUpdateListeners();
    }

    private ValueAnimator doAnimatorListener() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 600);  //position how many pixels you want to change

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(), curValue, tv.getRight(), curValue+tv.getHeight());  //showing animator
                // thru TextView using layout method with 4 parameters(set up for displaying area is vertical way)
                //that means only moves from top to bottom(tv.getLeft() is starting position)
            }
        });
        animator.addListener(new Animator.AnimatorListener() {  //animator.addListener is showing each statues
            @Override
            public void onAnimationStart(Animator animation) {
//                shortToast("Started");
                UtilLog.d("Yes", "animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                shortToast("Ended");
                UtilLog.d("Yes", "animation end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                shortToast("Canceled");
                UtilLog.d("Yes", "animation cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                shortToast("Repeated");
                UtilLog.d("Yes", "animation repeat");
            }
        });

        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(1);
        animator.setInterpolator(new CycleInterpolator(2));  //another options are in the anim_alpha.xml
        animator.setDuration(5000);//set up the duration of the animation
        return animator;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_quiz);
        ButterKnife.bind(this);

        gestureDetector = new GestureDetector(this, new simpleGestureListener());
        tv.setOnTouchListener(this);  //(this) is View.OnTouchListener
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener implements GestureDetector.OnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return onDown(e);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            onShowPress(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return onSingleTapUp(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            sumX += distanceX;
            sumY += distanceY;
            return onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            onLongPress(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //if()

            if(sumX < 0) {
                if(Math.abs(sumX)>200) { //1000

                    shortToast("You scroll from left to right");
                    //startAnimator();
                }
            }
            if(sumX > 0) {
                if(Math.abs(sumX)>200) {
                    shortToast("You scroll from right to left");
                }
            }
            if(sumY < 0) {
                if(Math.abs(sumY)>1000) {
                    shortToast("You scroll from top to bottom");
                }
            }
            if(sumY > 0) {
                if(Math.abs(sumY)>1000) {
                    shortToast("You scroll from bottom to top");
                }
            }
            return onFling(e1, e2, velocityX, velocityY);
        }
    }
}
