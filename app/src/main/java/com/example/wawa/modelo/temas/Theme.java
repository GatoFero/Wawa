package com.example.wawa.modelo.temas;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.wawa.modelo.activitys.QuestionsActivity;
import com.example.wawa.modelo.interfaces.ComponentsManager;
import com.example.wawa.modelo.utiles.Translator;

public class Theme implements ComponentsManager {

    private Button next;
    private Button back;
    private Button complete;
    private boolean flagNext = false;
    private boolean flagBack = false;
    private boolean flagComplete = false;
    private TextView titleView;
    private TextView contentView;
    private final Context ctx;
    private final ConstraintLayout clt;
    private final Page pages;

    public static int languages = 0;
    public static void languageSpanish(){
        languages = 0;
    }
    public static void languageQuechua(){
        languages = 1;
    }


    public Theme(Context ctx, ConstraintLayout clt, Page page) {
        this.ctx = ctx;
        this.clt = clt;
        this.pages = page;
        createComponentsView();
    }
    public void chargePage(int count){
        pages.renderPage(count);
        checkButtons();
    }
    @Override
    public void createComponentsView() {
        titleView = createTextView(ctx);
        contentView = createTextView(ctx);

        clt.addView(titleView);
        clt.addView(contentView);

        assert titleView != null;
        positionView(clt,titleView,0.25f,0.5f);
        assert contentView != null;
        positionView(clt,contentView,0.45f,0.5f);
    }
    public void checkButtons() {
        //Me crea el boton de next
        if (pages.getTotalPages() > 0 && pages.getCountPage() < pages.getTotalPages() - 1) {
            if (!flagNext) {
                next = createButton(ctx);
                flagNext = setFunctionButton(next, 1, 0.7f);
            }
        } else {
            if (next != null) {
                flagNext = removeButton(next);
            }
        }
        //Me crea el boton de back
        if (pages.getCountPage() > 0) {
            if (!flagBack) {
                back = createButton(ctx);
                flagBack = setFunctionButton(back, -1, 0.3f);
            }
        } else {
            if (back != null) {
                flagBack = removeButton(back);
            }
        }
        //Me crea el boton de complete
        if(pages.getCountPage() == pages.getTotalPages()-1){
            if(!flagComplete){
                complete = createButton(ctx);
                flagComplete = setFunctionQuestionary(complete);
            }
        }else{
            if(complete != null){
                flagComplete = removeButton(complete);
            }
        }
    }
    @Override
    public boolean setFunctionButton(Button button, int type, float bias){
        clt.addView(button);
        positionView(clt,button,0.8f,bias);
        String buttonText = type == 1? "->" : "<-";
        button.setText(buttonText);
        button.setOnClickListener(view -> chargePage(type));
        return true;
    }
    @Override
    public boolean setFunctionQuestionary(Button button){
        clt.addView(button);
        positionView(clt,button,0.95f,0.5f);
        String buttonText;
        if(languages == 0){
            buttonText = "Responder";
        }else{
            buttonText = "Kutichiy";
        }
        button.setText(buttonText);
        button.setBackgroundColor(ThemeName.COMPLETE);
        button.setOnClickListener(view -> Translator.translateActivity(ctx, QuestionsActivity.class));
        return true;
    }
    public TextView getTitleView() {
        return titleView;
    }
    public TextView getContentView() {
        return contentView;
    }
}
