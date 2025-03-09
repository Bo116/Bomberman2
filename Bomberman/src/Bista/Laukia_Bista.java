	package Bista;
	
	import javax.swing.ImageIcon;
	import javax.swing.JPanel;
	import java.awt.SystemColor;
	import java.awt.Toolkit;
	import java.net.URL;
	
	import javax.swing.border.LineBorder;
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Image;
	import java.util.Observable;
	import java.util.Observer;
	import java.util.Random;
	public class Laukia_Bista extends JPanel implements Observer {
		private int x;
		private int y;
		private Image img;
		private boolean bomba=false;
		private boolean sua=false;
		private boolean bomberman=false;
		//private boolean pEgoera;
	
		private static final long serialVersionUID = 1L;
		
		/**
		 * Create the panel.
		 */
		public Laukia_Bista(int pX, int pY,boolean pEgoera) {
			setForeground(SystemColor.window);
			//setBorder(new LineBorder(new Color(0, 0, 0)));
			setBackground(SystemColor.activeCaption);
			this.setBounds(pX*50, pY*50, 100, 100);
			setOpaque(false);
		}
		public void blokeGogorra() {
			img = getImg("/Irudiak/hard1.png");
	        repaint();
		}
		public void blokeBiguna() {
			img = getImg("/Irudiak/soft1.png");
			repaint();
		}
		@Override
		public void update(Observable o, Object arg) {
			//Object[] obj = (Object[]) arg;
			/*if (arg.equals("BombaKendu")) {
				//int i = (int) obj[1];
				//int j = (int) obj[2];
				this.bombaKendu();}*/
			if (arg.equals("BombaJarri")) {
				this.bombaJarri();
			}else if(arg.equals("SuaJarri")) {
				this.suaJarri();
			}else if(arg.equals("SuaKendu")) {
				this.suaKendu();
			}else if (arg.equals("Bomba2")){
				this.bombaAldatu(2);
			}
			else if (arg.equals("Bomba1")){
				this.bombaAldatu(1);
			}
			/*else if (arg instanceof Character) {
				this.bombermanAldatu(arg.toString());
			
				System.out.println("Bomberman aldaketa");
			}*/
		}
		public void bombermanAldatu(String pNorabide) {
			System.out.println(pNorabide+"a");
			/*if(!(img==getImg("/Irudiak/whitewithbomb2.png")||img==getImg("/Irudiak/whitewithbomb3.png")
					||img==getImg("/Irudiak/whitewithbomb1.png"))) {*/
			if (bomba==false) {
				Random rand = new Random();
				int i = rand.nextInt(5)+1;
				if (pNorabide.equals("W")) {
					if(i==1) {
						img = getImg("/Irudiak/whiteup1.png");}
					else if(i==2) {
						img = getImg("/Irudiak/whiteup2.png");}
					else if(i==3) {
						img = getImg("/Irudiak/whiteup3.png");}
					else if(i==4) {
						img = getImg("/Irudiak/whiteup4.png");}
					else if(i==5) {
						img = getImg("/Irudiak/whiteup5.png");
					}
				}
				else if (pNorabide.equals("S")) {
					if(i==1) {
						img = getImg("/Irudiak/whitedown1.png");}
					else if(i==2) {
						img = getImg("/Irudiak/whitedown2.png");}
					else if(i==3) {
						img = getImg("/Irudiak/whitedown3.png");}
					else{
						img = getImg("/Irudiak/whitedown4.png");}
				}
				else if (pNorabide.equals("D")) {
					if(i==1) {
						img = getImg("/Irudiak/whiteright1.png");}
					else if(i==2) {
						img = getImg("/Irudiak/whiteright2.png");}
					else if(i==3) {
						img = getImg("/Irudiak/whiteright3.png");}
					else if(i==4) {
						img = getImg("/Irudiak/whiteright4.png");}
					else if(i==5) {
						img = getImg("/Irudiak/whiteright5.png");
					}
				}
				else if (pNorabide.equals("A")) {
					if(i==1) {
						img = getImg("/Irudiak/whiteleft1.png");}
					else if(i==2) {
						img = getImg("/Irudiak/whiteleft2.png");}
					else if(i==3) {
						img = getImg("/Irudiak/whiteleft3.png");}
					else if(i==4) {
						img = getImg("/Irudiak/whiteleft4.png");}
					else if(i==5) {
						img = getImg("/Irudiak/whiteleft5.png");
					}}}
		
			repaint();
			}
			/* (arg.equals("W")) {
				System.out.println("GOra");
				img = getImg("/Irudiak/whiteup1.png");
			}
			else if (arg.equals("S")) {
				img = getImg("/Irudiak/whitedown1.png");
			}
			else if (arg.equals("D")) {
				img = getImg("/Irudiak/whiteright1.png");
			}
			else if (arg.equals("A")) {
				img = getImg("/Irudiak/whiteleft1.png");
			}
			repaint();}*/
		public void bombermanJarri(String pNorabide) {
	
			//repaint();
			
			bomberman = true;
			if (pNorabide.equals("W")) {
				img = getImg("/Irudiak/whiteup1.png");
			}
			else if (pNorabide.equals("S")) {
				img = getImg("/Irudiak/whitedown1.png");
			}
			else if (pNorabide.equals("D")) {
				img = getImg("/Irudiak/whiteright1.png");
			}
			else if (pNorabide.equals("A")) {
				img = getImg("/Irudiak/whiteleft1.png");
			}
			
	        repaint();
		}
		
		public void bombermanKendu(){
			/*if (img==getImg("/Irudiak/whitefront1.png")||img==getImg("/Irudiak/whiteleft1.png")
				||img==getImg("/Irudiak/whiteright1.png")||img==getImg("/Irudiak/whiteup1.png")
				||img==getImg("/Irudiak/whitedown1.png")) {*/
			if (bomba==false) {
				img= null;
				
				//this.setBackground(SystemColor.activeCaption);
			}
			else if(img==getImg("/Irudiak/whitewithbomb2.png")) {
				img = getImg("/Irudiak/bomb2.png");
			    
			}
			else if(img==getImg("/Irudiak/whitewithbomb3.png")) {
				img = getImg("/Irudiak/bomb3.png");
			    
			}
			else if (sua==false && bomba==true) {
				img = getImg("/Irudiak/bomb1.png");
				
				//this.setBackground(SystemColor.activeCaption);
			}
			bomberman = false;
			repaint(); 
		}
		public void bombaJarri(){
			/*if(!(img==getImg("/Irudiak/whitefront1.png")||img==getImg("/Irudiak/bomb2.png")
					||img==getImg("/Irudiak/bomb3.png")||img==getImg("/Irudiak/whiteleft1.png")
					||img==getImg("/Irudiak/whiteright1.png"))||img==getImg("/Irudiak/whiteup1.png")
					||img==getImg("/Irudiak/whitedown1.png")) {*/
			if (bomberman==false&&bomba==false) {
				img = getImg("/Irudiak/whitewithbomb1.png");
			     repaint(); 
			}	
			else {
				img = getImg("/Irudiak/whitewithbomb1.png");
			     repaint();   
			}
			bomba = true;
			Matrize_Bista.SoundPlayer.playSound("/soinuak/PlaceBomb.wav");
		}
		
		public void bombaAldatu(int i){
			if(i==2) {
					if(!(img==getImg("/Irudiak/whitewithbomb1.png"))) {
						img = getImg("/Irudiak/bomb2.png");
					}else {
						img = getImg("/Irudiak/whitewithbomb2.png");}
			}else if(i==1) {
					if(!(img==getImg("/Irudiak/whitewithbomb2.png"))) {
						img = getImg("/Irudiak/bomb3.png");
					}else {
						img = getImg("/Irudiak/whitewithbomb3.png");}
				
			}
			repaint();}
		/*public void bombaKendu(){
			//setOpaque(false);
			//this.setBackground(SystemColor.activeCaption);
		}*/
		public void suaKendu() {
			img = null;
			repaint();
			sua = false;
			bomba = false;
			//setOpaque(false);
			//this.setBackground(SystemColor.activeCaption);
		}
		public Image getImg(String pArgazkia) {
			URL imageUrl = getClass().getResource(pArgazkia);
			Image img2 = Toolkit.getDefaultToolkit().getImage(imageUrl);
			return img2;
		}
		
		public void suaJarri() {
			Matrize_Bista.SoundPlayer.playSound("/soinuak/BombExplodes.wav");
			URL imageUrl = getClass().getResource("/Irudiak/kabomb5.png");
			img = Toolkit.getDefaultToolkit().getImage(imageUrl); 
			repaint();
			sua = true;
			//setOpaque(true);
		}
		 @Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        
		        // Draw the image if it's loaded
		        if (img != null) {
		        	// Obtén el tamaño del JPanel
		            int panelWidth = getWidth();
		            int panelHeight = getHeight();
		                g.drawImage(img, 0, 0, getWidth(), getHeight(), this); // Dibujar la imagen
		            
		            
		        }
		    }
		/*public void norabideBomberman() {
		}*/
	}
