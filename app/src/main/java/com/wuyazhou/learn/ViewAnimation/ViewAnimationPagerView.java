package com.wuyazhou.learn.ViewAnimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.butterknife.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class ViewAnimationPagerView extends FrameLayout {
    private Context mContext = null;
    private RelativeLayout mLayout;
    @BindView(R.id.view)
    View mAnimationView;
    private Animation mAnimationTranslate;
    private Animation mAnimationScale;
    private Animation mAnimationRotate;
    private Animation mAnimationAlpha;
    private AnimationSet mAnimationSet;

    public ViewAnimationPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public ViewAnimationPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public ViewAnimationPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_view_animation_layout, null);
        addView(mLayout);
        ButterKnife.bind(this,mLayout);

        mAnimationTranslate = AnimationUtils.loadAnimation(mContext,R.anim.view_translate);
        mAnimationScale = AnimationUtils.loadAnimation(mContext,R.anim.view_scale);
        mAnimationRotate = AnimationUtils.loadAnimation(mContext,R.anim.view_rotate);
        mAnimationAlpha = AnimationUtils.loadAnimation(mContext,R.anim.view_alpha);

        mAnimationSet = new AnimationSet(true);
        mAnimationSet.addAnimation(mAnimationTranslate);
        mAnimationSet.addAnimation(mAnimationScale);
        mAnimationSet.addAnimation(mAnimationRotate);
        mAnimationSet.addAnimation(mAnimationAlpha);
        mAnimationSet.setFillAfter(true);
    }

    @OnClick(R.id.model_button_1)
    void onclickAnimationTranslate(){
        mAnimationView.startAnimation(mAnimationTranslate);
    }

    @OnClick(R.id.model_button_2)
    void onclickAnimationRotate(){
        mAnimationView.startAnimation(mAnimationRotate);
    }

    @OnClick(R.id.model_button_3)
    void onclickAnimationScale(){
        mAnimationView.startAnimation(mAnimationScale);
    }

    @OnClick(R.id.model_button_4)
    void onclickAnimationAlpha(){
        mAnimationView.startAnimation(mAnimationAlpha);
    }

    @OnClick(R.id.model_button_5)
    void onclickAnimationSet(){
        mAnimationView.startAnimation(mAnimationSet);
    }
}
