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
                fillContents("Las operaciones combinadas son cuando tienes que hacer más de una operación matemática en el mismo problema.", "Las operaciones básicas son suma, resta, multiplicación y división, y las combinadas usan dos o más de estas operaciones al mismo tiempo.", "¡Las operaciones combinadas te ayudan a resolver problemas con más de una operación matemática! Practicar con ejemplos y usar el orden correcto te ayudará a entender mejor cómo resolver estos problemas.");
                break;
            case 1:
                fillContents("Operaciones combinadaskuna kanki, hukniykuna matemátikata ruwanchik hukniykuna imaykuna hukniykuna ruwananchik.", "Operaciones básicaskuna suma, resta, multiplicación, y divisiónkuna kankichik, combinadaskuna iskay o más imaykuna ruwananchik hukniykuna chaymi.", "¡Operaciones combinadaskuna ñawpaqmi allinmi problemas rikhuykuy hukniykuna matemátikata ruwanchik! Imaykunañam practikuy, yachaykuy chaymi allinmi rikhuy, khushuy.");
                break;
        }
    }
    private static void setTitle8(){
        switch (Theme.languages){
            case 0:
                fillTitles("¿Qué son las operaciones combinadas?", "¿Para que utilizamos la operación combinada", "¿Como funciona?");
                break;
            case 1:
                fillTitles("Imataq operaciones combinadaskuna?", "Imataq operaciones combinadakuna ruwananchik?", "Imanraq ruwan?");
                break;
        }
    }
    private static void setContent7(){
        switch (Theme.languages){
            case 0:
                fillContents("Las raíces son una manera de encontrar un número que, al multiplicarse por sí mismo un cierto número de veces, da otro número.", "Utilizamos para agrupar cosas en cuadrados, construcción y diseño, resolver problemas matematicos entre mas cosas", "¡Las raíces son útiles para encontrar medidas y resolver problemas cuando trabajamos con grupos y cuadrados! Practicar con ejemplos y ver cómo se aplican en la vida diaria puede hacer que las raíces sean más fáciles de entender y útiles.");
                break;
            case 1:
                fillContents("Raíceskuna hukninam kanki, hukniykuna hukniykuna chaymi imaykuna kachkanku, chaymi hukniykuna riqsichiy.", "Raíceskuna ruwananchik chaymi cuadradokuna, construcciónkuna, diseño, matemátikakunata rikhuy, allin imaykunañam ruwananchik.", "¡Raíceskuna allinmi rikhuykuy, medidas riqsichiy, problemas matemátikukunata rikhuy, hukniykuna cuadradokunata ruwananchik! Imaykunañam practikuy, yuyachiy chaymi yachaykuy, allinmi rikhuy, khushuy.");
                break;
        }
    }
    private static void setTitle7(){
        switch (Theme.languages){
            case 0:
                fillTitles("¿Qué son las raices?", "¿Para que utilizamos la raiz", "¿Como funciona?");
                break;
            case 1:
                fillTitles("Imataq raiceskuna?", "Imataq raícita ruwananchik?", "Imanraq ruwan?");
                break;
        }
    }
    private static void setContent6(){
        switch (Theme.languages){
            case 0:
                fillContents("Las potencias son una manera de multiplicar un número por sí mismo varias veces.", "Las potencias nos ayudan a hacer cálculos más rápidos y fáciles cuando necesitamos multiplicar el mismo número muchas veces.", "¡Las potencias te ayudan a hacer cálculos más rápidos y entender cosas más grandes! Practicar con ejemplos y ver cómo se aplican en la vida diaria puede hacer que las potencias sean más fáciles de entender y divertidas."  );
                break;
            case 1:
                fillContents("Potenciakuna hukniykuna hukniykuna chaymi ñawpaqmi hukniykuna riqsichiy.", "Potenciakuna ñawpaqmi allin chaymi ñawpaqmi cálculos más rápidos y fáciles ruwananchik, hukniykuna riqsichiykuykuna.", "¡Potenciakuna ñawpaqmi allin cálculos más rápidos ruwananchik, hukniykuna riqsichiykuykuna! Imaykunañam practikuy, yuyachiy chaymi sumak rikhuy, khushuy.");
                break;
        }
    }
    private static void setTitle6(){
        switch (Theme.languages){
            case 0:
                fillTitles("¿Qué son las potencias?", "¿Para que utilizamos las potencias", "¿Como funciona?");
                break;
            case 1:
                fillTitles("Imataq potenciakuna?", "Imataq potenciakuna ruwananchik?", "Imanraq ruwan?");
                break;
        }
    }
    private static void setContent5(){
        switch (Theme.languages){
            case 0:
                fillContents("La división es una operación matemática que usamos para repartir algo en partes iguales.", "Es como compartir un grupo de cosas entre varias personas para que cada una reciba la misma cantidad.", "¡La división es una forma de repartir cosas en partes iguales! Practicar con objetos y ver cómo se agrupan puede ayudarte a entender cómo funciona de manera más clara y divertida." );
                break;
            case 1:
                fillContents("Divisionqa matemátikata rimaykuymi kanki, huk imaykuna partes igualespi rikhuykuy.", "Chaymi hukniykuna imaykuna, hichaypi runakunata, rikhuykuy, hinam tukuy kankuyki chaymi, hukniykuna kanki.", "¡Divisionqa hukninam imaykuna partes igualespi rikhuykuy! Imaykunañam practikuy, yachaykuy chaymi chaykunata rikhuykuy, allinmi yuyaykuyta yachaykuy, khushuy.");
                break;
        }
    }
    private static void setTitle5(){
        switch (Theme.languages){
            case 0:
                fillTitles("¿Qué son las divisiones?", "¿Para que utilizamos la division", "¿Como funciona?");
                break;
            case 1:
                fillTitles("Imataq divisionkuna?", "Imataq divisionta ruwananchik?", "Imanraq ruwan?");
                break;
        }
    }
    private static void setContent4(){
        switch (Theme.languages){
            case 0:
                fillContents("La multiplicación es una operación matemática que usamos para encontrar el total cuando agrupamos varias veces el mismo número. Es como sumar el mismo número muchas veces.", "Utilizamos la multiplicación para hacer compras, organizar eventos, jugar juegos entre más cosas", "¡La multiplicación es una forma de sumar el mismo número muchas veces! Puedes practicar con objetos, usar una línea de números y recordar que el orden no importa para hacer la multiplicación más fácil y divertida.");
                break;
            case 1:
                fillContents("Multiplicaciónqa matemátikata rimaykuymi kanki, imaykunata hatunchayta riqsichiy, hukniykuna hukniykuna chaymi. Ñawpaqmi hukniykuna llapa rikchiy.", "Multiplicaciónta ruwananchik, winaqta usuchiy, eventokunata rikhuy, juegoskunata puriy hina, allin imaykunañam ruwananchik.", "¡Multiplicaciónqa hukninam chaymi hukniykuna llapa riqsichiy! Ñawpaqmi imaykunañam practikuy, números línata usuchiy, yuyachiy chaymi ñawpaqmi rimaykuyta allinmi, khushuy!");
                break;
        }
    }
    private static void setTitle4(){
        switch (Theme.languages){
            case 0:
                fillTitles("¿Qué son las multiplicaciones?", "¿Para que utilizamos la multiplicación", "¿Como funciona?");
                break;
            case 1:
                fillTitles("Imataq multiplicaciónkuna?", "Imataq multiplicaciónta ruwananchik?", "Imanraq ruwan?");
                break;
        }
    }
    private static void setContent3(){
        switch (Theme.languages){
            case 0:
                fillContents("La resta es como sacar o quitar para ver lo que queda.", "La resta es una herramienta que nos ayuda a saber cuántas cosas quedan cuando quitamos algunas. Usamos la resta en muchas situaciones de nuestra vida diaria.", "La resta es una forma de averiguar cuántas cosas te quedan después de quitar algunas de un grupo. Es como “sacar” cosas y ver lo que queda.");
                break;
            case 1:
                fillContents("Rimaykuyka rikhuy, hukniykuymi, chaykunata riqsichiy, imaykunañam chaymi.", "Rimaykuyqa, ñawpaqmi imaykunañam chaypi chaykunata riqsichiy, hukniykuy kanki. Rimaykuyta usuchiykuykuchkanchik ñawi killkanku yachaykuykunamanta.", "Rimaykuyqa hukninam kanki, imaykunañam chaypi hukninta riqsichiy, chaykunata rikhuy. Ñawpaqmi 'hukniykuy' hinata, chaymi imaykunañam rikhuy.");
                break;
        }
    }
    private static void setTitle3(){
        switch (Theme.languages){
            case 0:
                fillTitles("¿Que son las restas?", "¿Para que utilizamos las restas?", "¿Como funciona?");
                break;
            case 1:
                fillTitles("Imataq rimaykuykuna?", "Imataq rimaykuykuna ruwananchik?", "Imanraq ruwan?");
                break;
        }
    }
    private static void setContent2(){
        switch (Theme.languages){
            case 0:
                fillContents("La suma es una operación matemática que usamos para juntar o añadir cosas y saber cuántas hay en total.", "Cuando tienes varios grupos de cosas y quieres saber cuántas hay en total, usas la suma.", "La suma es una manera de juntar cosas para saber cuántas hay en total. Es como contar todo lo que tienes cuando unes grupos de cosas.");
                break;
            case 1:
                fillContents("Suma kaq matemátikata tarpuq qapariyniyoqmi runasimipi kasqa hukninta hukkuywan waqaychasqa hinallataq chhaynapi imayqallaq hinataq chaypi hatunchay mana willayqallaña.", "Kunaypaq hukninta hukkuywan imayqallaq hinataq chhaypi hatunchay mana willayqallañaqa, sumata wiñayniyuq.", "Sumaqa ñawpaqmi hatuniy imayqallaq hina hinamanta chaypi imayqallaq hinataq chaypi hatunchay mana willayqallaña. Manaraq kayllamanta sutiy kay imayqallañaq nin yuyachikuychikmi imayqallaña hinataq hukninta hukkuywan chaypi.");
                break;
        }
    }
    private static void setTitle2(){
        switch (Theme.languages){
            case 0:
                fillTitles("¿Que son las sumas?", "¿Para que utilizamos las sumas?", "¿Como funciona?");
                break;
            case 1:
                fillTitles("Imataq sumakunapaq?", "Imataq sumakunata ruwananchik?", "Imanraq sumakunata ruwananchik?");
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
