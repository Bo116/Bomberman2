package Eredua;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Bomberman extends Observable {
	private int x;
	private int y;
	private boolean bizirik;
	private Timer timer=null;
	protected int bombaKop;
	private int kontSua=20;
	private int kontBomba=30;
	
	
	//eraikitzailea
	public Bomberman() {
		this.x = 0;
		this.y = 0;
		this.bizirik = true;
		addObserver(Bista.Matrize_Bista.getNireMatrizea());
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
		if(MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x,this.y).getSua() instanceof Sua) {
        	this.bombermanHil();
        	
		}
		//System.out.println("Kont: "+kontSua);
		if(bombaKop == 0) {
			System.out.println("Bomba kopurua agortu da");
			kontBomba--;
			if (kontBomba == 0) {
				System.out.println("Bomba kopurua gehi bat");
				kontBomba = 30;
				bombaKop++;
			}
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	private void bombermanHil(){
		MatrizeClassic.getNireMatrizea().amaituJokua();
	}
	
	public void mugitu(char norabide) {

	    if ((norabide == 'A' && this.y > 0)&&
	    ((MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x,this.y-1).getBloke() == null)
	    &&MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x,this.y-1).getBomba()==null)) {
	       
	        this.y--;
	        setChanged();
	        notifyObservers(new Object[]{"MoveA",x,y,norabide});
	        //System.out.println("MugituBomberman");
	    }
	    if ((norabide == 'D' && this.y < 16)&&
		((MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x,this.y+1).getBloke() ==null) 
		&&MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x,this.y+1).getBomba()==null)) {
	        
	    	this.y++;
	        setChanged();
	        notifyObservers(new Object[]{"MoveD",x,y,norabide});
	        //System.out.println("MugituBomberman");
	    }
	    if ((norabide == 'W' && this.x > 0)&&
		((MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x-1,this.y).getBloke()==null)
		&&MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x-1,this.y).getBomba()==null)) {
	    		
	    	this.x--;
	        setChanged();
	        notifyObservers(new Object[]{"MoveW",x,y,norabide});
	       // System.out.println("MugituBomberman");
	    }
	    if ((norabide == 'S' && this.x < 10)&&
		((MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x+1,this.y).getBloke()==null)
		&&MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x+1,this.y).getBomba()==null)) {
	    	
	    	this.x++;
	        setChanged();
	        notifyObservers(new Object[]{"MoveS",x,y,norabide});
	        //System.out.println("MugituBomberman" + x + ", "  + y);
	    }
	    else {
	    	setChanged();
	    	notifyObservers(norabide);
	    }
	    

	}

	public abstract void bombaJarri() ;

	
}
