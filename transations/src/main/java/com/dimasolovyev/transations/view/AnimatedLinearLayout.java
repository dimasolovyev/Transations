package com.dimasolovyev.transations.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author dimasolovyev
 */

public class AnimatedLinearLayout extends LinearLayout implements AnimatedLayout {

    private AnimatedLayoutDelegate mDelegate;

    public AnimatedLinearLayout(Context context) {
        this(context, null);
    }

    public AnimatedLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimatedLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mDelegate = new AnimatedLayoutDelegate(this);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mDelegate.onAttachedToWindow();
    }

    public void setTransationListener(TransationListener listener) {
        mDelegate.setTransationListener(listener);
    }

    public void setEnterAnimationValue(float value) {
        mDelegate.setAnimationValue(AnimatedLayoutDelegate.TransationType.ENTER, value);
    }

    public float getEnterAnimationValue() {
        return mDelegate.getAnimationValue(AnimatedLayoutDelegate.TransationType.ENTER);
    }

    public void setExitAnimationValue(float value) {
        mDelegate.setAnimationValue(AnimatedLayoutDelegate.TransationType.EXIT, value);
    }

    public float getExitAnimationValue() {
        return mDelegate.getAnimationValue(AnimatedLayoutDelegate.TransationType.EXIT);
    }

    public void setPopEnterAnimationValue(float value) {
        mDelegate.setAnimationValue(AnimatedLayoutDelegate.TransationType.POPENTER, value);
    }

    public float getPopEnterAnimationValue() {
        return mDelegate.getAnimationValue(AnimatedLayoutDelegate.TransationType.POPENTER);
    }

    public void setPopExitAnimationValue(float value) {
        mDelegate.setAnimationValue(AnimatedLayoutDelegate.TransationType.POPEXIT, value);
    }

    public float getPopExitAnimationValue() {
        return mDelegate.getAnimationValue(AnimatedLayoutDelegate.TransationType.POPEXIT);
    }
}
