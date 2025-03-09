package Eredua;

import java.util.Timer;
import java.util.TimerTask;

public class Sua {
	private int x;
	private int y;
	private Timer timer=null;
	private int kont=3;
	private boolean biSegundoPasa=false;
	
	public Sua(int pX, int pY) {
		this.x=pX;
		this.y=pY;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				updateKont();
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	private void updateKont() {
		kont--;
		System.out.println("sua"+kont);
		if(kont==0) {
			MatrizeClassic.getNireMatrizea().suaKendu(x,y);
		}
		}
	
	public boolean biSegundoPasa() {
		if (this.kont<=0) {
			timer.cancel();
			this.biSegundoPasa=true;
		}
		return biSegundoPasa;
		}
	}

