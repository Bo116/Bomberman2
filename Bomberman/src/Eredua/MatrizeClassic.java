package Eredua;
import java.util.Random;

import Bista.Matrize_Bista;

import java.util.Observable;
import java.util.Observer;
import java.awt.EventQueue;
public class MatrizeClassic extends Matrizea {
	private static MatrizeClassic nireMatrizea;
	
	private MatrizeClassic() {
		super();
		addObserver(Matrize_Bista.getNireMatrizea());
		
	}

	public static MatrizeClassic getNireMatrizea(){
		if(nireMatrizea==null) {
			nireMatrizea=new MatrizeClassic();
		}
		return nireMatrizea;
	}
	
	@Override
	public void matrizeaOsatu() {
		Laukia[][] matrizea = this.getMatrix();
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				Laukia unekoaLaukia = matrizea[i][j];
				unekoaLaukia.addObserver(Matrize_Bista.getNireMatrizea().bilatuLaukia(i, j));
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {}
				else if (1 == (i % 2) && 1 == (j % 2)) {
					unekoaLaukia.blokeGogorraGehitu();
					setChanged();
					notifyObservers(new Object[]{"Bloke gogorra gehitu da",i,j});
					//bloke gogorra da*/
				}
				else if(Math.random() >= 0.4) {
					//sortu bloke biguna
					unekoaLaukia.blokeBigunaGehitu();
					setChanged();
					notifyObservers(new Object[]{"Bloke biguna gehitu da", i, j});
				}
				
			}
		}
	}

	
}
