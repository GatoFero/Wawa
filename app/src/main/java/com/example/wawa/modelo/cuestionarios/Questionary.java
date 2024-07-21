package com.example.wawa.modelo.cuestionarios;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.wawa.modelo.interfaces.ComponentsManager;
import com.example.wawa.modelo.temas.Theme;
import com.example.wawa.modelo.temas.ThemeName;
import com.example.wawa.modelo.utiles.Translator;

import java.util.ArrayList;
import java.util.Arrays;

public class Questionary implements ComponentsManager {

    private final static ArrayList<ArrayList<String>> questions = new ArrayList<>();
    private final static ArrayList<Integer> allResponses = new ArrayList<>();

    private TextView questionView;
    private Button firstOption;
    private Button secondOption;
    private Button thirdOption;
    private int countQuestion = 0;

    private final Context ctx;
    private final ConstraintLayout clt;

    private boolean flagQuestion = false;
    private boolean flagFirst = false;
    private boolean flagSecond = false;
    private boolean flagThird = false;

    public Questionary(Context ctx, ConstraintLayout clt) {
        this.ctx = ctx;
        this.clt = clt;
        createComponentsView();
        renderQuestion();
    }
    @Override
    public void createComponentsView(){
        if(!flagQuestion){
            questionView = createTextView(ctx);
            clt.addView(questionView);
            assert questionView != null;
            positionView(clt,questionView,0.4f,0.5f);
            flagQuestion = true;
        }
        if (!flagFirst && !flagSecond && !flagThird){
            firstOption = createButton(ctx);
            flagFirst = setFunctionButton(firstOption,1,0.55f);
            secondOption = createButton(ctx);
            flagSecond = setFunctionButton(secondOption,2,0.63f);
            thirdOption = createButton(ctx);
            flagThird = setFunctionButton(thirdOption,3,0.71f);
        }
    }
    private void renderQuestion(){
        setTextView(questionView,questions.get(countQuestion).get(0));
        setTextView(firstOption,questions.get(countQuestion).get(1));
        setTextView(secondOption,questions.get(countQuestion).get(2));
        setTextView(thirdOption,questions.get(countQuestion).get(3));
    }
    @Override
    public boolean setFunctionButton(Button button, int type, float bias) {
        clt.addView(button);
        positionView(clt,button,bias,0.5f);
        button.setOnClickListener(view -> responseQuestion(type));
        return true;
    }
    private void responseQuestion(int response){
        boolean complete = false;
        countQuestion = response == allResponses.get(countQuestion)? responseCorrect() : ++countQuestion;
        if(countQuestion == allResponses.size()){
            countQuestion = 0;
        }
        if (questions.isEmpty()){
            complete = true;
        }
        if(!complete){
            renderQuestion();
        }else {
            Translator.themeComplete(ctx);
        }

    }
    private int responseCorrect(){
        allResponses.remove(countQuestion);
        questions.remove(countQuestion);
        return countQuestion;
    }
    @Override
    public boolean setFunctionQuestionary(Button button) {
        return false;
    }
    public static void setQuestionarySelect(){
        questions.clear();
        allResponses.clear();
        switch (ThemeName.themeSelect){
            case 0:
                setQuestions1();
                break;
            case 1:
                break;
        }
    }
    @SafeVarargs
    private static void setQuestions(ArrayList<String>... questions){
        Questionary.questions.addAll(Arrays.asList(questions));
    }
    private static void setResponses(int... responses) {
        for (int response : responses) {
            allResponses.add(response);
        }
    }
    private static ArrayList<String> createQuestions(String... fields){
        return new ArrayList<>(Arrays.asList(fields));
    }
    public static void setQuestions8(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las matemáticas?","A. Una forma de contar y medir cosas.","B. Un tipo de comida.","C. Un juego de cartas.");
                question2 = createQuestions("¿Cómo nos ayudan las matemáticas?","A. A dibujar animales.","B. A contar, medir, y entender el mundo que nos rodea.","C. A cocinar alimentos.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("¿Cuál es una forma simple de usar las matemáticas?","A. Dibujar en un papel.","B. Cantar una canción.","C. Contar nuestros dedos.");
                question5 = createQuestions("¿Cómo nos ayudan las matemáticas en la vida diaria?","A. A elegir el color de nuestros zapatos.","B. A decidir qué película ver.","C. A saber cuántos globos necesitamos para una fiesta.");
                break;
            case 1:
                question1 = createQuestions("¿Imapaq kay matematika?","A. Huk rikch'akuyta, ñawirinkuyta ruwanakuykuna.","B. Huk mikuy hina.","C. Huk q'ipinakuyta.");
                question2 = createQuestions("¿Imashina yanapakun matematikakuna?","A. Uywanata q'ipiyta","B. Rikch'akuyta, ñawirinkuyta, yachayta ñawirinkuyta qespiyta.","C. Mikuyta waykuyta.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("¿Iman chay rikch'akuy kay matematika ch'askiyta?","A. Papayta ruwakuy.","B. Takiyta.","C. Ñawirinkuykuna.");
                question5 = createQuestions("¿Imashina kay matematikakuna yanapakun kawsaypi?","A. Sapichaqkuna kunanapak ñawiykuna.","B. Chayllata ruwanaykuna tiyuykuna.","C. Kay globokunata ruwanaykuna llimp’ukunata p’unchaypi.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,2,1,3,3);
    }
    public static void setQuestions7(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las matemáticas?","A. Una forma de contar y medir cosas.","B. Un tipo de comida.","C. Un juego de cartas.");
                question2 = createQuestions("¿Cómo nos ayudan las matemáticas?","A. A dibujar animales.","B. A contar, medir, y entender el mundo que nos rodea.","C. A cocinar alimentos.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("¿Cuál es una forma simple de usar las matemáticas?","A. Dibujar en un papel.","B. Cantar una canción.","C. Contar nuestros dedos.");
                question5 = createQuestions("¿Cómo nos ayudan las matemáticas en la vida diaria?","A. A elegir el color de nuestros zapatos.","B. A decidir qué película ver.","C. A saber cuántos globos necesitamos para una fiesta.");
                break;
            case 1:
                question1 = createQuestions("¿Imapaq kay matematika?","A. Huk rikch'akuyta, ñawirinkuyta ruwanakuykuna.","B. Huk mikuy hina.","C. Huk q'ipinakuyta.");
                question2 = createQuestions("¿Imashina yanapakun matematikakuna?","A. Uywanata q'ipiyta","B. Rikch'akuyta, ñawirinkuyta, yachayta ñawirinkuyta qespiyta.","C. Mikuyta waykuyta.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("¿Iman chay rikch'akuy kay matematika ch'askiyta?","A. Papayta ruwakuy.","B. Takiyta.","C. Ñawirinkuykuna.");
                question5 = createQuestions("¿Imashina kay matematikakuna yanapakun kawsaypi?","A. Sapichaqkuna kunanapak ñawiykuna.","B. Chayllata ruwanaykuna tiyuykuna.","C. Kay globokunata ruwanaykuna llimp’ukunata p’unchaypi.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,2,1,3,3);
    }
    public static void setQuestions6(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las matemáticas?","A. Una forma de contar y medir cosas.","B. Un tipo de comida.","C. Un juego de cartas.");
                question2 = createQuestions("¿Cómo nos ayudan las matemáticas?","A. A dibujar animales.","B. A contar, medir, y entender el mundo que nos rodea.","C. A cocinar alimentos.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("¿Cuál es una forma simple de usar las matemáticas?","A. Dibujar en un papel.","B. Cantar una canción.","C. Contar nuestros dedos.");
                question5 = createQuestions("¿Cómo nos ayudan las matemáticas en la vida diaria?","A. A elegir el color de nuestros zapatos.","B. A decidir qué película ver.","C. A saber cuántos globos necesitamos para una fiesta.");
                break;
            case 1:
                question1 = createQuestions("¿Imapaq kay matematika?","A. Huk rikch'akuyta, ñawirinkuyta ruwanakuykuna.","B. Huk mikuy hina.","C. Huk q'ipinakuyta.");
                question2 = createQuestions("¿Imashina yanapakun matematikakuna?","A. Uywanata q'ipiyta","B. Rikch'akuyta, ñawirinkuyta, yachayta ñawirinkuyta qespiyta.","C. Mikuyta waykuyta.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("¿Iman chay rikch'akuy kay matematika ch'askiyta?","A. Papayta ruwakuy.","B. Takiyta.","C. Ñawirinkuykuna.");
                question5 = createQuestions("¿Imashina kay matematikakuna yanapakun kawsaypi?","A. Sapichaqkuna kunanapak ñawiykuna.","B. Chayllata ruwanaykuna tiyuykuna.","C. Kay globokunata ruwanaykuna llimp’ukunata p’unchaypi.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,2,1,3,3);
    }
    public static void setQuestions5(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las matemáticas?","A. Una forma de contar y medir cosas.","B. Un tipo de comida.","C. Un juego de cartas.");
                question2 = createQuestions("¿Cómo nos ayudan las matemáticas?","A. A dibujar animales.","B. A contar, medir, y entender el mundo que nos rodea.","C. A cocinar alimentos.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("¿Cuál es una forma simple de usar las matemáticas?","A. Dibujar en un papel.","B. Cantar una canción.","C. Contar nuestros dedos.");
                question5 = createQuestions("¿Cómo nos ayudan las matemáticas en la vida diaria?","A. A elegir el color de nuestros zapatos.","B. A decidir qué película ver.","C. A saber cuántos globos necesitamos para una fiesta.");
                break;
            case 1:
                question1 = createQuestions("¿Imapaq kay matematika?","A. Huk rikch'akuyta, ñawirinkuyta ruwanakuykuna.","B. Huk mikuy hina.","C. Huk q'ipinakuyta.");
                question2 = createQuestions("¿Imashina yanapakun matematikakuna?","A. Uywanata q'ipiyta","B. Rikch'akuyta, ñawirinkuyta, yachayta ñawirinkuyta qespiyta.","C. Mikuyta waykuyta.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("¿Iman chay rikch'akuy kay matematika ch'askiyta?","A. Papayta ruwakuy.","B. Takiyta.","C. Ñawirinkuykuna.");
                question5 = createQuestions("¿Imashina kay matematikakuna yanapakun kawsaypi?","A. Sapichaqkuna kunanapak ñawiykuna.","B. Chayllata ruwanaykuna tiyuykuna.","C. Kay globokunata ruwanaykuna llimp’ukunata p’unchaypi.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,2,1,3,3);
    }
    public static void setQuestions4(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las matemáticas?","A. Una forma de contar y medir cosas.","B. Un tipo de comida.","C. Un juego de cartas.");
                question2 = createQuestions("¿Cómo nos ayudan las matemáticas?","A. A dibujar animales.","B. A contar, medir, y entender el mundo que nos rodea.","C. A cocinar alimentos.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("¿Cuál es una forma simple de usar las matemáticas?","A. Dibujar en un papel.","B. Cantar una canción.","C. Contar nuestros dedos.");
                question5 = createQuestions("¿Cómo nos ayudan las matemáticas en la vida diaria?","A. A elegir el color de nuestros zapatos.","B. A decidir qué película ver.","C. A saber cuántos globos necesitamos para una fiesta.");
                break;
            case 1:
                question1 = createQuestions("¿Imapaq kay matematika?","A. Huk rikch'akuyta, ñawirinkuyta ruwanakuykuna.","B. Huk mikuy hina.","C. Huk q'ipinakuyta.");
                question2 = createQuestions("¿Imashina yanapakun matematikakuna?","A. Uywanata q'ipiyta","B. Rikch'akuyta, ñawirinkuyta, yachayta ñawirinkuyta qespiyta.","C. Mikuyta waykuyta.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("¿Iman chay rikch'akuy kay matematika ch'askiyta?","A. Papayta ruwakuy.","B. Takiyta.","C. Ñawirinkuykuna.");
                question5 = createQuestions("¿Imashina kay matematikakuna yanapakun kawsaypi?","A. Sapichaqkuna kunanapak ñawiykuna.","B. Chayllata ruwanaykuna tiyuykuna.","C. Kay globokunata ruwanaykuna llimp’ukunata p’unchaypi.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,2,1,3,3);
    }
    public static void setQuestions3(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las matemáticas?","A. Una forma de contar y medir cosas.","B. Un tipo de comida.","C. Un juego de cartas.");
                question2 = createQuestions("¿Cómo nos ayudan las matemáticas?","A. A dibujar animales.","B. A contar, medir, y entender el mundo que nos rodea.","C. A cocinar alimentos.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("¿Cuál es una forma simple de usar las matemáticas?","A. Dibujar en un papel.","B. Cantar una canción.","C. Contar nuestros dedos.");
                question5 = createQuestions("¿Cómo nos ayudan las matemáticas en la vida diaria?","A. A elegir el color de nuestros zapatos.","B. A decidir qué película ver.","C. A saber cuántos globos necesitamos para una fiesta.");
                break;
            case 1:
                question1 = createQuestions("¿Imapaq kay matematika?","A. Huk rikch'akuyta, ñawirinkuyta ruwanakuykuna.","B. Huk mikuy hina.","C. Huk q'ipinakuyta.");
                question2 = createQuestions("¿Imashina yanapakun matematikakuna?","A. Uywanata q'ipiyta","B. Rikch'akuyta, ñawirinkuyta, yachayta ñawirinkuyta qespiyta.","C. Mikuyta waykuyta.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("¿Iman chay rikch'akuy kay matematika ch'askiyta?","A. Papayta ruwakuy.","B. Takiyta.","C. Ñawirinkuykuna.");
                question5 = createQuestions("¿Imashina kay matematikakuna yanapakun kawsaypi?","A. Sapichaqkuna kunanapak ñawiykuna.","B. Chayllata ruwanaykuna tiyuykuna.","C. Kay globokunata ruwanaykuna llimp’ukunata p’unchaypi.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,2,1,3,3);
    }
    public static void setQuestions2(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las matemáticas?","A. Una forma de contar y medir cosas.","B. Un tipo de comida.","C. Un juego de cartas.");
                question2 = createQuestions("¿Cómo nos ayudan las matemáticas?","A. A dibujar animales.","B. A contar, medir, y entender el mundo que nos rodea.","C. A cocinar alimentos.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("¿Cuál es una forma simple de usar las matemáticas?","A. Dibujar en un papel.","B. Cantar una canción.","C. Contar nuestros dedos.");
                question5 = createQuestions("¿Cómo nos ayudan las matemáticas en la vida diaria?","A. A elegir el color de nuestros zapatos.","B. A decidir qué película ver.","C. A saber cuántos globos necesitamos para una fiesta.");
                break;
            case 1:
                question1 = createQuestions("¿Imapaq kay matematika?","A. Huk rikch'akuyta, ñawirinkuyta ruwanakuykuna.","B. Huk mikuy hina.","C. Huk q'ipinakuyta.");
                question2 = createQuestions("¿Imashina yanapakun matematikakuna?","A. Uywanata q'ipiyta","B. Rikch'akuyta, ñawirinkuyta, yachayta ñawirinkuyta qespiyta.","C. Mikuyta waykuyta.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("¿Iman chay rikch'akuy kay matematika ch'askiyta?","A. Papayta ruwakuy.","B. Takiyta.","C. Ñawirinkuykuna.");
                question5 = createQuestions("¿Imashina kay matematikakuna yanapakun kawsaypi?","A. Sapichaqkuna kunanapak ñawiykuna.","B. Chayllata ruwanaykuna tiyuykuna.","C. Kay globokunata ruwanaykuna llimp’ukunata p’unchaypi.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,2,1,3,3);
    }
    public static void setQuestions1(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las matemáticas?","A. Una forma de contar y medir cosas.","B. Un tipo de comida.","C. Un juego de cartas.");
                question2 = createQuestions("¿Cómo nos ayudan las matemáticas?","A. A dibujar animales.","B. A contar, medir, y entender el mundo que nos rodea.","C. A cocinar alimentos.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("¿Cuál es una forma simple de usar las matemáticas?","A. Dibujar en un papel.","B. Cantar una canción.","C. Contar nuestros dedos.");
                question5 = createQuestions("¿Cómo nos ayudan las matemáticas en la vida diaria?","A. A elegir el color de nuestros zapatos.","B. A decidir qué película ver.","C. A saber cuántos globos necesitamos para una fiesta.");
                break;
            case 1:
                question1 = createQuestions("¿Imapaq kay matematika?","A. Huk rikch'akuyta, ñawirinkuyta ruwanakuykuna.","B. Huk mikuy hina.","C. Huk q'ipinakuyta.");
                question2 = createQuestions("¿Imashina yanapakun matematikakuna?","A. Uywanata q'ipiyta","B. Rikch'akuyta, ñawirinkuyta, yachayta ñawirinkuyta qespiyta.","C. Mikuyta waykuyta.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("¿Iman chay rikch'akuy kay matematika ch'askiyta?","A. Papayta ruwakuy.","B. Takiyta.","C. Ñawirinkuykuna.");
                question5 = createQuestions("¿Imashina kay matematikakuna yanapakun kawsaypi?","A. Sapichaqkuna kunanapak ñawiykuna.","B. Chayllata ruwanaykuna tiyuykuna.","C. Kay globokunata ruwanaykuna llimp’ukunata p’unchaypi.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,2,1,3,3);
    }
}