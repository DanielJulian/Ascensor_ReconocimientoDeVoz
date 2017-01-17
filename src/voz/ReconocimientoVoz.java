package voz;

//Investigar NoiseGate(Puerta de ruido), para activar el mic luego de cierto umbral.

//Importamos las librerias necesarias
import javax.speech.*;
import javax.speech.recognition.*;

import ascensor.Ascensor;

import visual.Visual_Main;
import java.io.FileReader;
import java.util.Locale;

public class ReconocimientoVoz extends ResultAdapter { //Inicio de la clase

//Variables  a utilizar
 static Recognizer recognizer;  			//Objeto de reconocimiento de voz
 private String palabra;					//Se guardan las palabras una a la vez
 static String frase=""; 					//Frase, contendra la oración entera
 private boolean inicio=false;				//Hasta que el usuario no diga " iniciar reconocimiento " el programa no inicia
 Ascensor ascensor = new Ascensor();

 @Override
 public void resultAccepted(ResultEvent re){

	 try{
		 //Primero traduzco el audio en texto.
		 Result res = (Result)(re.getSource());
		 ResultToken tokens[] = res.getBestTokens();
		 String args[]= new String[1];
		 args[0]="";
		 //Dentro de este for, recorremos el array llamado token en el cual se encuentran la/s palabras obtenidas
		 //Y las guardamos en el string "palabra" y printeamos
		 for (int i=0; i < tokens.length; i++){
			 palabra = tokens[i].getSpokenText();
			 args[0]+=palabra+" ";
			 System.out.print(palabra + " ");
			 frase=frase+" "+ palabra;
		 }

		 System.out.println();

		 if(frase.equals(" Iniciar Reconocimiento")){
			 inicio=true;
			 Visual_Main.popup("Reconocimiento de voz Iniciado");
			 
			 
		 }
		 

		 if(frase.equals(" Salir") && inicio==true) {
			 recognizer.deallocate();
			 System.out.println("Gracias por usar el asensor amigacho");
			 System.exit(0);
		 }



		 String[] token= frase.split(" "); //Separamos la frase en palabras

		 //Dependiendo de lo encontrado en la frase, se llamaran a las distintas funciones

		 if(token[1].equals("Iralpiso") && inicio==true){
			 try{
				 if (token.length==3){
				 ascensor.indicarPisosNormales(token[2],"vacio");
				 }
				 else ascensor.indicarPisosNormales(token[2],token[3]);
				}
			catch(Exception er){}
		 }

		 else if(token[1].equals("Ira") && inicio==true){
			 try{
				 if (token.length==3){
					 ascensor.indicarPisosEspeciales(token[2],"vacio");
				 }
				 else ascensor.indicarPisosEspeciales(token[2],token[3]);
				}
			catch(Exception er){}
		 }



		  frase=""; //Cada vez que termino una frase, vacio el String para la próxima frase.
	 }
	 catch(Exception e){}

 }


 public static void empezar(){
	 try{
		 recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
		 recognizer.allocate();

		 FileReader grammar1 =new FileReader(new java.io.File("").getAbsolutePath()+"/Recursos/Grammar"); //Localizamos el archivo de gramatica, donde se encuentran todas las palabras que el programa va a reconocer

		 RuleGrammar rg = recognizer.loadJSGF(grammar1); //Asignamos el archivo de gramatica al reconocedor.
		 rg.setEnabled(true);

		 recognizer.addResultListener(new ReconocimientoVoz());
		 recognizer.commitChanges();
		 recognizer.requestFocus();
		 recognizer.resume();

		 System.out.println("Empezá a hablar amigacho");
	 }
	 catch (Exception e){
		 System.out.println("Exception en " + e.toString());
		 e.printStackTrace();
		 System.exit(0);
	 }
 }

 public static void main(String args[]){
	 empezar();
 }

public static void suspender() throws InterruptedException{ //Suspender el reconocimiento de voz
	frase="";
	recognizer.pause();

}

public static void reanudar() throws AudioException,  InterruptedException{ //Reanudar el reconocimiento
	System.out.println("Reconocimiento de voz reanudado");
	recognizer.resume();
}

} //Fin de la clase



