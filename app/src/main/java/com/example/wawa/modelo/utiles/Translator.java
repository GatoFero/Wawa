package com.example.wawa.modelo.utiles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.wawa.MapThemeActivity;
import com.example.wawa.modelo.activitys.QuestionsActivity;
import com.example.wawa.modelo.activitys.ThemeActivity;
import com.example.wawa.modelo.cuestionarios.Questionary;
import com.example.wawa.modelo.temas.Page;
import com.example.wawa.modelo.temas.ThemeName;

public class Translator {
    private Translator(){
    }
    public static void setTranslator(Context context, Button button, TextView textView, int theme){
        button.setOnClickListener(view -> translateThemeActivity(context,theme));
        textView.setText(ThemeName.getNameTheme(theme));
        ThemeName.renderTheme(button,textView,theme);
    }
    private static void translateThemeActivity(Context context, int theme){
        ThemeName.setThemeSelect(theme);
        Intent intent = new Intent(context, ThemeActivity.class);
        Page.setTitlesSelects();
        Questionary.setQuestionarySelect();
        context.startActivity(intent);
    }
    public static void translateActivity(Context context, Class<?> activity){
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }
    public static void themeComplete(Context context){
        ThemeName.checkTheme();
        Intent intent = new Intent(context, MapThemeActivity.class);
        context.startActivity(intent);
    }
}
