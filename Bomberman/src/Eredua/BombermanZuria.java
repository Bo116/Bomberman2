package Eredua;
import java.util.Timer;
import java.util.TimerTask;

public class BombermanZuria extends Bomberman{
	
	private int kont=0;
	

	public BombermanZuria() {
		super();
		this.bombaKop=10;
	}
	
	public void bombermanHil() {
		
	}
	
	@Override  
	public void bombaJarri() {
		if (MatrizeClassic.getNireMatrizea().bilatuLaukia(this.getX(), this.getY()).getBomba() == null && bombaKop > 0) {
			bombaKop--;
			MatrizeClassic.getNireMatrizea().bilatuLaukia(this.getX(), this.getY()).bombaJarri();
			setChanged();
			notifyObservers(new Object[]{"BombaJarri",this.getX(),this.getY()});	
			}	
		}
	}  

