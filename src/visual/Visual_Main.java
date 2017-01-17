package visual;

//Importo lo necesario
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import voz.ReconocimientoVoz;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import ascensor.Ascensor;
import javazoom.jl.decoder.JavaLayerException;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//Inicio de la clase
public class Visual_Main extends JFrame {

	//Definición de variables globales a usar

	//Variables para el entorno gráfico
	private JPanel panelPrincipal;
	public static  JLabel lblPisoActual = new JLabel("PB");
	public static JLabel PisoDestino = new JLabel("PB");
	public static JLabel arriba,abajo;
	public static JLabel slidelabel;
	public static Timer timer;

	//Variables a usar para los botones de los pisos.
	public static JPanel ppiso0 ; public static JPanel ppiso1 ; public static JPanel ppiso2 ;public static JPanel ppiso3 ;public static JPanel ppiso4 ;public static JPanel ppiso5 ;
	public static JPanel ppiso6 ; public static JPanel ppiso7 ; public static JPanel ppiso8; public static JPanel ppiso9 ;public static JPanel ppiso10 ;
	public static JPanel ppiso11 ;public static JPanel ppiso12 ;public static JPanel ppiso13 ; public static JPanel ppiso14 ; public static JPanel ppiso15 ;
	public static JPanel ppiso16 ; public static JPanel ppiso17 ;public static JPanel ppiso18 ;public static JPanel ppiso19 ; public static JPanel ppiso20 ;
	public static JPanel ppiso21 ;public static JPanel ppiso22 ;public static JPanel ppiso23 ; public static JPanel ppiso24 ;public static JPanel ppiso25 ;
	public static JPanel ppiso26 ;public static JPanel ppiso27 ;public static JPanel ppiso28 ;public static JPanel ppiso29 ;public static JPanel ppiso30 ;
	public static JPanel ppiso31 ; public static JPanel ppiso32 ; public static JPanel ppiso33 ; public static JPanel ppiso34 ;public static JPanel ppiso35 ;
	public static JPanel ppiso36 ;public static JPanel ppiso37 ;public static JPanel ppiso38 ; public static JPanel ppiso39 ; public static JPanel ppiso40 ;
	public static JPanel ppiso41 ; public static JPanel ppiso42 ;public static JPanel ppiso43 ; public static JPanel ppiso44 ;public static JPanel ppiso45 ;
	public static JPanel ppiso46 ;public static JPanel ppiso47 ;public static JPanel ppiso48 ; public static JPanel ppiso49 ;public static JPanel ppiso50 ;
	public static JPanel ppiso51 ;public static JPanel ppiso52 ;public static JPanel ppiso53 ;public static JPanel ppiso54;public static JPanel ppiso55;
	public static JPanel ppiso56;public static JPanel ppiso57 ;public static JPanel ppiso58 ;public static JPanel ppiso59 ;public static JPanel ppiso60 ;public static JPanel ppiso61 ;
	public static JPanel ppiso62 ;public static JPanel ppiso63 ;public static JPanel ppiso64 ;public static JPanel ppiso65; public static JPanel ppiso66 ;
	public static JPanel ppiso67 ;public static JPanel ppiso68 ;public static JPanel ppiso69 ;public static JPanel ppiso70 ;
	private JTextField tfLlamarPiso;



	//Fin defición de variables globales

    //Primer función que se ejecuta, el main.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual_Main frame = new Visual_Main(); //Creo la interfaz visual
					frame.setVisible(true);
					ReconocimientoVoz recon=new ReconocimientoVoz(); //Creo el objeto reconocedor de voz
					recon.empezar();								 //Inicio el reconocimiento
					Ascensor.vecAsc.add(300); //Los vectores ascendente y descendente utilizados para la maniobra colectivo nunca deben estar
					Ascensor.vecDsc.add(-300);//vacios, por lo que los llenamos con números utilizados como banderas. Es decir, si el vector ascendente contiene 300, se que esta vacio
											  //y no se ha llamado ningun piso para ir hacia arriba.
				} catch (Exception e) {e.printStackTrace();}
			}
		});
	}//Fin Main


	//Visual define todo el entorno gráfico
		public Visual_Main() {
		SlideTextSwing please = new SlideTextSwing();//Mensaje troll
		please.main();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Visual_Main.class.getResource("/resources/Icons/106.png")));
		setTitle("Ascend Vox");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 454);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(192, 192, 192));
		panelPrincipal.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		JButton btnCerrarPuertas = new JButton("Cerrar Puertas");
		btnCerrarPuertas.setIcon(new ImageIcon(Visual_Main.class.getResource("/resources/derecha.png")));
		btnCerrarPuertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ascensor.puertascerradas=true;
			}
		});
		btnCerrarPuertas.setBounds(647, 379, 150, 23);
		panelPrincipal.add(btnCerrarPuertas);

		JButton btnLlamarPiso = new JButton("Llamar Piso");
		btnLlamarPiso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pizza= tfLlamarPiso.getText();
				tfLlamarPiso.setText("");
				if (Integer.valueOf(pizza)>0 && Integer.valueOf(pizza)<61)
					try {
						Ascensor.indicarPisosNormales(pizza, "");
					} catch (FileNotFoundException | JavaLayerException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else if (Integer.valueOf(pizza)<0)
					try {
						Ascensor.indicarPisosEspeciales(pizza, "subsuelo");
					} catch (FileNotFoundException | JavaLayerException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else
					try {
						Ascensor.indicarPisosEspeciales(pizza, "vacio");
					} catch (FileNotFoundException | JavaLayerException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnLlamarPiso.setBounds(463, 379, 104, 23);
		panelPrincipal.add(btnLlamarPiso);

		JButton resetearPanel = new JButton("Detener Ascensor");
		resetearPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				popup("Frenando Ascensor...");
				while(!Ascensor.vecAsc.isEmpty()){
					try {
						Ascensor.indicarPisosNormales(String.valueOf(Ascensor.vecAsc.get(0)), "si");
						Ascensor.indicarPisosEspeciales(String.valueOf(Ascensor.vecAsc.get(0)), "si");
						Ascensor.vecAsc.remove(0);
					} catch (FileNotFoundException | JavaLayerException | InterruptedException e) {
						e.printStackTrace();
					}
				}
				while(!Ascensor.vecDsc.isEmpty()){
					try {
						Ascensor.indicarPisosNormales(String.valueOf(Ascensor.vecDsc.get(0)), "si");
						Ascensor.indicarPisosEspeciales(String.valueOf(Ascensor.vecDsc.get(0)), "si");
						Ascensor.vecDsc.remove(0);
					} catch (FileNotFoundException | JavaLayerException | InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (Ascensor.estado.equals("subiendo")){
					Ascensor.vecDsc.add(-300);
					Ascensor.vecAsc.add(Ascensor.PisoActual);
				}
				if (Ascensor.estado.equals("bajando")){
					Ascensor.vecAsc.add(300);
					Ascensor.vecDsc.add(Ascensor.PisoActual);
				}
			}
		});
		resetearPanel.setForeground(Color.RED);
		resetearPanel.setFont(new Font("Arial Black", Font.BOLD, 11));
		resetearPanel.setBounds(547, 300, 181, 23);
		panelPrincipal.add(resetearPanel);

		JLabel label_71 = new JLabel("");
		label_71.setIcon(new ImageIcon(Visual_Main.class.getResource("/resources/scrollbar-button-south.png")));
		label_71.setForeground(Color.WHITE);
		label_71.setFont(new Font("Electronic Highway Sign", Font.PLAIN, 18));
		label_71.setBackground(new Color(0, 0, 128));
		label_71.setBounds(440, 377, 40, 44);
		panelPrincipal.add(label_71);

		JLabel label_70 = new JLabel("");
		label_70.setIcon(new ImageIcon(Visual_Main.class.getResource("/resources/scrollbar-button-north.png")));
		label_70.setForeground(Color.WHITE);
		label_70.setFont(new Font("Electronic Highway Sign", Font.PLAIN, 18));
		label_70.setBackground(new Color(0, 0, 128));
		label_70.setBounds(440, 371, 22, 23);
		panelPrincipal.add(label_70);

		tfLlamarPiso = new JTextField();
		tfLlamarPiso.setForeground(Color.BLACK);
		tfLlamarPiso.setHorizontalAlignment(SwingConstants.CENTER);
		tfLlamarPiso.setBounds(577, 379, 40, 23);
		panelPrincipal.add(tfLlamarPiso);
		tfLlamarPiso.setColumns(10);

		JPanel Slidepan = new JPanel();
		Slidepan.setBounds(203, 381, 206, 21);
		panelPrincipal.add(Slidepan);
		Slidepan.setLayout(null);
		Slidepan.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 128, 128)));
		Slidepan.setBackground(Color.BLACK);

		slidelabel = new JLabel("");
		slidelabel.setForeground(Color.WHITE);
		slidelabel.setBounds(10, 0, 196, 21);
		Slidepan.add(slidelabel);

		JPanel panel_Info = new JPanel();
		panel_Info.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 128, 128)));
		panel_Info.setBackground(Color.BLACK);
		panel_Info.setBounds(35, 136, 291, 212);
		panelPrincipal.add(panel_Info);
		panel_Info.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\t\t\t- Ir a [Primer/Segundo/.../Noveno] Subsuelo");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Digital-7", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 54, 350, 28);
		panel_Info.add(lblNewLabel_1);

		JLabel lblComandoIrAl = new JLabel("Comandos\r\n\r\n");
		lblComandoIrAl.setForeground(Color.WHITE);
		lblComandoIrAl.setFont(new Font("Digital-7", Font.PLAIN, 18));
		lblComandoIrAl.setBounds(10, 11, 255, 22);
		panel_Info.add(lblComandoIrAl);

		JLabel lblIrAl = new JLabel("- Ir al piso [N\u00FAmero]\r\n");
		lblIrAl.setForeground(Color.WHITE);
		lblIrAl.setFont(new Font("Digital-7", Font.PLAIN, 13));
		lblIrAl.setBounds(10, 33, 255, 22);
		panel_Info.add(lblIrAl);

		JLabel lblIrA = new JLabel("\t\t\t- Ir a Planta Baja / Lobby / Terraza / Azotea");
		lblIrA.setForeground(Color.WHITE);
		lblIrA.setFont(new Font("Digital-7", Font.PLAIN, 13));
		lblIrA.setBounds(10, 76, 383, 28);
		panel_Info.add(lblIrA);

		JLabel lblInformacin = new JLabel("Informaci\u00F3n");
		lblInformacin.setForeground(Color.WHITE);
		lblInformacin.setFont(new Font("Digital-7", Font.PLAIN, 16));
		lblInformacin.setBounds(10, 115, 255, 22);
		panel_Info.add(lblInformacin);

		JLabel lblDestino = new JLabel("Destino :");
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setFont(new Font("Digital-7", Font.PLAIN, 25));
		lblDestino.setBounds(10, 148, 117, 22);
		panel_Info.add(lblDestino);

		PisoDestino.setForeground(Color.WHITE);
		PisoDestino.setFont(new Font("Digital-7", Font.PLAIN, 25));
		PisoDestino.setBounds(149, 148, 81, 22);
		panel_Info.add(PisoDestino);

		JPanel panel_Piso = new JPanel();
		panel_Piso.setLayout(null);
		panel_Piso.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(128, 128, 128)));
		panel_Piso.setBackground(Color.BLACK);
		panel_Piso.setBounds(35, 11, 400, 114);
		panelPrincipal.add(panel_Piso);

		JLabel lbl = new JLabel("Piso:");
		lbl.setBounds(146, 40, 101, 39);
		panel_Piso.add(lbl);
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Digital-7", Font.BOLD, 42));
		lblPisoActual.setBounds(243, 40, 110, 39);
		panel_Piso.add(lblPisoActual);
		lblPisoActual.setForeground(Color.WHITE);
		lblPisoActual.setFont(new Font("Digital-7", Font.PLAIN, 42));

		arriba = new JLabel("\u25B3");
		arriba.setBounds(95, 11, 44, 49);
		panel_Piso.add(arriba);
		arriba.setForeground(Color.WHITE);
		arriba.setFont(new Font("DejaVu Serif", Font.PLAIN, 43));

		abajo = new JLabel("\u25BD");
		abajo.setBounds(95, 50, 52, 55);
		panel_Piso.add(abajo);
		abajo.setForeground(Color.WHITE);
		abajo.setFont(new Font("DejaVu Serif", Font.PLAIN, 43));

		JLabel lblNewLabel = new JLabel("Ascend Vox");
		lblNewLabel.setBounds(20, 359, 260, 64);
		panelPrincipal.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Electronic Highway Sign", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon(Visual_Main.class.getResource("/resources/Icons/106.png")));
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(new Color(255, 255, 255));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 128, 128)));
		panel.setBackground(Color.BLACK);
		panel.setBounds(447, 11, 360, 278);
		panelPrincipal.add(panel);


		//PISOS PANELES

		ppiso1 = new JPanel();
		ppiso1.setBounds(10, 11, 22, 21);
		panel.add(ppiso1);
		ppiso1.setBackground(Color.WHITE);
		ppiso1.setForeground(Color.WHITE);

		JLabel label = new JLabel("1");
		label.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso1.add(label);

		ppiso2 = new JPanel();
		ppiso2.setBounds(42, 11, 22, 21);
		panel.add(ppiso2);

		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso2.add(label_1);

		ppiso3 = new JPanel();
		ppiso3.setForeground(Color.WHITE);
		ppiso3.setBackground(Color.WHITE);
		ppiso3.setBounds(74, 11, 22, 21);
		panel.add(ppiso3);

		JLabel label_2 = new JLabel("3");
		label_2.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso3.add(label_2);

		ppiso4 = new JPanel();
		ppiso4.setForeground(Color.WHITE);
		ppiso4.setBackground(Color.WHITE);
		ppiso4.setBounds(106, 11, 22, 21);
		panel.add(ppiso4);

		JLabel label_3 = new JLabel("4");
		label_3.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso4.add(label_3);

		ppiso5 = new JPanel();
		ppiso5.setForeground(Color.WHITE);
		ppiso5.setBackground(Color.WHITE);
		ppiso5.setBounds(138, 11, 22, 21);
		panel.add(ppiso5);

		JLabel label_4 = new JLabel("5");
		label_4.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso5.add(label_4);

		ppiso6 = new JPanel();
		ppiso6.setForeground(Color.WHITE);
		ppiso6.setBackground(Color.WHITE);
		ppiso6.setBounds(170, 11, 22, 21);
		panel.add(ppiso6);

		JLabel label_5 = new JLabel("6");
		label_5.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso6.add(label_5);

		ppiso7 = new JPanel();
		ppiso7.setForeground(Color.WHITE);
		ppiso7.setBackground(Color.WHITE);
		ppiso7.setBounds(202, 11, 22, 21);
		panel.add(ppiso7);

		JLabel label_6 = new JLabel("7");
		label_6.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso7.add(label_6);

		ppiso8 = new JPanel();
		ppiso8.setForeground(Color.WHITE);
		ppiso8.setBackground(Color.WHITE);
		ppiso8.setBounds(234, 11, 22, 21);
		panel.add(ppiso8);

		JLabel label_7 = new JLabel("8");
		label_7.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso8.add(label_7);

		ppiso9 = new JPanel();
		ppiso9.setForeground(Color.WHITE);
		ppiso9.setBackground(Color.WHITE);
		ppiso9.setBounds(266, 11, 22, 21);
		panel.add(ppiso9);

		JLabel label_8 = new JLabel("9");
		label_8.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso9.add(label_8);

		ppiso10 = new JPanel();
		ppiso10.setBounds(298, 11, 22, 21);
		panel.add(ppiso10);

		JLabel label_9 = new JLabel("10");
		label_9.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso10.add(label_9);

		ppiso11 = new JPanel();
		ppiso11.setForeground(Color.WHITE);
		ppiso11.setBackground(Color.WHITE);
		ppiso11.setBounds(330, 11, 22, 21);
		panel.add(ppiso11);

		JLabel ppiso_11 = new JLabel("11");
		ppiso_11.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso11.add(ppiso_11);

		ppiso12 = new JPanel();
		ppiso12.setForeground(Color.WHITE);
		ppiso12.setBackground(Color.WHITE);
		ppiso12.setBounds(10, 43, 22, 21);
		panel.add(ppiso12);

		JLabel label_11 = new JLabel("12");
		label_11.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso12.add(label_11);

		ppiso13 = new JPanel();
		ppiso13.setForeground(Color.WHITE);
		ppiso13.setBackground(Color.WHITE);
		ppiso13.setBounds(42, 43, 22, 21);
		panel.add(ppiso13);

		JLabel label_12 = new JLabel("13");
		label_12.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso13.add(label_12);

		ppiso14 = new JPanel();
		ppiso14.setForeground(Color.WHITE);
		ppiso14.setBackground(Color.WHITE);
		ppiso14.setBounds(74, 43, 22, 21);
		panel.add(ppiso14);

		JLabel label_13 = new JLabel("14");
		label_13.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso14.add(label_13);

		ppiso15 = new JPanel();
		ppiso15.setForeground(Color.WHITE);
		ppiso15.setBackground(Color.WHITE);
		ppiso15.setBounds(106, 43, 22, 21);
		panel.add(ppiso15);

		JLabel label_14 = new JLabel("15");
		label_14.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso15.add(label_14);

		ppiso16 = new JPanel();
		ppiso16.setForeground(Color.WHITE);
		ppiso16.setBackground(Color.WHITE);
		ppiso16.setBounds(138, 43, 22, 21);
		panel.add(ppiso16);

		JLabel label_15 = new JLabel("16");
		label_15.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso16.add(label_15);

		ppiso17 = new JPanel();
		ppiso17.setForeground(Color.WHITE);
		ppiso17.setBackground(Color.WHITE);
		ppiso17.setBounds(170, 43, 22, 21);
		panel.add(ppiso17);

		JLabel label_16 = new JLabel("17");
		label_16.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso17.add(label_16);

		ppiso18 = new JPanel();
		ppiso18.setBounds(202, 43, 22, 21);
		panel.add(ppiso18);

		JLabel label_17 = new JLabel("18");
		label_17.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso18.add(label_17);

		ppiso19 = new JPanel();
		ppiso19.setForeground(Color.WHITE);
		ppiso19.setBackground(Color.WHITE);
		ppiso19.setBounds(234, 43, 22, 21);
		panel.add(ppiso19);

		JLabel label_18 = new JLabel("19");
		label_18.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso19.add(label_18);

		ppiso20 = new JPanel();
		ppiso20.setForeground(Color.WHITE);
		ppiso20.setBackground(Color.WHITE);
		ppiso20.setBounds(266, 43, 22, 21);
		panel.add(ppiso20);

		JLabel label_19 = new JLabel("20");
		label_19.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso20.add(label_19);

		ppiso21 = new JPanel();
		ppiso21.setForeground(Color.WHITE);
		ppiso21.setBackground(Color.WHITE);
		ppiso21.setBounds(298, 43, 22, 21);
		panel.add(ppiso21);

		JLabel label_20 = new JLabel("21");
		label_20.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso21.add(label_20);

		ppiso22 = new JPanel();
		ppiso22.setForeground(Color.WHITE);
		ppiso22.setBackground(Color.WHITE);
		ppiso22.setBounds(330, 43, 22, 21);
		panel.add(ppiso22);

		JLabel label_21 = new JLabel("22");
		label_21.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso22.add(label_21);

		ppiso23 = new JPanel();
		ppiso23.setForeground(Color.WHITE);
		ppiso23.setBackground(Color.WHITE);
		ppiso23.setBounds(10, 75, 22, 21);
		panel.add(ppiso23);

		JLabel label_22 = new JLabel("23");
		label_22.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso23.add(label_22);

		ppiso24 = new JPanel();
		ppiso24.setForeground(Color.WHITE);
		ppiso24.setBackground(Color.WHITE);
		ppiso24.setBounds(42, 75, 22, 21);
		panel.add(ppiso24);

		JLabel label_23 = new JLabel("24");
		label_23.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso24.add(label_23);

		ppiso25 = new JPanel();
		ppiso25.setForeground(Color.WHITE);
		ppiso25.setBackground(Color.WHITE);
		ppiso25.setBounds(74, 75, 22, 21);
		panel.add(ppiso25);

		JLabel label_24 = new JLabel("25");
		label_24.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso25.add(label_24);

		ppiso26 = new JPanel();
		ppiso26.setBounds(106, 75, 22, 21);
		panel.add(ppiso26);

		JLabel label_25 = new JLabel("26");
		label_25.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso26.add(label_25);

		ppiso27 = new JPanel();
		ppiso27.setForeground(Color.WHITE);
		ppiso27.setBackground(Color.WHITE);
		ppiso27.setBounds(138, 75, 22, 21);
		panel.add(ppiso27);

		JLabel label_26 = new JLabel("27");
		label_26.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso27.add(label_26);

		ppiso28 = new JPanel();
		ppiso28.setForeground(Color.WHITE);
		ppiso28.setBackground(Color.WHITE);
		ppiso28.setBounds(170, 75, 22, 21);
		panel.add(ppiso28);

		JLabel label_27 = new JLabel("28");
		label_27.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso28.add(label_27);

		ppiso29 = new JPanel();
		ppiso29.setForeground(Color.WHITE);
		ppiso29.setBackground(Color.WHITE);
		ppiso29.setBounds(202, 75, 22, 21);
		panel.add(ppiso29);

		JLabel label_28 = new JLabel("29");
		label_28.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso29.add(label_28);

		ppiso30 = new JPanel();
		ppiso30.setForeground(Color.WHITE);
		ppiso30.setBackground(Color.WHITE);
		ppiso30.setBounds(234, 75, 22, 21);
		panel.add(ppiso30);

		JLabel label_29 = new JLabel("30");
		label_29.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso30.add(label_29);

		ppiso31 = new JPanel();
		ppiso31.setForeground(Color.WHITE);
		ppiso31.setBackground(Color.WHITE);
		ppiso31.setBounds(266, 75, 22, 21);
		panel.add(ppiso31);

		JLabel label_30 = new JLabel("31");
		label_30.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso31.add(label_30);

		ppiso32 = new JPanel();
		ppiso32.setForeground(Color.WHITE);
		ppiso32.setBackground(Color.WHITE);
		ppiso32.setBounds(298, 75, 22, 21);
		panel.add(ppiso32);

		JLabel label_31 = new JLabel("32");
		label_31.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso32.add(label_31);

		ppiso33 = new JPanel();
		ppiso33.setForeground(Color.WHITE);
		ppiso33.setBackground(Color.WHITE);
		ppiso33.setBounds(330, 75, 22, 21);
		panel.add(ppiso33);

		JLabel label_32 = new JLabel("33");
		label_32.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso33.add(label_32);

		ppiso34 = new JPanel();
		ppiso34.setBounds(10, 107, 22, 21);
		panel.add(ppiso34);

		JLabel label_33 = new JLabel("34");
		label_33.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso34.add(label_33);

		ppiso35 = new JPanel();
		ppiso35.setForeground(Color.WHITE);
		ppiso35.setBackground(Color.WHITE);
		ppiso35.setBounds(42, 107, 22, 21);
		panel.add(ppiso35);

		JLabel label_34 = new JLabel("35");
		label_34.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso35.add(label_34);

		ppiso36 = new JPanel();
		ppiso36.setForeground(Color.WHITE);
		ppiso36.setBackground(Color.WHITE);
		ppiso36.setBounds(74, 107, 22, 21);
		panel.add(ppiso36);

		JLabel label_35 = new JLabel("36");
		label_35.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso36.add(label_35);

		ppiso37 = new JPanel();
		ppiso37.setForeground(Color.WHITE);
		ppiso37.setBackground(Color.WHITE);
		ppiso37.setBounds(106, 107, 22, 21);
		panel.add(ppiso37);

		JLabel label_36 = new JLabel("37");
		label_36.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso37.add(label_36);

		ppiso38 = new JPanel();
		ppiso38.setForeground(Color.WHITE);
		ppiso38.setBackground(Color.WHITE);
		ppiso38.setBounds(138, 107, 22, 21);
		panel.add(ppiso38);

		JLabel label_37 = new JLabel("38");
		label_37.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso38.add(label_37);

		ppiso39 = new JPanel();
		ppiso39.setForeground(Color.WHITE);
		ppiso39.setBackground(Color.WHITE);
		ppiso39.setBounds(170, 107, 22, 21);
		panel.add(ppiso39);

		JLabel label_38 = new JLabel("39");
		label_38.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso39.add(label_38);

		ppiso40 = new JPanel();
		ppiso40.setForeground(Color.WHITE);
		ppiso40.setBackground(Color.WHITE);
		ppiso40.setBounds(202, 107, 22, 21);
		panel.add(ppiso40);

		JLabel label_39 = new JLabel("40");
		label_39.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso40.add(label_39);

		ppiso41 = new JPanel();
		ppiso41.setForeground(Color.WHITE);
		ppiso41.setBackground(Color.WHITE);
		ppiso41.setBounds(234, 107, 22, 21);
		panel.add(ppiso41);

		JLabel label_40 = new JLabel("41");
		label_40.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso41.add(label_40);

		ppiso42 = new JPanel();
		ppiso42.setBounds(266, 107, 22, 21);
		panel.add(ppiso42);

		JLabel label_41 = new JLabel("42");
		label_41.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso42.add(label_41);

		ppiso43 = new JPanel();
		ppiso43.setForeground(Color.WHITE);
		ppiso43.setBackground(Color.WHITE);
		ppiso43.setBounds(298, 107, 22, 21);
		panel.add(ppiso43);

		JLabel label_42 = new JLabel("43");
		label_42.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso43.add(label_42);

		ppiso44 = new JPanel();
		ppiso44.setForeground(Color.WHITE);
		ppiso44.setBackground(Color.WHITE);
		ppiso44.setBounds(330, 107, 22, 21);
		panel.add(ppiso44);

		JLabel label_43 = new JLabel("44");
		label_43.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso44.add(label_43);

		ppiso45 = new JPanel();
		ppiso45.setForeground(Color.WHITE);
		ppiso45.setBackground(Color.WHITE);
		ppiso45.setBounds(10, 139, 22, 21);
		panel.add(ppiso45);

		JLabel label_44 = new JLabel("45");
		label_44.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso45.add(label_44);

		ppiso46 = new JPanel();
		ppiso46.setForeground(Color.WHITE);
		ppiso46.setBackground(Color.WHITE);
		ppiso46.setBounds(42, 139, 22, 21);
		panel.add(ppiso46);

		JLabel label_45 = new JLabel("46");
		label_45.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso46.add(label_45);

		ppiso47 = new JPanel();
		ppiso47.setForeground(Color.WHITE);
		ppiso47.setBackground(Color.WHITE);
		ppiso47.setBounds(74, 139, 22, 21);
		panel.add(ppiso47);

		JLabel label_46 = new JLabel("47");
		label_46.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso47.add(label_46);

		ppiso48 = new JPanel();
		ppiso48.setForeground(Color.WHITE);
		ppiso48.setBackground(Color.WHITE);
		ppiso48.setBounds(106, 139, 22, 21);
		panel.add(ppiso48);

		JLabel label_47 = new JLabel("48");
		label_47.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso48.add(label_47);

		ppiso49 = new JPanel();
		ppiso49.setForeground(Color.WHITE);
		ppiso49.setBackground(Color.WHITE);
		ppiso49.setBounds(138, 139, 22, 21);
		panel.add(ppiso49);

		JLabel label_48 = new JLabel("49");
		label_48.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso49.add(label_48);

		ppiso50 = new JPanel();
		ppiso50.setBounds(170, 139, 22, 21);
		panel.add(ppiso50);

		JLabel label_49 = new JLabel("50");
		label_49.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso50.add(label_49);

		ppiso51 = new JPanel();
		ppiso51.setForeground(Color.WHITE);
		ppiso51.setBackground(Color.WHITE);
		ppiso51.setBounds(202, 139, 22, 21);
		panel.add(ppiso51);

		JLabel label_50 = new JLabel("51");
		label_50.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso51.add(label_50);

		ppiso52 = new JPanel();
		ppiso52.setForeground(Color.WHITE);
		ppiso52.setBackground(Color.WHITE);
		ppiso52.setBounds(234, 139, 22, 21);
		panel.add(ppiso52);

		JLabel label_51 = new JLabel("52");
		label_51.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso52.add(label_51);

		ppiso53 = new JPanel();
		ppiso53.setForeground(Color.WHITE);
		ppiso53.setBackground(Color.WHITE);
		ppiso53.setBounds(266, 139, 22, 21);
		panel.add(ppiso53);

		JLabel label_52 = new JLabel("53");
		label_52.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso53.add(label_52);

		ppiso54 = new JPanel();
		ppiso54.setForeground(Color.WHITE);
		ppiso54.setBackground(Color.WHITE);
		ppiso54.setBounds(298, 139, 22, 21);
		panel.add(ppiso54);

		JLabel label_53 = new JLabel("54");
		label_53.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso54.add(label_53);

		ppiso55 = new JPanel();
		ppiso55.setForeground(Color.WHITE);
		ppiso55.setBackground(Color.WHITE);
		ppiso55.setBounds(330, 139, 22, 21);
		panel.add(ppiso55);

		JLabel label_54 = new JLabel("55");
		label_54.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso55.add(label_54);

		ppiso56 = new JPanel();
		ppiso56.setForeground(Color.WHITE);
		ppiso56.setBackground(Color.WHITE);
		ppiso56.setBounds(10, 171, 22, 21);
		panel.add(ppiso56);

		JLabel label_55 = new JLabel("56");
		label_55.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso56.add(label_55);

		ppiso57 = new JPanel();
		ppiso57.setForeground(Color.WHITE);
		ppiso57.setBackground(Color.WHITE);
		ppiso57.setBounds(42, 171, 22, 21);
		panel.add(ppiso57);

		JLabel label_56 = new JLabel("57");
		label_56.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso57.add(label_56);

		ppiso58 = new JPanel();
		ppiso58.setBounds(74, 171, 22, 21);
		panel.add(ppiso58);

		JLabel label_57 = new JLabel("58");
		label_57.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso58.add(label_57);

		ppiso59 = new JPanel();
		ppiso59.setForeground(Color.WHITE);
		ppiso59.setBackground(Color.WHITE);
		ppiso59.setBounds(106, 171, 22, 21);
		panel.add(ppiso59);

		JLabel label_58 = new JLabel("59");
		label_58.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso59.add(label_58);

		ppiso60 = new JPanel();
		ppiso60.setForeground(Color.WHITE);
		ppiso60.setBackground(Color.WHITE);
		ppiso60.setBounds(138, 171, 22, 21);
		panel.add(ppiso60);

		JLabel label_59 = new JLabel("60");
		label_59.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso60.add(label_59);

		ppiso61 = new JPanel();
		ppiso61.setForeground(Color.WHITE);
		ppiso61.setBackground(Color.WHITE);
		ppiso61.setBounds(298, 204, 22, 21);
		panel.add(ppiso61);

		JLabel label_60 = new JLabel("61");
		label_60.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso61.add(label_60);

		ppiso62 = new JPanel();
		ppiso62.setForeground(Color.WHITE);
		ppiso62.setBackground(Color.WHITE);
		ppiso62.setBounds(74, 236, 22, 21);
		panel.add(ppiso62);

		JLabel label_61 = new JLabel("1");
		label_61.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso62.add(label_61);

		ppiso63 = new JPanel();
		ppiso63.setForeground(Color.WHITE);
		ppiso63.setBackground(Color.WHITE);
		ppiso63.setBounds(106, 236, 22, 21);
		panel.add(ppiso63);

		JLabel label_62 = new JLabel("2");
		label_62.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso63.add(label_62);

		ppiso65 = new JPanel();
		ppiso65.setForeground(Color.WHITE);
		ppiso65.setBackground(Color.WHITE);
		ppiso65.setBounds(170, 236, 22, 21);
		panel.add(ppiso65);

		JLabel label_64 = new JLabel("4");
		label_64.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso65.add(label_64);

		ppiso66 = new JPanel();
		ppiso66.setBounds(202, 236, 22, 21);
		panel.add(ppiso66);

		JLabel label_65 = new JLabel("5");
		label_65.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso66.add(label_65);

		ppiso67 = new JPanel();
		ppiso67.setForeground(Color.WHITE);
		ppiso67.setBackground(Color.WHITE);
		ppiso67.setBounds(234, 236, 22, 21);
		panel.add(ppiso67);

		JLabel label_66 = new JLabel("6");
		label_66.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso67.add(label_66);

		ppiso68 = new JPanel();
		ppiso68.setForeground(Color.WHITE);
		ppiso68.setBackground(Color.WHITE);
		ppiso68.setBounds(266, 236, 22, 21);
		panel.add(ppiso68);

		JLabel label_67 = new JLabel("7");
		label_67.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso68.add(label_67);

		ppiso69 = new JPanel();
		ppiso69.setForeground(Color.WHITE);
		ppiso69.setBackground(Color.WHITE);
		ppiso69.setBounds(298, 236, 22, 21);
		panel.add(ppiso69);

		JLabel label_68 = new JLabel("8");
		label_68.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso69.add(label_68);

		ppiso70 = new JPanel();
		ppiso70.setForeground(Color.WHITE);
		ppiso70.setBackground(Color.WHITE);
		ppiso70.setBounds(330, 236, 22, 21);
		panel.add(ppiso70);

		JLabel label_69 = new JLabel("9");
		label_69.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso70.add(label_69);

		JLabel lblLobbyTerraza = new JLabel("Lobby / Planta Baja");
		lblLobbyTerraza.setFont(new Font("Digital-7", Font.PLAIN, 12));
		lblLobbyTerraza.setForeground(Color.WHITE);
		lblLobbyTerraza.setBounds(10, 203, 118, 22);
		panel.add(lblLobbyTerraza);

		ppiso0 = new JPanel();
		ppiso0.setForeground(Color.WHITE);
		ppiso0.setBackground(Color.WHITE);
		ppiso0.setBounds(138, 203, 22, 21);
		panel.add(ppiso0);

		JLabel label_10 = new JLabel("0");
		label_10.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso0.add(label_10);

		JLabel lblTerrazaazotea = new JLabel("Terraza / Azotea ");
		lblTerrazaazotea.setFont(new Font("Digital-7", Font.PLAIN, 12));
		lblTerrazaazotea.setForeground(Color.WHITE);
		lblTerrazaazotea.setBounds(190, 204, 108, 21);
		panel.add(lblTerrazaazotea);

		ppiso64 = new JPanel();
		ppiso64.setForeground(Color.WHITE);
		ppiso64.setBackground(Color.WHITE);
		ppiso64.setBounds(138, 235, 22, 21);
		panel.add(ppiso64);

		JLabel label_63 = new JLabel("3");
		label_63.setFont(new Font("Digital-7", Font.BOLD, 10));
		ppiso64.add(label_63);

		JLabel lblSubsuelos = DefaultComponentFactory.getInstance().createLabel("Subsuelos");
		lblSubsuelos.setFont(new Font("Digital-7", Font.PLAIN, 12));
		lblSubsuelos.setForeground(Color.WHITE);
		lblSubsuelos.setBounds(10, 242, 92, 15);
		panel.add(lblSubsuelos);

		JLabel Fondo_label = new JLabel("");
		Fondo_label.setIcon(new ImageIcon(Visual_Main.class.getResource("/Imagenes/fondo2.jpg")));
		Fondo_label.setBounds(0, 0, 807, 423);
		panelPrincipal.add(Fondo_label);{
		}
	}

	//Fin Visual

	//Función popUp, para mostrar mensajes por el visor
	public static void popup(String txt){
		slidelabel.setText(txt);
	    }

} //Fin de la clase