package juego;
import java.awt.Color;

import entorno.Entorno;
public class Piso {
	
	private int x, y;
	private int ancho, alto;
	
	public Piso(int x, int y) {
		this.x =x ;
		this.y = y;
		this.ancho = 600;
		this.alto = 8;
	}
	
	   public int getX(){
	        return x;
	    }
	    public int getY(){
	        return y;
	    }
	    public int getAncho(){
	        return ancho;
	    }
	    public int getAlto(){
	        return alto;
	    }
	    
	    public void dibujarPiso(Entorno entorno) {
			entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0,Color.ORANGE);
	    }
	    
	   
	    
	    
}
