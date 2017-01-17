package ascensor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import javax.speech.EngineStateError;
import javax.swing.Timer;

import javazoom.jl.decoder.JavaLayerException;
import mp3.MP3_Sonidos;
import mp3.MP3_Música;
import visual.Visual_Main;
public class Ascensor {

    //Creamos los vectores para el algoritmo colectivo
    public static ArrayList<Integer> vecDsc = new ArrayList<Integer>();
    public static ArrayList<Integer> vecAsc = new ArrayList<Integer>();

    //Creo dos objetos para reproducir MP3, uno para la música y el otro para los distintos sonidos o efectos.
    private static MP3_Sonidos sonidos;
    private static MP3_Música musica;

    //Variables para manipular los pisos del ascensor
    private static int PisoDestino=0; 			// Guarda el piso de destino indicado
    public static int PisoActual=0; 		    // Guarda el piso actual
    private static Timer timer, timer2;
    private static boolean vacio;
    public static String estado="standby";		//Define el estado del ascensor. standby(Detenido),subiendo o bajando.
    public static boolean puertascerradas=false;


    /*
    A continuación vienen las funciones que son invocadas por el reconocedor de voz cuando se encuentra alguna coincidencia de lo
    dicho con el diccionario creado. Estas funciones son "pisosEspeciales" y "PisosNormales".
    Cuando el reconocedor recibe una orden, puede invocar:

    pisosEspeciales : Si se pide ir a plantabaja|lobby|terraza|azotea|subsuelo (Pisos especiales)
    pisosNormales: Si se pide ir a un piso normal, como piso 5, o piso 48.

    En ambos verán una serie de condicionales. En el que haya una coincidencia, se guarda el resultado en la
    variable PisoDestino(entero).
    Esto se hace para pasar de la palabra hablada, al número correspondiente.
    */

    public static void indicarPisosNormales(String coord1,String coord2) throws FileNotFoundException, JavaLayerException, InterruptedException{
        if (coord1.equals("uno") || coord1.equals("1")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso1.setBackground(Color.white);}
            else{
            PisoDestino=1;
            Visual_Main.ppiso1.setBackground(Color.red);
            }
        }
        else if (coord1.equals("dos")|| coord1.equals("2"))  {
            if (coord2.equals("si")){
                Visual_Main.ppiso2.setBackground(Color.white);}
            else{
            PisoDestino=2;
            Visual_Main.ppiso2.setBackground(Color.red);
            }
        }
        else if (coord1.equals("tres")|| coord1.equals("3")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso3.setBackground(Color.white);}
            else{
            PisoDestino=3;
            Visual_Main.ppiso3.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuatro")|| coord1.equals("4")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso4.setBackground(Color.white);}
            else{
            PisoDestino=4;
            Visual_Main.ppiso4.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cinco")|| coord1.equals("5")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso5.setBackground(Color.white);}
            else{
            PisoDestino=5;
            Visual_Main.ppiso5.setBackground(Color.red);
            }
        }
        else if (coord1.equals("seis")|| coord1.equals("6")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso6.setBackground(Color.white);}
            else{
            PisoDestino=6;
            Visual_Main.ppiso6.setBackground(Color.red);
            }
        }
        else if (coord1.equals("siete")|| coord1.equals("7")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso7.setBackground(Color.white);}
            else{
            PisoDestino=7;
            Visual_Main.ppiso7.setBackground(Color.red);
            }
        }
        else if (coord1.equals("ocho")|| coord1.equals("8")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso8.setBackground(Color.white);}
            else{
            PisoDestino=8;
            Visual_Main.ppiso8.setBackground(Color.red);
            }
        }
        else if (coord1.equals("nueve")|| coord1.equals("9")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso9.setBackground(Color.white);}
            else{
            PisoDestino=9;
            Visual_Main.ppiso9.setBackground(Color.red);
            }
        }
        else if (coord1.equals("diez")|| coord1.equals("10")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso10.setBackground(Color.white);}
            else{
            PisoDestino=10;
            Visual_Main.ppiso10.setBackground(Color.red);
            }
        }
        else if (coord1.equals("once")|| coord1.equals("11")) {
        	System.out.println("asdasd");
            if (coord2.equals("si")){
                Visual_Main.ppiso11.setBackground(Color.white);}
            else{
            PisoDestino=11;
            Visual_Main.ppiso11.setBackground(Color.red);
            }
        }
        else if (coord1.equals("doce")|| coord1.equals("12")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso12.setBackground(Color.white);}
            else{
            PisoDestino=12;
            Visual_Main.ppiso12.setBackground(Color.red);
            }
        }
        else if (coord1.equals("trece")|| coord1.equals("13")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso13.setBackground(Color.white);}
            else{
            PisoDestino=13;
            Visual_Main.ppiso13.setBackground(Color.red);
            }
        }
        else if (coord1.equals("catorce")|| coord1.equals("14")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso14.setBackground(Color.white);}
            else{
            PisoDestino=14;
            Visual_Main.ppiso14.setBackground(Color.red);
            }
        }
        else if (coord1.equals("quince")|| coord1.equals("15")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso15.setBackground(Color.white);}
            else{
            PisoDestino=15;
            Visual_Main.ppiso15.setBackground(Color.red);
            }
        }
        else if (coord1.equals("diezyseis")|| coord1.equals("16")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso16.setBackground(Color.white);}
            else{
            PisoDestino=16;
            Visual_Main.ppiso16.setBackground(Color.red);
            }
        }
        else if (coord1.equals("diezysiete")|| coord1.equals("17")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso17.setBackground(Color.white);}
            else{
            PisoDestino=17;
            Visual_Main.ppiso17.setBackground(Color.red);
            }
        }
        else if (coord1.equals("diezyocho")|| coord1.equals("18")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso18.setBackground(Color.white);}
            else{
            PisoDestino=18;
            Visual_Main.ppiso18.setBackground(Color.red);
            }
        }
        else if (coord1.equals("diezynueve")|| coord1.equals("19")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso19.setBackground(Color.white);}
            else{
            PisoDestino=19;
            Visual_Main.ppiso19.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veinte")|| coord1.equals("20")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso20.setBackground(Color.white);}
            else{
            PisoDestino=20;
            Visual_Main.ppiso20.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veintiuno")|| coord1.equals("21")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso21.setBackground(Color.white);}
            else{
            PisoDestino=21;
            Visual_Main.ppiso21.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veintidos")|| coord1.equals("22")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso22.setBackground(Color.white);}
            else{
            PisoDestino=22;
            Visual_Main.ppiso22.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veintitres")|| coord1.equals("21")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso21.setBackground(Color.white);}
            else{
            PisoDestino=21;
            Visual_Main.ppiso21.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veinticuatro")|| coord1.equals("24")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso24.setBackground(Color.white);}
            else{
            PisoDestino=24;
            Visual_Main.ppiso24.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veinticinco")|| coord1.equals("25")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso25.setBackground(Color.white);}
            else{
            PisoDestino=25;
            Visual_Main.ppiso25.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veintiseis")|| coord1.equals("26")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso26.setBackground(Color.white);}
            else{
            PisoDestino=26;
            Visual_Main.ppiso26.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veintisiete")|| coord1.equals("27")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso27.setBackground(Color.white);}
            else{
            PisoDestino=27;
            Visual_Main.ppiso27.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veintiocho")|| coord1.equals("28")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso28.setBackground(Color.white);}
            else{
            PisoDestino=28;
            Visual_Main.ppiso28.setBackground(Color.red);
            }
        }
        else if (coord1.equals("veintinueve")|| coord1.equals("29")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso29.setBackground(Color.white);}
            else{
            PisoDestino=29;
            Visual_Main.ppiso29.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treinta")|| coord1.equals("30")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso30.setBackground(Color.white);}
            else{
            PisoDestino=30;
            Visual_Main.ppiso30.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintayuno")|| coord1.equals("31")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso31.setBackground(Color.white);}
            else{
            PisoDestino=31;
            Visual_Main.ppiso31.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintaydos")|| coord1.equals("32")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso32.setBackground(Color.white);}
            else{
            PisoDestino=32;
            Visual_Main.ppiso32.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintaytres")|| coord1.equals("33")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso33.setBackground(Color.white);}
            else{
            PisoDestino=33;
            Visual_Main.ppiso33.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintaycuatro")|| coord1.equals("34")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso34.setBackground(Color.white);}
            else{
            PisoDestino=34;
            Visual_Main.ppiso34.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintaycinco")|| coord1.equals("35")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso35.setBackground(Color.white);}
            else{
            PisoDestino=35;
            Visual_Main.ppiso35.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintaycinco")|| coord1.equals("36")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso36.setBackground(Color.white);}
            else{
            PisoDestino=36;
            Visual_Main.ppiso36.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintaysiete")|| coord1.equals("37")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso37.setBackground(Color.white);}
            else{
            PisoDestino=37;
            Visual_Main.ppiso37.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintayocho")|| coord1.equals("38")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso38.setBackground(Color.white);}
            else{
            PisoDestino=38;
            Visual_Main.ppiso38.setBackground(Color.red);
            }
        }
        else if (coord1.equals("treintaynueve")|| coord1.equals("39")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso39.setBackground(Color.white);}
            else{
            PisoDestino=39;
            Visual_Main.ppiso39.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarenta")|| coord1.equals("40")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso40.setBackground(Color.white);}
            else{
            PisoDestino=40;
            Visual_Main.ppiso40.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentayuno")|| coord1.equals("41")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso41.setBackground(Color.white);}
            else{
            PisoDestino=41;
            Visual_Main.ppiso41.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentaydos")|| coord1.equals("42")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso42.setBackground(Color.white);}
            else{
            PisoDestino=42;
            Visual_Main.ppiso42.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentaytres")|| coord1.equals("43")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso43.setBackground(Color.white);}
            else{
            PisoDestino=43;
            Visual_Main.ppiso43.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentaycuatro")|| coord1.equals("44")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso44.setBackground(Color.white);}
            else{
            PisoDestino=44;
            Visual_Main.ppiso44.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentaycinco")|| coord1.equals("45")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso45.setBackground(Color.white);}
            else{
            PisoDestino=45;
            Visual_Main.ppiso45.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentayseis")|| coord1.equals("46")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso46.setBackground(Color.white);}
            else{
            PisoDestino=46;
            Visual_Main.ppiso46.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentaysiete")|| coord1.equals("47")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso47.setBackground(Color.white);}
            else{
            PisoDestino=47;
            Visual_Main.ppiso47.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentayocho")|| coord1.equals("48")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso48.setBackground(Color.white);}
            else{
            PisoDestino=48;
            Visual_Main.ppiso48.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cuarentaynueve")|| coord1.equals("49")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso49.setBackground(Color.white);}
            else{
            PisoDestino=49;
            Visual_Main.ppiso49.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuenta")|| coord1.equals("50")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso50.setBackground(Color.white);}
            else{
            PisoDestino=50;
            Visual_Main.ppiso50.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentayuno")|| coord1.equals("51")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso51.setBackground(Color.white);}
            else{
            PisoDestino=51;
            Visual_Main.ppiso51.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentaydos")|| coord1.equals("52")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso52.setBackground(Color.white);}
            else{
            PisoDestino=52;
            Visual_Main.ppiso52.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentaytres")|| coord1.equals("53")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso53.setBackground(Color.white);}
            else{
            PisoDestino=53;
            Visual_Main.ppiso53.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentaycuatro")|| coord1.equals("54")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso54.setBackground(Color.white);}
            else{
            PisoDestino=54;
            Visual_Main.ppiso54.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentaycinco")|| coord1.equals("55")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso55.setBackground(Color.white);}
            else{
            PisoDestino=55;
            Visual_Main.ppiso55.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentayseis")|| coord1.equals("56")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso56.setBackground(Color.white);}
            else{
            PisoDestino=56;
            Visual_Main.ppiso56.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentaysiete")|| coord1.equals("57")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso57.setBackground(Color.white);}
            else{
            PisoDestino=57;
            Visual_Main.ppiso57.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentayocho")|| coord1.equals("58")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso58.setBackground(Color.white);}
            else{
            PisoDestino=58;
            Visual_Main.ppiso58.setBackground(Color.red);
            }
        }
        else if (coord1.equals("cincuentaynueve")|| coord1.equals("59")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso59.setBackground(Color.white);}
            else{
            PisoDestino=59;
            Visual_Main.ppiso59.setBackground(Color.red);
            }
        }
        else if (coord1.equals("sesenta")|| coord1.equals("60")) {
            if (coord2.equals("si")){
                Visual_Main.ppiso60.setBackground(Color.white);}
            else{
            PisoDestino=60;
            Visual_Main.ppiso60.setBackground(Color.red);
            }
        }

        if (coord2!="si"){
            if( vecAsc.get(0)!=300 || vecDsc.get(0)!=-300 || vacio==true){
                vacio=false;
                maniobraColectivo();

            }
            else{
                vacio=true;
                moverAscensor(); //Llamamos a la función que moverá el ascensor
            }}

    }


    public static void indicarPisosEspeciales(String coord1,String coord2) throws FileNotFoundException, JavaLayerException, InterruptedException{
            if (coord1.equals("plantabaja") || coord1.equals("lobi") || coord1.equals("0")){
                if (coord2.equals("si")){
                    Visual_Main.ppiso0.setBackground(Color.white);}
                else{
                PisoDestino=0;
                Visual_Main.ppiso0.setBackground(Color.red);
                }
            }
            else if (coord1.equals("terraza") || coord1.equals("asotea") || coord1.equals("61"))  {
                if (coord2.equals("si")){
                    Visual_Main.ppiso61.setBackground(Color.white);}
                else{
                PisoDestino=61;
                Visual_Main.ppiso61.setBackground(Color.red);
                }
            }

        else if( !coord2.equals("vacio")){
            if (coord2.equals("subsuelo")|| coord2.equals("si")){
                System.out.println("coord 2: "  + coord2);
                System.out.println("coord 1 : "  + coord1);
                if (coord1.equals("primer") || coord1.equals("-1")){
                    if (coord2.equals("si")){
                        Visual_Main.ppiso62.setBackground(Color.white);}
                    else{
                    PisoDestino=-1;
                    Visual_Main.ppiso62.setBackground(Color.red);
                    }
                }

                if (coord1.equals("segundo") || coord1.equals("-2")){
                    System.out.println("Ascensonr pls");
                    if (coord2.equals("si")){
                        Visual_Main.ppiso63.setBackground(Color.white);}
                    else{
                    PisoDestino=-2;
                    Visual_Main.ppiso63.setBackground(Color.red);
                    }
                }
                if (coord1.equals("tercer")|| coord1.equals("-3")){
                    if (coord2.equals("si")){
                        Visual_Main.ppiso64.setBackground(Color.white);}
                    else{
                    PisoDestino=-3;
                    Visual_Main.ppiso64.setBackground(Color.red);
                    }
                }
                if (coord1.equals("cuarto")|| coord1.equals("-4")){
                    if (coord2.equals("si")){
                        Visual_Main.ppiso65.setBackground(Color.white);}
                    else{
                    PisoDestino=-4;
                    Visual_Main.ppiso65.setBackground(Color.red);
                    }
                }
                if (coord1.equals("quinto")|| coord1.equals("-5")){
                    if (coord2.equals("si")){
                        Visual_Main.ppiso66.setBackground(Color.white);}
                    else{
                    PisoDestino=-5;
                    Visual_Main.ppiso66.setBackground(Color.red);
                    }
                }
                if (coord1.equals("sexto")|| coord1.equals("-6")){
                    if (coord2.equals("si")){
                        Visual_Main.ppiso67.setBackground(Color.white);}
                    else{
                    PisoDestino=-6;
                    Visual_Main.ppiso67.setBackground(Color.red);
                    }
                }
                if (coord1.equals("septimo")|| coord1.equals("-7")) {
                    if (coord2.equals("si")){
                        Visual_Main.ppiso68.setBackground(Color.white);}
                    else{
                    PisoDestino=-7;
                    Visual_Main.ppiso68.setBackground(Color.red);
                    }
                }
                if (coord1.equals("octavo")|| coord1.equals("-8"))  {
                    if (coord2.equals("si")){
                        Visual_Main.ppiso69.setBackground(Color.white);}
                    else{
                    PisoDestino=-8;
                    Visual_Main.ppiso69.setBackground(Color.red);
                    }
                }
                if (coord1.equals("noveno")|| coord1.equals("-9")) {
                    if (coord2.equals("si")){
                        Visual_Main.ppiso70.setBackground(Color.white);}
                    else{
                    PisoDestino=-9;
                    Visual_Main.ppiso70.setBackground(Color.red);
                    }
                }
            }}

        if (coord2!="si"){
            if( vecAsc.get(0)!=300 || vecDsc.get(0)!=-300 || vacio==true){
                vacio=false;
                maniobraColectivo();

            }
            else{
                vacio=true;
                moverAscensor(); //Llamamos a la función que moverá el ascensor
            }}


    }

    public static void maniobraColectivo(){

        if (PisoDestino> PisoActual && PisoDestino <= vecAsc.get(0)){
            if(vecAsc.contains(PisoDestino)==false){
                if (vecAsc.get(0)==300) vecAsc.remove(0);
                vecAsc.add(0,PisoDestino);
            }
        }

        else if (PisoDestino>vecAsc.get(0)){
            if(vecAsc.contains(PisoDestino)==false){
                vecAsc.add(PisoDestino);
            }
        }

        else{
            if(vecDsc.contains(PisoDestino)==false){
                if (vecDsc.get(0)==-300) vecDsc.remove(0);
                vecDsc.add(PisoDestino);
                }
            }
        ordenarVector(); //Una vez colocado el piso llamado en el vector correcto, reordeno el vector.
        if(vecAsc.get(0)==300 && vecDsc.get(0)!=-300) estado="bajando";
        if(vecAsc.get(0)!=300 && vecDsc.get(0)==-300) estado="subiendo";
    }

    public static void ordenarVector(){
        Collections.sort(vecAsc);
        Collections.sort(vecDsc);
        Collections.reverse(vecDsc);

        System.out.println("Vector Ascendente :" + vecAsc);
        System.out.println("Vector Descendente :" + vecDsc);
    }

    public  static void moverAscensor() throws FileNotFoundException, JavaLayerException, InterruptedException{
        if (vacio==true) maniobraColectivo();
        if(puertascerradas==true){
            sonidos = new MP3_Sonidos();
            sonidos.iniciar("cerrar");
            Thread.sleep(1500); 			//Dormimos el programa 1,5 s "para esperar a que se cierren las puertas"
            musica= new MP3_Música();
            musica.iniciar("musica");		//Iniciamos la música



            if(estado.equals("standby")){
                if(vecAsc.get(0)!=300) estado="subiendo";
                else if (vecDsc.get(0)!=-300) estado="bajando";
            }
            timear();  //Llamamos al timer
        }
        else timear2();
    }


/* El timer funciona así:
    timer = new Timer(TiempoX,funcionX). La funcionX se llamará cada TiempoX.
*/

    public static void timear(){
    timer = new Timer(1500, TimermoverAscensor);
    timer.setInitialDelay(0);
    timer.start();
}

    public static void timear2(){
    timer2 = new Timer(1000, CheckDoors);
    timer2.setInitialDelay(0);
    timer2.start();
}

    static ActionListener CheckDoors = new ActionListener()
    {
        public void actionPerformed(ActionEvent event)
        {
            if (puertascerradas==true)
                try {
                    timer2.stop();
                    moverAscensor();

                } catch (FileNotFoundException | JavaLayerException | InterruptedException e) {
                    e.printStackTrace();
                }


        }};

// Dentro de la función del timer (moverascensor), haremos los calculos para mover el contador del ascensor piso por piso.

    static ActionListener TimermoverAscensor = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                if (estado.equals("subiendo")){
                    Visual_Main.PisoDestino.setText(String.valueOf(vecAsc.get(0))); //Se modifica el entorno grafico indicando el destino.
                    if (vecAsc.get(0)>PisoActual){ //Si el piso siguiente es mayor que el piso actual
	                    PisoActual=PisoActual+1; 	//Entonces sumamos el piso actual+1
	                    Visual_Main.lblPisoActual.setText(Integer.toString(PisoActual)); //Y lo ponemos en la parte grafica
	                    Visual_Main.arriba.setForeground(Color.RED); //Cambiamos el color de la flecha
                    }

                    //Si estamos en alguno de los pisos negativos(subsuelos) o en la planta baja, mostramos algo distinto en la interfaz gráfica
                    if(PisoActual==0)Visual_Main.lblPisoActual.setText("PB");
                    if(PisoActual==-1)Visual_Main.lblPisoActual.setText("Sub1");
                    if(PisoActual==-2)Visual_Main.lblPisoActual.setText("Sub2");
                    if(PisoActual==-3)Visual_Main.lblPisoActual.setText("Sub3");
                    if(PisoActual==-4)Visual_Main.lblPisoActual.setText("Sub4");
                    if(PisoActual==-5)Visual_Main.lblPisoActual.setText("Sub5");
                    if(PisoActual==-6)Visual_Main.lblPisoActual.setText("Sub6");
                    if(PisoActual==-7)Visual_Main.lblPisoActual.setText("Sub7");
                    if(PisoActual==-8)Visual_Main.lblPisoActual.setText("Sub8");
                    if(PisoActual==-9)Visual_Main.lblPisoActual.setText("Sub9");


                    if(vecAsc.get(0)==PisoActual){ //Cuando llegamos al piso destino, será cuando el piso actual sea = al piso destino
                        try {
                            indicarPisosNormales(String.valueOf(vecAsc.get(0)),"si");
                            indicarPisosEspeciales(String.valueOf(vecAsc.get(0)),"si");
                        } catch (FileNotFoundException | JavaLayerException | InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        vecAsc.remove(0); //Llegué a destino, saco el piso del vector
                        musica.parar();
                        Visual_Main.arriba.setForeground(Color.WHITE); //Pongo la flecha en blanco
                        try {
                            sonidos.iniciar("llegar");
                            puertascerradas=false; //Las puertas quedan abiertas.
                        } catch (EngineStateError | FileNotFoundException | JavaLayerException | InterruptedException e) {
                            e.printStackTrace();
                        }
                        Visual_Main.popup("Ascensor: Detenido");
                        timer.stop(); //paramos el timer.
                        if(vecAsc.isEmpty()){ //Si el vector ascendente esta vacio
                            vecAsc.add(300);	//Le agrego el numero 300
                            estado="standby";
                            if(vecDsc.get(0)!=-300){ //Si el vector descendente no está vacio
                                try {
                                    moverAscensor();
                                } catch (FileNotFoundException | JavaLayerException  | InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            else vacio=false;
                        }
                        else{
                            try {
                                vacio=false;
                            moverAscensor();
                        } catch (FileNotFoundException | JavaLayerException | InterruptedException e) {
                            e.printStackTrace();
                        }

                        }
                }

                }
                else if (estado.equals("bajando")){
                    Visual_Main.PisoDestino.setText(String.valueOf(vecDsc.get(0))); //Se modifica el entorno grafico indicando el siguiente destino.
                    if (vecDsc.get(0)<PisoActual){ //Si el piso de destino es menor que el piso anterior, significa que el usuario quiere descender
                    PisoActual=PisoActual-1; //Entonces restamos a piso anterior
                    Visual_Main.lblPisoActual.setText(Integer.toString(PisoActual)); //Y lo ponemos en la parte grafica
                    Visual_Main.abajo.setForeground(Color.RED);
                    }

                    //Si estamos en alguno de los pisos negativos(subsuelos) o en la planta baja, mostramos algo distinto en la interfaz gráfica
                    if(PisoActual==0)Visual_Main.lblPisoActual.setText("PB");
                    if(PisoActual==-1)Visual_Main.lblPisoActual.setText("Sub1");
                    if(PisoActual==-2)Visual_Main.lblPisoActual.setText("Sub2");
                    if(PisoActual==-3)Visual_Main.lblPisoActual.setText("Sub3");
                    if(PisoActual==-4)Visual_Main.lblPisoActual.setText("Sub4");
                    if(PisoActual==-5)Visual_Main.lblPisoActual.setText("Sub5");
                    if(PisoActual==-6)Visual_Main.lblPisoActual.setText("Sub6");
                    if(PisoActual==-7)Visual_Main.lblPisoActual.setText("Sub7");
                    if(PisoActual==-8)Visual_Main.lblPisoActual.setText("Sub8");
                    if(PisoActual==-9)Visual_Main.lblPisoActual.setText("Sub9");


                    if(vecDsc.get(0)==PisoActual){ //Cuando llegamos al piso destinado, será cuando el piso anterior sea = al piso destino
                        try {
                            indicarPisosNormales(String.valueOf(vecDsc.get(0)),"si");
                            indicarPisosEspeciales(String.valueOf(vecDsc.get(0)),"si");
                        } catch (FileNotFoundException | JavaLayerException | InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        vecDsc.remove(0); //Llegué a destino, saco el piso del vector
                        musica.parar();
                        Visual_Main.abajo.setForeground(Color.WHITE); //Pongo la flecha en blanco
                        try {
                            sonidos.iniciar("llegar");
                            puertascerradas=false;
                        } catch (EngineStateError | FileNotFoundException | JavaLayerException | InterruptedException e) {
                            e.printStackTrace();
                        }
                        Visual_Main.popup("Ascensor: Detenido");
                        timer.stop(); //paramos el timer.
                        if(vecDsc.isEmpty()){
                            vecDsc.add(-300);
                            estado="standby";
                            if(vecAsc.get(0)!=300){
                                try {
                                    moverAscensor();
                                } catch (FileNotFoundException | JavaLayerException| InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            else vacio=false;
                        }
                        else{
                            try {
                                vacio=false;
                            moverAscensor();
                        } catch (FileNotFoundException | JavaLayerException | InterruptedException e) {
                            e.printStackTrace();
                        }}
                    }

                }
            }
        };

}//Fin clase
