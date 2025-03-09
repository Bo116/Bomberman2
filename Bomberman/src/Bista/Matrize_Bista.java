package Bista;

import Eredua.Bomberman;
import Eredua.MatrizeClassic;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

public class Matrize_Bista extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private static Matrize_Bista nireMatrizea;
    private BombermanController controller; // Controlador de teclado
    private static int x;
    private static int y;
    private Image img;
    public static Matrize_Bista getNireMatrizea() {
        if (nireMatrizea == null) {
            nireMatrizea = new Matrize_Bista();
        }
        return nireMatrizea;
    }
  

    public class SoundPlayer {
        public static void playSound(String resourcePath) {
            try {
                InputStream audioSrc = SoundPlayer.class.getResourceAsStream(resourcePath);
                if (audioSrc == null) {
                    throw new RuntimeException("No se encontró el archivo de sonido: " + resourcePath);
                }

                // Envolver en BufferedInputStream
                InputStream bufferedIn = new BufferedInputStream(audioSrc);
                AudioInputStream originalStream = AudioSystem.getAudioInputStream(bufferedIn);

                // Obtener el formato original
                AudioFormat baseFormat = originalStream.getFormat();
                AudioFormat targetFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED, // Cambio a PCM_SIGNED
                    44100, // Frecuencia de muestreo compatible
                    16,    // 16-bit
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    44100,
                    false
                );

                // Convertir el AudioInputStream
                AudioInputStream convertedStream = AudioSystem.getAudioInputStream(targetFormat, originalStream);

                Clip clip = AudioSystem.getClip();
                clip.open(convertedStream);
                clip.start();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }
    private Matrize_Bista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen en el fondo del panel
             
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this); // Ajustar la imagen al tamaño del panel
                   
            }
            
        };
        
        // Cargar la imagen en el constructor
        URL imageUrl = getClass().getResource("/Irudiak/back.png"); // Ruta de la imagen
        img = Toolkit.getDefaultToolkit().getImage(imageUrl);  // Cargar la imagen

        contentPane.setBorder(new EmptyBorder(1, 1, 5, 5));
        contentPane.setLayout(new GridLayout(11, 17, 0, 0));
        setContentPane(contentPane);

        // Agregar el controlador de teclado
        controller = new BombermanController();
        addKeyListener(controller);
        requestFocusInWindow();
        SoundPlayer.playSound("/soinuak/music.wav");// Asegurar que la ventana tenga el foco
    }

    public static void gehituLaukia(Laukia_Bista pLaukiaBista) {
        contentPane.add(pLaukiaBista);
    }

    public Laukia_Bista bilatuLaukia(int x, int y) {
        return (Laukia_Bista) contentPane.getComponent(x * 17 + y);
    }
    
    public void mugituBomberman(int hX, int hY, String pNorabidea) {
    	bilatuLaukia(x, y).bombermanKendu();
    	bilatuLaukia(hX, hY).bombermanJarri(pNorabidea);
    	this.x=hX;
    	this.y=hY;
    }
/*
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update recibido: " + arg);
    }
*/
    // Controlador de teclado separado de "Controler"
    private class BombermanController extends Observable implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_W:
                    //System.out.println("parriba");
                    Eredua.MatrizeClassic.getNireMatrizea().mugituBomberman('W');
                    Matrize_Bista.SoundPlayer.playSound("/soinuak/Walking1.wav");
                    break;
                case KeyEvent.VK_S:
                    //System.out.println("pabajo");
                    Eredua.MatrizeClassic.getNireMatrizea().mugituBomberman('S');
                    Matrize_Bista.SoundPlayer.playSound("/soinuak/Walking1.wav");
                    break;
                case KeyEvent.VK_A:
                    //System.out.println("paizda");
                    Eredua.MatrizeClassic.getNireMatrizea().mugituBomberman('A');
                    Matrize_Bista.SoundPlayer.playSound("/soinuak/Walking1.wav");
                    break;
                case KeyEvent.VK_D:
                    //System.out.println("padcha");
                    Eredua.MatrizeClassic.getNireMatrizea().mugituBomberman('D');
                    Matrize_Bista.SoundPlayer.playSound("/soinuak/Walking1.wav");
                    break;
                case KeyEvent.VK_SPACE:
					Eredua.MatrizeClassic.getNireMatrizea().getBomberman().bombaJarri();
					break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }


	
	
	@Override
	public void update(Observable o, Object arg) {
		MatrizeClassic matrizea = MatrizeClassic.getNireMatrizea();
		if (arg.equals("Matrizea sortu da")) {
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 17; j++) {
					this.gehituLaukia(new Laukia_Bista(i, j, false))
					;
				}
			}
			bilatuLaukia(0,0).bombermanJarri("W");
			this.x = 0;
			this.y = 0;
		}
		else if (arg instanceof Object[]) {
			
			Object[] obj = (Object[]) arg;
			if (obj[0].equals("Bloke gogorra gehitu da")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.bilatuLaukia(i, j).blokeGogorra();
			}
			else if (obj[0].equals("Bloke biguna gehitu da")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.bilatuLaukia(i, j).blokeBiguna();
			}
			else if (obj[0].equals("MoveA")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.mugituBomberman(i, j,"A");
				
			}
			else if (obj[0].equals("MoveD")) {
					int i = (int) obj[1];
					int j = (int) obj[2];
					this.mugituBomberman(i, j,"D");
			}
			else if(obj[0].equals("MoveW")) {
					int i = (int) obj[1];
					int j = (int) obj[2];
					this.mugituBomberman(i, j,"W");
			}
			else if(obj[0].equals("MoveS")) {
						int i = (int) obj[1];
						int j = (int) obj[2];
						this.mugituBomberman(i, j,"S") ;
					}	
				//System.out.println("WASD");
			
			/*else if (obj[0].equals("BombaJarri")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.bilatuLaukia(i, j).bombaJarri();
								
			}*/
		}
		else if (arg instanceof Character) {
			this.bilatuLaukia(x, y).bombermanAldatu(arg.toString());
		}
		else if(arg.equals("Jokua amaitu da")) {
			 Object[] opciones = {"Ados"};
			JOptionPane.showOptionDialog(
		            getNireMatrizea(),               // Componente padre (puedes poner 'null' para que no tenga padre)
		            "Jokoa bukatu da. Sakatu 'Ados' irteteko.", // Mensaje
		            "JOKOAREN AMAIERA",  // Título
		            JOptionPane.DEFAULT_OPTION, // Tipo de opción
		            JOptionPane.INFORMATION_MESSAGE, // Tipo de mensaje
		            null,               // Icono (null usa el predeterminado)
		            opciones,           // Opciones de botones
		            null        // Valor predeterminado (botón seleccionado por defecto)
		        );
			System.exit(0);
		}
		else {System.out.println("BombaJarri");}
		
	}
	
	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}
