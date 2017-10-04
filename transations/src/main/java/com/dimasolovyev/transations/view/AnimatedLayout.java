package com.dimasolovyev.transations.view;

/**
 * @author dimasolovyev
 */

interface AnimatedLayout {
    void setEnterAnimationValue(float value);
    void setExitAnimationValue(float value);

    void setPopEnterAnimationValue(float value);
    void setPopExitAnimationValue(float value);

    void setTransationListener(TransationListener listener);
}
