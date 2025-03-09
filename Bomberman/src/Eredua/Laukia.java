package Eredua;

import Bista.Laukia_Bista;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Laukia extends Observable {
	private int x;
	private int y;
	private Bloke bloke=null;
	private Bomba bomba=null;
	private Sua sua=null;
	/*private Timer timer=null;
	private int kont=3;*/
	
	public Laukia(int pX, int pY) {
		this.x=pX;
		this.y=pY;
	}

	public int getKoordenatuX() {
		return this.x;
	}
	
	public int getKoordenatuY() {
		return this.y;
	}
	
	public Sua getSua() {
		return this.sua;
	}
	
	public Bloke getBloke() {
		return this.bloke;
	}
	public Bomba getBomba() {
		return this.bomba;
	}
	public boolean hutsaDa() {
		if (this.bloke==null&&this.bomba==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void blokeGogorraGehitu() {
		bloke=new BlokeGogorra();
	}
	public void blokeBigunaGehitu() {
		bloke=new BlokeBiguna();
	}
	public void bombaJarri() {
		bomba=new Bomba(x, y);
		bomba.addObserver(Bista.Matrize_Bista.getNireMatrizea().bilatuLaukia(x, y));
		setChanged();
		notifyObservers("BombaJarri");	
	}
	public void bombaKendu() {
		this.bomba=null;
		
		//setChanged();
		//notifyObservers("BombaKendu");
	}
	public void suaJarri() {
		if (this.sua!=null) {
			this.sua=null;
		}
		this.sua=new Sua(x,y);
		if(this.bloke instanceof BlokeBiguna || this.bloke==null) {
			this.bloke=null;
			if (this.bomba!=null) {
				this.bomba.setKont(1);
			}
			setChanged();
			notifyObservers("SuaJarri");}}
			
	public void suaKendu() {
		if (this.sua!=null && (this.bloke instanceof BlokeBiguna || this.bloke==null)&&this.sua.biSegundoPasa()==true) {
			this.sua=null;
			setChanged();
			notifyObservers("SuaKendu");
			System.out.println("Sua kendu da");
		}
	}
	
}
