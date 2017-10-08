package com.dimasolovyev.transations.view;

import android.content.Context;
import android.support.transition.Transition;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @author dimasolovyev
 */

public class AnimatedFrameLayout extends FrameLayout implements AnimatedLayout {

    private AnimatedLayoutDelegate mDelegate;

    public AnimatedFrameLayout(Context context) {
        this(context, null);
    }

    public AnimatedFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimatedFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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

    public void setEnterTransition(Transition transition) {
        mDelegate.setTransition(AnimatedLayoutDelegate.TransationType.ENTER, transition);
    }

    public void setExitTransition(Transition transition) {
        mDelegate.setTransition(AnimatedLayoutDelegate.TransationType.ENTER, transition);
    }

    public void setReEnterTransition(Transition transition) {
        mDelegate.setTransition(AnimatedLayoutDelegate.TransationType.POPENTER, transition);
    }

    public void setReturnTransition(Transition transition) {
        mDelegate.setTransition(AnimatedLayoutDelegate.TransationType.POPEXIT, transition);
    }

    public void setAllowReturnTransitionOverlap(boolean allow) {
        mDelegate.setAllowTransationOverlap(AnimatedLayoutDelegate.TransationType.POPENTER, allow);
    }

    public void setAllowEnterTransitionOverlap(boolean allow) {
        mDelegate.setAllowTransationOverlap(AnimatedLayoutDelegate.TransationType.ENTER, allow);
    }
}

