package com.example.wawa.modelo.temas;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ThemeName {

    private static final ArrayList<Integer> roadmap = new ArrayList<>();
    public static final int COMPLETE = Color.parseColor("#76EF77");
    public static int themeSelect = 0;

    private ThemeName(){}

    public static String getNameTheme(int name){
        ArrayList<String> nameThemes = new ArrayList<>();
        if(Theme.languages == 0){
            nameThemes.add("1. Matemáticas");
            nameThemes.add("2. Suma");
            nameThemes.add("3. Resta");
            nameThemes.add("4. Multiplicació");
            nameThemes.add("5. División");
            nameThemes.add("6. Potencia");
            nameThemes.add("7. Raíz");
            nameThemes.add("8. Operaciones Combinadas");
        } else if(Theme.languages == 1) {
            nameThemes.add("1. Ñawrayupa");
            nameThemes.add("2. Yapay");
            nameThemes.add("3. Qichuy");
            nameThemes.add("4. Mirachiy");
            nameThemes.add("5. Rakinakuy");
            nameThemes.add("6. Kallpa");
            nameThemes.add("7. Sapi");
            nameThemes.add("8. Huñusqa Llamkaykunata");
        }
        return nameThemes.get(name);
    }
    public static void renderTheme(Button button, TextView textView, int name){
        for(Integer num : roadmap){
            if(num == name){
                button.setBackgroundColor(COMPLETE);
                textView.setTextColor(COMPLETE);
                break;
            }
        }
    }
    public static void checkTheme(){
        boolean add = true;
        for(Integer theme : roadmap){
            if (theme == themeSelect) {
                add = false;
                break;
            }
        }
        if(add){
            roadmap.add(themeSelect);
        }
    }
    public static void setThemeSelect(int themeSelect) {
        ThemeName.themeSelect = themeSelect;
    }
}
