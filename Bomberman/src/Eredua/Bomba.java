package Eredua;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Bomba extends Observable {
	private int x;
	private int y;
	private int kont = 30;
	private Timer timer=null;
	
	public Bomba(int pX, int pY) {
		this.x=pX;
		this.y=pY;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				updateKont();
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 100);
	}
	private void updateKont() {
		kont--;
		System.out.println("Kont: "+kont);
		if (kont==20) {
			setChanged();
			notifyObservers("Bomba2");
		}
		else if (kont==10) {
			setChanged();
			notifyObservers("Bomba1");
		}
		else if (kont == 0) {
			MatrizeClassic.getNireMatrizea().bombaKendu(x, y);
			
			//kont=4; // 3, 2, 1, explota
			timer.cancel();
		}
		
		}
	public void setKont(int pKont) {
		this.kont=pKont;}
	
	}


