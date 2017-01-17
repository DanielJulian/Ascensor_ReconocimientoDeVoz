package mp3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.Timer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import visual.Visual_Main;


public class MP3_Música {
   private static Timer timer;
   static boolean parar = false;

   public void iniciar(String pista) throws FileNotFoundException,
         JavaLayerException, InterruptedException {
	   String direccion="";
	   if ( pista == "musica") {
		   int randomNum= (int)(Math.random() * 4);
		   if (randomNum==0){
			   direccion=new java.io.File("").getAbsolutePath()+"/Recursos/Sonidos/Local Forecast - Elevator.mp3";
			   Visual_Main.popup("Reproduciendo: Forecast");
		   }
		   if (randomNum==1){
			   direccion=new java.io.File("").getAbsolutePath()+"/Recursos/Sonidos/star wars cantina.mp3";
			   Visual_Main.popup("Reproduciendo: SW Cantina");
		   }
		   if (randomNum==2){
			   direccion=new java.io.File("").getAbsolutePath()+"/Recursos/Sonidos/star wars marcha.mp3";
			   Visual_Main.popup("Reproduciendo: Imperial March");
		   }
		   if (randomNum==3){
			   direccion=new java.io.File("").getAbsolutePath()+"/Recursos/Sonidos/rickroll.mp3";
			   Visual_Main.popup("Reproduciendo: Rick Roll");
		   }
	   }
      final Player pl = new Player(new FileInputStream(direccion));
      parar=false;
      timer = new Timer(300000, moverAscensor);
      timer.setInitialDelay(0);
      timer.start();

      new Thread() {
         public void run() {
            try {
               while (true) {
                  if (!parar) {
                     if (!pl.play(1)) {
                        break;
                     }
                  }
                  else pl.close();
               }
            } catch (JavaLayerException e) {
               e.printStackTrace();
            }
         }
      }.start();


   }
	 static ActionListener moverAscensor = new ActionListener()
	    {
	        public void actionPerformed(ActionEvent event)
	        {
	        	if(parar==true)
	    			timer.stop();


	        }
	    };

   public static void parar(){
	   parar=true;
   }


}