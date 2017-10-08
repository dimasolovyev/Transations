package com.dimasolovyev.transations.view;

import android.support.transition.Transition;

/**
 * @author dimasolovyev
 */

interface AnimatedLayout {
    void setEnterAnimationValue(float value);
    void setExitAnimationValue(float value);

    void setPopEnterAnimationValue(float value);
    void setPopExitAnimationValue(float value);

    void setTransationListener(TransationListener listener);

    void setEnterTransition(Transition transition);
    void setExitTransition(Transition transition);
    void setReEnterTransition(Transition transition);
    void setReturnTransition(Transition transition);
    void setAllowReturnTransitionOverlap(boolean allow);
    void setAllowEnterTransitionOverlap(boolean allow);
}
