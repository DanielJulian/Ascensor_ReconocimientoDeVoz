package mp3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.Timer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class MP3_Sonidos {
   private static Timer timer;
   static boolean parar = false;

   public void iniciar(String pista) throws FileNotFoundException,
         JavaLayerException, InterruptedException {
	   String direccion="";
	   if ( pista == "llegar") direccion=new java.io.File("").getAbsolutePath()+"/Recursos/Sonidos/llegar.mp3";
	   if ( pista == "cerrar") direccion=new java.io.File("").getAbsolutePath()+"/Recursos/Sonidos/cerrar.mp3";
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