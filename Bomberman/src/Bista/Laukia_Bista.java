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
		private static int w,s,d,a=1;
	
		private static final long serialVersionUID = 1L;
		
		public Laukia_Bista(int pX, int pY,boolean pEgoera) {		
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
		}
		public void bombermanAldatu(String pNorabide) {
			if (bomba==false) {
				if (pNorabide.equals("W")) {
					if(w==1) {
						a=1;
						s=1;
						d=1;
						img = getImg("/Irudiak/whiteup1.png");
						w++;	}
					else if(w==2) {
						img = getImg("/Irudiak/whiteup2.png");
						w++;	}
					else if(w==3) {
						img = getImg("/Irudiak/whiteup3.png");
						w++;	}
					else if(w==4) {
						img = getImg("/Irudiak/whiteup4.png");
						w++;	}
					else if(w==5) {
						img = getImg("/Irudiak/whiteup5.png");
						w=1;	}
					else {
						w=1;
						
					}
					}
				
				else if (pNorabide.equals("S")) {
					if(s==1) {
						a=1;
						w=1;
						d=1;
						img = getImg("/Irudiak/whitedown1.png");
						s++;	}
					else if(s==2) {
						img = getImg("/Irudiak/whitedown2.png");
						s++;	}
					else if(s==3) {
						img = getImg("/Irudiak/whitedown3.png");
						s++;	}
					else{
						img = getImg("/Irudiak/whitedown4.png");
						s=1;	}
				}
				else if (pNorabide.equals("D")) {
					if(d==1) {
						a=1;
						w=1;
						s=1;
						img = getImg("/Irudiak/whiteright1.png");
						d++;	}
					else if(d==2) {
						img = getImg("/Irudiak/whiteright2.png");
						d++;	}
					else if(d==3) {
						img = getImg("/Irudiak/whiteright3.png");
						d++;	}
					else if(d==4) {
						img = getImg("/Irudiak/whiteright4.png");
						d++;	}
					else if(d==5) {
						img = getImg("/Irudiak/whiteright5.png");
						d=1;}
					else {
						d=1;}
					}
				
				else if (pNorabide.equals("A")) {
					if(a==1) {
						w=1;
						s=1;
						d=1;
						img = getImg("/Irudiak/whiteleft1.png");
						a++;	}
					else if(a==2) {
						img = getImg("/Irudiak/whiteleft2.png");
						a++;	}
					else if(a==3) {
						img = getImg("/Irudiak/whiteleft3.png");
						a++;	}
					else if(a==4) {
						img = getImg("/Irudiak/whiteleft4.png");
						a++;	}
					else if(a==5) {
						img = getImg("/Irudiak/whiteleft5.png");
						a=1;	}
					else {
						a=1;
					}
					}}
			 
			repaint();
			}		
		public void bombermanKendu(){
			if (bomba==false) {
				img= null;
			}
			else if(img==getImg("/Irudiak/whitewithbomb2.png")) {
				img = getImg("/Irudiak/bomb2.png");
			    
			}
			else if(img==getImg("/Irudiak/whitewithbomb3.png")) {
				img = getImg("/Irudiak/bomb3.png");
			    
			}
			else if (sua==false && bomba==true) {
				img = getImg("/Irudiak/bomb1.png");
			}
			bomberman = false;
			repaint(); 
		}
		public void bombaJarri(){
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
		public void suaKendu() {
			img = null;
			repaint();
			sua = false;
			bomba = false;
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
		}
		 @Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        if (img != null) {
		        	
		            int panelWidth = getWidth();
		            int panelHeight = getHeight();
		                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);        
		        }     
		    }
	}
