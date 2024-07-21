package com.example.wawa.modelo.temas;


import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class Page {

    protected static ArrayList<String> title = new ArrayList<>();
    protected static ArrayList<String> content = new ArrayList<>();
    protected Theme theme;
    protected static int totalPages;
    protected int countPage = 0;

    public Page() {
    }

    public void renderPage(int nextOrBack){
        countPage += nextOrBack;
        System.out.println(countPage);
        renderSectionPage(theme.getTitleView(),title.get(countPage));
        renderSectionPage(theme.getContentView(),content.get(countPage));
    }
    public void renderSectionPage(TextView view, String content){
        theme.setTextView(view,content);
    }

    public int getTotalPages() {
        return totalPages;
    }
    public int getCountPage() {
        return countPage;
    }
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public static void setTitlesSelects(){
        title.clear();
        content.clear();
        switch (ThemeName.themeSelect){
           case 0:
               setTheme1();
               setContent1();
               break;
           case 1:
               break;
        }
        totalPages = content.size();
    }
    private static void fillContents(String... contents){
        content.addAll(Arrays.asList(contents));
    }
    private static void fillTitles(String... titles){
        title.addAll(Arrays.asList(titles));
    }

    private static void setContent8(){
        switch (Theme.languages){
            case 0:
                fillContents("");
                break;
            case 1:
                fillContents("fef");
                break;
        }
    }
    private static void setTitle8(){
        switch (Theme.languages){
            case 0:
                fillTitles("");
                break;
            case 1:
                fillTitles("ef");
                break;
        }
    }
    private static void setContent7(){
        switch (Theme.languages){
            case 0:
                fillContents("");
                break;
            case 1:
                fillContents("fef");
                break;
        }
    }
    private static void setTitle7(){
        switch (Theme.languages){
            case 0:
                fillTitles("");
                break;
            case 1:
                fillTitles("ef");
                break;
        }
    }
    private static void setContent6(){
        switch (Theme.languages){
            case 0:
                fillContents("");
                break;
            case 1:
                fillContents("fef");
                break;
        }
    }
    private static void setTitle6(){
        switch (Theme.languages){
            case 0:
                fillTitles("");
                break;
            case 1:
                fillTitles("ef");
                break;
        }
    }
    private static void setContent5(){
        switch (Theme.languages){
            case 0:
                fillContents("");
                break;
            case 1:
                fillContents("fef");
                break;
        }
    }
    private static void setTitle5(){
        switch (Theme.languages){
            case 0:
                fillTitles("");
                break;
            case 1:
                fillTitles("ef");
                break;
        }
    }
    private static void setContent4(){
        switch (Theme.languages){
            case 0:
                fillContents("");
                break;
            case 1:
                fillContents("fef");
                break;
        }
    }
    private static void setTitle4(){
        switch (Theme.languages){
            case 0:
                fillTitles("");
                break;
            case 1:
                fillTitles("ef");
                break;
        }
    }
    private static void setContent3(){
        switch (Theme.languages){
            case 0:
                fillContents("");
                break;
            case 1:
                fillContents("fef");
                break;
        }
    }
    private static void setTitle3(){
        switch (Theme.languages){
            case 0:
                fillTitles("");
                break;
            case 1:
                fillTitles("ef");
                break;
        }
    }
    private static void setContent2(){
        switch (Theme.languages){
            case 0:
                fillContents("");
                break;
            case 1:
                fillContents("fef");
                break;
        }
    }
    private static void setTitle2(){
        switch (Theme.languages){
            case 0:
                fillTitles("");
                break;
            case 1:
                fillTitles("ef");
                break;
        }
    }
    private static void setContent1(){
        if(Theme.languages == 0){
            content.add("¡Hola, chicos! Hoy vamos a hablar de algo muy divertido y útil: ¡las matemáticas!\n" +
                    "\n" + "Las matemáticas son como un gran juego de números y formas. Nos ayudan a contar, medir, y entender el mundo que nos rodea. Por ejemplo, cuando contamos nuestros juguetes, estamos usando matemáticas. Cuando dividimos una pizza en partes iguales para compartir con nuestros amigos, ¡también estamos usando matemáticas!");
            content.add("Contar es la forma más simple de usar las matemáticas. Podemos contar nuestros dedos, los lápices en nuestra mochila, o los escalones al subir las escaleras. Contar nos ayuda a saber cuántos hay de algo.\n" +
                    "\n" + "Sumar es juntar cosas. Por ejemplo, si tienes 2 manzanas y te dan 3 más, ahora tienes 5 manzanas en total. Restar es quitar cosas. Si tienes 5 caramelos y te comes 2, te quedan 3 caramelos.");
            content.add("Las matemáticas también nos ayudan a conocer las formas y tamaños. Podemos ver formas como círculos, cuadrados, y triángulos a nuestro alrededor. También medimos cosas para saber qué tan largas, altas o pesadas son.\n" + "\n" +
                    "Usamos las matemáticas para resolver problemas. Por ejemplo, si quieres saber cuántos globos necesitas para una fiesta o cuántos días faltan para tu cumpleaños, las matemáticas te pueden ayudar.");
        }else if(Theme.languages == 1){
            content.add("Allinllachu, wawqikuna! Kaynaqa, sumaqpas, útilpas kasqanta rimanakusun: ¡matematika!\n" +
                    "\n" + "Matematikaqa, huk jatun pukllay kashan llimp’ukunapas uqllachasqa k’ancharinakapas. Ñuqanchikwan yanapanakuranchik llimp’ukunata, mesadota, yachachikuykuna, yachayniyoq llaqtanchikpa kayta. Ñawpaqtaqa, ñuqanchik llimp’ukunata rikch’akunanchik, matematikawan puriyanchik. Chayqa, ima chhaynalla ñawpaqtaqa, ñuqanchik paqarinchaqa aylluymanta wasinchikkunapimanta, yanapanakunanchikpaq, matematikawan pasachkanchik!");
            content.add("Rikch’akuyqa, imapaswan asichakuyqa. Ñuqanchikwan rikch’akunanchik ñawi-p’ankukunata, uchukhachanakuna aylluykuna wasinchikpi, icha sayaykuna riykuna wasinchikpi. Rikch’akuywan yachachkanchik imatak ña astawanpas kasqan.\n" +
                    "\n" + "Huñukuyqa, imapaswan thanta. Ña 2 manzanaqa kapun, icha kachkan 3 manzanaña yanapaykuywan, kachkan 5 manzanaña. Ch’usaykuyqa, imapaswan q’ipinakuypa. Ña 5 karamelluta kapun, icha mikhuypi 2, kachkan 3 karamelluña.");
            content.add("Matematikaqa, yanapanakurkan imachus k’ancharinakuna, sayaykuna. Ña rikch’achkanchik k’ancharinakuna, q’iruchanakuna, tusuchanakuna, k’imayllanakuna ñawpa wawqikuna wasinchikpi. Chaynallataraq yachachkanchik ima kastatapas imatakpis ima rikch’achinayan, imatak mana ch’usaykachikunan. Ñuqanchikwan matematika, yanapanakurkan rimanakuy ruwakuywan. Ña ima, wawqiyki, yachachkanchik imatakchus, ñawpaqtaqa wakin k’ancharinakuna, icha paqarincha wasinchikpi, yachachkanchik, matematikawan yanapanakurkan.");
        }
    }
    private static void setTheme1(){
        if(Theme.languages == 0){
            title.add("¿Qué son las Matemáticas?");
            title.add("Contar, Sumar y Restar");
            title.add("Usos del día a día");
        }else if(Theme.languages == 1){
            title.add("¿Imapaq Kay Matematika?");
            title.add("Rikch’akuy, Huñukuywan Ch’usaykuy");
            title.add("Pachakuna Purikuywan");
        }
    }
}
