package com.example.wawa.modelo.interfaces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public interface ComponentsManager {

    default TextView createTextView(Context ctx){
        TextView textView = new TextView(ctx);
        textView.setId(View.generateViewId());
        return textView;
    }
    default Button createButton(Context ctx){
        Button button = new Button(ctx);
        button.setId(View.generateViewId());
        return button;
    }
    default boolean removeButton(Button button){
        ViewParent parent = button.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(button);
        }
        return false;
    }
    default boolean removeTextView(TextView textView){
        ViewParent parent = textView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(textView);
        }
        return false;
    }
    default void positionView(ConstraintLayout clt, @NonNull View view, float verticalBias, float horizontalBias){
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(clt);
        constraintSet.connect(view.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        constraintSet.connect(view.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        constraintSet.connect(view.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.connect(view.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        constraintSet.setVerticalBias(view.getId(), verticalBias);
        constraintSet.setHorizontalBias(view.getId(), horizontalBias);
        constraintSet.applyTo(clt);
    }
    default void setTextView(@NonNull TextView view, String content){
        view.setText(content);
    }

    void createComponentsView();
    boolean setFunctionButton(Button button, int type, float horizontalBias);
    boolean setFunctionQuestionary(Button button);
}
