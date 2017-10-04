package com.dimasolovyev.transations.view;

import android.support.transition.AutoTransition;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimasolovyev
 */

class AnimatedLayoutDelegate {
    private Map<TransationType, Transation> mTransations;
    private ViewGroup mSceneRoot;
    private TransationListener mListener;

    AnimatedLayoutDelegate(ViewGroup sceneRoot) {
        mSceneRoot = sceneRoot;
        mTransations = new HashMap<>();
        mTransations.put(TransationType.ENTER, new Transation());
        mTransations.put(TransationType.EXIT, new Transation());
        mTransations.put(TransationType.POPENTER, new Transation());
        mTransations.put(TransationType.POPEXIT, new Transation());
    }

    void onAttachedToWindow() {
        changeSceneManually(TransationType.POPEXIT);
    }

    void setTransationListener(TransationListener listener) {
        mListener = listener;
    }

    void setAnimationValue(TransationType type, float value) {
        Transation transation = mTransations.get(type);

        transation.value = value;

        if (!transation.started && value > 0) {
            transation.started = true;
            animate(type, transation);
        }
    }

    float getAnimationValue(TransationType type) {
        return mTransations.get(type).value;
    }

    private void animate(TransationType type, Transation transation) {
        Transition transition = transation.transition;

        if (transition == null) {
            transition = generateDefaultTransition(type, mSceneRoot);
        }

        transition.setDuration(500);
        TransitionManager.beginDelayedTransition(mSceneRoot, transition);
        changeSceneManually(type);
    }

    private Transition generateDefaultTransition(TransationType type, ViewGroup viewGroup) {
        int ordering;

        switch (type) {
            case EXIT:
            case POPEXIT:
                ordering = TransitionSet.ORDERING_TOGETHER;
                break;
            default:
                ordering = TransitionSet.ORDERING_SEQUENTIAL;
        }

        TransitionSet result = new TransitionSet().setOrdering(ordering);

        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);

            if (view instanceof ViewGroup) {
                result.addTransition(generateDefaultTransition(type, (ViewGroup) view));
            } else {
                result.addTransition(new AutoTransition().addTarget(view));
            }
        }

        return result;
    }

    private void changeSceneManually(TransationType type) {
        if (mListener != null) {
            mListener.changeSceneManually(type);
            return;
        }

        int visibility;

        switch (type) {
            case EXIT:
            case POPEXIT:
                visibility = View.GONE;
                break;
            default:
               visibility = View.VISIBLE;
        }

        changeViewsManually(mSceneRoot, visibility);
    }

    private void changeViewsManually(ViewGroup viewGroup, int visibility) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);

            if (view instanceof ViewGroup) {
                changeViewsManually((ViewGroup) view, visibility);
            } else {
                view.setVisibility(visibility);
            }
        }
    }

    enum TransationType {
        ENTER,
        EXIT,
        POPENTER,
        POPEXIT
    }

    private class Transation {
        private Transition transition;
        private boolean started = false;
        private float value = 0;
    }
}
