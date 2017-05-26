package com.example.demo.idemo.anim;import android.animation.Animator;import android.animation.ObjectAnimator;import android.os.Bundle;import android.view.View;import android.widget.ImageView;import com.example.demo.idemo.R;import com.example.demo.idemo.base.BaseActivity;/** * @author mayong * @date 创建时间 2017/5/25 * @description ObjectAnimator的使用 */public class ObjectAnimatorActivity extends BaseActivity implements View.OnClickListener {    private ImageView ivTranslation;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_object_animator);        ivTranslation = (ImageView) findViewById(R.id.iv_objectanima_translation);        initListener();    }    private void initListener() {        ivTranslation.setOnClickListener(this);    }    @Override    public void onClick(View v) {        switch (v.getId()) {            case R.id.iv_objectanima_translation:                animTranslationX();                break;        }    }    private boolean isInitLocation = true;//true:在初始位置 false不在    /**     * 水平动画     */    private void animTranslationX() {        ObjectAnimator objectAnimator = null;        /**         *  ofFloat中的四个参数，第一个是动画对应的目标，第二个是动画的属性名称，本例中第三个参数和第四个参数         *  是相对于第一个参数中目标的起始位置而言的，         *  如果第三个参数是0，第四个是300动画的其实位置就是控件的初始位置         *  结束位置就是初始位置右边300像素的位置         *         *  如果第三个参数是300，第四个是0，那么动画的起始位置是控件初始位置右边300的距离，结束为止是初始位置0         */        if (isInitLocation) {            objectAnimator = ObjectAnimator.ofFloat(ivTranslation, "translationX", 0f, 300f);        } else {            objectAnimator = ObjectAnimator.ofFloat(ivTranslation, "translationX", 300f, 0f);        }        objectAnimator.setDuration(600);        objectAnimator.start();        objectAnimator.addListener(new Animator.AnimatorListener() {            @Override            public void onAnimationStart(Animator animation) {            }            @Override            public void onAnimationEnd(Animator animation) {                isInitLocation = !isInitLocation;            }            @Override            public void onAnimationCancel(Animator animation) {            }            @Override            public void onAnimationRepeat(Animator animation) {            }        });    }}