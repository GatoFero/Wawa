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
                question1 = createQuestions("¿Qué es (10 + 2) ÷ 4?","A. 2.","B. 3.","C. 4.");
                question2 = createQuestions("¿Cuánto es 6 × 2 + 4?","A. 16.","B. 18.","C. 20.");
                question3 = createQuestions("¿Qué es 15 ÷ (5 - 2)?","A. 5.","B. 7.","C. 10.");
                question4 = createQuestions("¿Cuánto es (8 - 3) × 2?","A. 10.","B. 12.","C. 14.");
                question5 = createQuestions("¿Qué es 9 + 4 ÷ 2?","A. 7.","B. 10.","C. 11.");
            case 1:
                question1 = createQuestions("Imata (10 + 2) ÷ 4?","A. 2.","B. 3.","C. 4.");
                question2 = createQuestions("Imata 6 × 2 + 4?","A. 16.","B. 18.","C. 20.");
                question3 = createQuestions("Imata 15 ÷ (5 - 2)?","A. 5.","B. 7.","C. 10.");
                question4 = createQuestions("Imata (8 - 3) × 2?","A. 10.","B. 12.","C. 14.");
                question5 = createQuestions("Imata 9 + 4 ÷ 2?","A. 7.","B. 10.","C. 11.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(2,1,1,1,3);
    }
    public static void setQuestions7(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Cual es la raíz cuadrada de 9?","A. 2.","B. 3.","C. 4.");
                question2 = createQuestions("¿Cuánto es la raíz cuadrada de 16?","A. 4.","B. 5.","C. 6.");
                question3 = createQuestions("¿Cual es la raíz cuadrada de 25?","A. 4.","B. 5.","C. 6.");
                question4 = createQuestions("¿Cuánto es la raíz cuadrada de 36?","A. 5.","B. 6.","C. 7.");
                question5 = createQuestions("¿Cual es la raíz cuadrada de 49?","A. 6.","B. 7.","C. 8.");
                break;
            case 1:
                question1 = createQuestions("Imata 9 ñawi t'aqlla??","A. 2.","B. 3.","C. 4.");
                question2 = createQuestions("Imata 16 ñawi t'aqlla?","A. 4.","B. 5.","C. 6.");
                question3 = createQuestions("Imata 25 ñawi t'aqlla?","A. 4.","B. 5.","C. 6.");
                question4 = createQuestions("Imata 36 ñawi t'aqlla?","A. 5.","B. 6.","C. 7.");
                question5 = createQuestions("Imata 49 ñawi t'aqlla?","A. 6.","B. 7.","C. 8.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(2,1,2,2,2);
    }
    public static void setQuestions6(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Cuanto es 2^3?","A.  6.","B. 8.","C. 10.");
                question2 = createQuestions("¿Cuanto es 3^2?","A.  6.","B. 9.","C. 12.");
                question3 = createQuestions("¿Cuanto es 4^2?","A.  8.","B. 12.","C. 16.");
                question4 = createQuestions("¿Cuanto es 5^2?","A.  20.","B. 25.","C. 30.");
                question5 = createQuestions("¿Cuanto es 2^4?","A.  12.","B. 16.","C. 20.");
                break;
            case 1:
                question1 = createQuestions("Imata 2^3?","A.  6.","B. 8.","C. 10.");
                question2 = createQuestions("Imata 3^2?","A.  6.","B. 9.","C. 12.");
                question3 = createQuestions("Imata 4^2?","A.  8.","B. 12.","C. 16.");
                question4 = createQuestions("Imata 5^2?","A.  20.","B. 25.","C. 30.");
                question5 = createQuestions("Imata 2^4?","A.  12.","B. 16.","C. 20.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(2,2,3,2,2);
    }
    public static void setQuestions5(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Cuánto es 12 ÷ 4?","A. 2.","B. 3.","C. 4.");
                question2 = createQuestions("¿Cuanto es 20 ÷ 5?","A. 3.","B. 4.","C. 5.");
                question3 = createQuestions("¿Cuanto es 30 ÷ 6?","A. 4.","B. 5.","C. 6.");
                question4 = createQuestions("Si tienes 16 manzanas y las divides en 4 bolsas, ¿cuántas manzanas hay en cada bolsa?","A. 2.","B. 3.","C. 4.");
                question5 = createQuestions("¿Cuánto es 25 ÷ 5?", "A. 4.","B. 5.","C. 6.");
                break;
            case 1:
                question1 = createQuestions("Imata 12 ÷ 4?","A. 2.","B. 3.","C. 4.");
                question2 = createQuestions("Imata 20 ÷ 5?","A. 3.","B. 4.","C. 5.");
                question3 = createQuestions("Imata 30 ÷ 6?","A. 4.","B. 5.","C. 6.");
                question4 = createQuestions("Ñuqanchikta 16 manzanas kanki, 4 sakuypa riqsichiy, imatapas manzanas kanki sakuypi?","A. 2.","B. 3.","C. 4.");
                question5 = createQuestions("Imata 25 ÷ 5?", "A. 4.","B. 5.","C. 6.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(2,2,2,3,2);
    }
    public static void setQuestions4(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Cuánto es 3 × 4?","A. 7.","B. 12.","C. 15.");
                question2 = createQuestions("¿Cuánto es 6 × 3?","A. 18.","B. 20.","C. 21.");
                question3 = createQuestions("¿Cuánto es 7 × 2?","A. 12.","B. 14.","C. 16.");
                question4 = createQuestions("Si tienes 2 grupos de 8 juguetes cada uno, ¿cuántos juguetes tienes en total?","A. 12.","B. 14.","C. 16.");
                question5 = createQuestions("Si tienes 3 cajas con 6 galletas cada una, ¿cuántas galletas tienes en total?","18.","B. 20.","C. 24.");
                break;
            case 1:
                question1 = createQuestions("Imata 3 × 4?","A. 7.","B. 12.","C. 15.");
                question2 = createQuestions("Imata 6 × 3?","A. 18.","B. 20.","C. 21.");
                question3 = createQuestions("Imata 7 × 2?","A. 12.","B. 14.","C. 16.");
                question4 = createQuestions("Ñuqanchikta 2 grupo 8 juguetekuna kanki, imatapas juguetekuna kanki?","A. 12.","B. 14.","C. 16.");
                question5 = createQuestions("Ñuqanchikta 3 caja 6 galletakuna kanki, imatapas galletakuna kanki?", "18.","B. 20.","C. 24.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(2,1,2,3,1);
    }
    public static void setQuestions3(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Cuánto es 9 - 4?","A. 5.","B. 6.","C. 7.");
                question2 = createQuestions("Si tienes 10 manzanas y comes 3, ¿cuántas manzanas te quedan?","A. 7.","B. 22.","C. 16.");
                question3 = createQuestions("¿Cuanto es 15 - 8?","A. 6.","B. 7.","C. 9.");
                question4 = createQuestions("Tienes 14 lápices y pierdes 6. ¿Cuántos lápices tienes ahora?","A. 7.","B. 9.","C. 8.");
                question5 = createQuestions("¿Cuanto es 5 - 4 ?","A. 5.","B. 11.","C. 1.");
                break;
            case 1:
                question1 = createQuestions("Imata 9 - 4?", "A. 5.","B. 6.","C. 7.");
                question2 = createQuestions("Ñuqanchikta 10 manzanas kanki, 3ñam mikuykuy, imatapas manzanas kanki?", "A. 7.","B. 22.","C. 16.");
                question3 = createQuestions("Imata 15 - 8?", "A. 6.","B. 7.","C. 9.");
                question4 = createQuestions("Ñuqanchikta 14 lápiz kanki, 6ñam ñawpa. Imatapas lápiz kanki?", "A. 7.","B. 9.","C. 8.");
                question5 = createQuestions("Imata 5 - 4?", "A. 5.","B. 11.","C. 1.");
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(1,1,2,3,3);
    }
    public static void setQuestions2(){
        ArrayList<String> question1 = new ArrayList<>();
        ArrayList<String> question2 = new ArrayList<>();
        ArrayList<String> question3 = new ArrayList<>();
        ArrayList<String> question4 = new ArrayList<>();
        ArrayList<String> question5 = new ArrayList<>();
        switch (Theme.languages){
            case 0:
                question1 = createQuestions("¿Qué son las sumas?","A. Un caballo mutante.","B. Un tipo de comida.","C. Una forma de unir grupos de cosas.");
                question2 = createQuestions("¿Cuánto es 5 + 3?","A. 7.","B. 12.","C. 8.");
                question3 = createQuestions("¿Qué es sumar?","A. Juntar cosas.","B. Quitar cosas.","C. Dividir cosas.");
                question4 = createQuestions("Si tienes 8 galletas y comes 4, ¿y luego encuentras 6 galletas más, cuántas galletas tienes ahora?","A. 8.","B. 10.","C. 12.");
                question5 = createQuestions("¿Qué es 11 + 7?","A. 17.","B. 18.","C. 19.");
                break;
            case 1:
                question1 = createQuestions("¿Imataq sumakuna?", "A. Huk mutante caballokuna.","B. Huk tipo de comida.","C. Hukninam rimanakuykuna imaykuna juntay.");
                question2 = createQuestions("¿Imata 5 + 3?","A. 7.","B. 12.","C. 8.");
                question3 = createQuestions("¿Imaynata kay huñukuy?","A. Ruwanakuyta.","B. Q'ipinakunata.","C. Ch'askiyta.");
                question4 = createQuestions("Ñuqanchikta 8 galletakuna kanki, 4ñam mikuykuy, chaymanta 6 galletakuna ñawpaqta riqsichiy, imatapas galletakuna kanki?", "A. 8.","B. 10.","C. 12.");
                question5 = createQuestions("Imata 11 + 7?", "A. 17.","B. 18.","C. 19." );
                break;
        }
        setQuestions(question1,question2,question3,question4,question5);
        setResponses(3,3,1,3,2);
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