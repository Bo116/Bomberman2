package Eredua;

import Bista.Laukia_Bista;

import Bista.Matrize_Bista;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.EventQueue;
import java.util.Observable;


public abstract class Matrizea extends Observable{
	private static Matrizea nireMatrizea;
	private static Laukia[][] matrix;
	protected static int errenkada = 11;
	protected static int zutabea = 17;
	protected static Bomberman bomberman;
	//private laukiZerrenda Iterator<Laukia>;
		
		//eraiki classic
		
		//eraiki soft
		
		//eraiki empty
	public Matrizea() {
		this.matrix=null;
		addObserver(Matrize_Bista.getNireMatrizea());
	}
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Teklatua teklatua = Teklatua.getNireTeklatua();
                	Matrize_Bista frame = Matrize_Bista.getNireMatrizea();
                    MatrizeClassic matrizeKlasikoa = MatrizeClassic.getNireMatrizea();
                    matrizeKlasikoa.matrizeaOrokorraSortu();
                    matrizeKlasikoa.matrizeaOsatu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });}
	
	@SuppressWarnings("deprecation")
	public  void matrizeaOrokorraSortu() {
		matrix = new Laukia[errenkada][zutabea];
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				matrix[i][j]= new Laukia(i,j);
				//Bista.Matrize_Bista.gehituLaukia(new Bista.Laukia_Bista(i, j, false));
			}
			
		}
		this.bomberman=new BombermanZuria();
		setChanged();
		notifyObservers("Matrizea sortu da");
		
	}
	public abstract void matrizeaOsatu();
	
	public Laukia bilatuLaukia(int x, int y) {
		return matrix[x][y];
	}

	public Laukia[][] getMatrix() { return matrix; }

	
	public void mugituBomberman(char pKey) {
			bomberman.mugitu(pKey);
			//System.out.println("MugituBombermanMatrizea");
	}
	public Bomberman getBomberman() {
		return bomberman;
	}
	
	public void bombaKendu(int pX, int pY) {
		this.bilatuLaukia(pX, pY).bombaKendu();
		int[][] norabideak = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		  // Bombaren koordenatua

		for (int[] norabidea : norabideak) {
		    int berriaX = pX + norabidea[0];
		    int berriaY = pY + norabidea[1];
		    
		    if (berriaX>=0 && berriaX<=10 && berriaY>=0 && berriaY<=16)
		    this.bilatuLaukia(berriaX, berriaY).suaJarri();
		}
		 this.bilatuLaukia(pX,pY).suaJarri();
		 

		
	}
	
		
	
	public void suaKendu(int pX, int pY) {
		this.bilatuLaukia(pX, pY).suaKendu();
		int[][] norabideak = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		  // Bombaren koordenatua

		for (int[] norabidea : norabideak) {
		    int berriaX = pX + norabidea[0];
		    int berriaY = pY + norabidea[1];
		    
		    if (berriaX>=0 && berriaX<=10 && berriaY>=0 && berriaY<=16) {
		    this.bilatuLaukia(berriaX, berriaY).suaKendu();}
		}
		 this.bilatuLaukia(pX,pY).suaKendu();
	}
	
	
	public void amaituJokua() {
		setChanged();
		notifyObservers("Jokua amaitu da");
		
	}
	
}
