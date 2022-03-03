package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Dinosaurio {
	private int x;
	private int y;
	private Image imagen;
	private String direccion;
	private Laser poder;
	private int ancho, alto;

	
	
	public Dinosaurio(int x, int y) {
		this.x = x;
		this.y = y;
		this.ancho=30;
		this.alto=60;
		this.poder = null;
		this.imagen = Herramientas.cargarImagen("images/dino_izq.png");
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Laser getLaser() {
		return poder;
	}

	void setLaser(Laser laser) {
		this.poder = laser;
	}

	void moverIzquierda() {
		this.x = this.x - 3;
		this.imagen= Herramientas.cargarImagen("images/dino_izq.png");
		this.direccion = "izquierda";
		
	}

	void moverDerecha() {
		this.x = this.x + 3;
		this.imagen= Herramientas.cargarImagen("images/dino_der.png");
		this.direccion = "derecha";
		
	}
	
	void caminar() {
		if (this.direccion == "izquierda") 
			moverIzquierda();
			
		if (this.direccion == "derecha")
			moverDerecha();
		}

	
	public boolean enElSuelo() { // Chequea si barbarianna esta tocando alguno de los niveles (VER EJE DE Y) En el eje x sólo toma las partes amarillas.
		if ((this.y == 120 - this.getAlto()/2 && this.getX() + this.getAncho()/2>200)|| 
				(this.y == 240 - this.getAlto()/2 && this.getX() -this.getAncho()/2<600) || 
				(this.y == 360 - this.getAlto()/2 && this.getX() +this.getAncho()/2>200)||
				(this.y == 480 - this.getAlto()/2 && this.getX() -this.getAncho()/2<600)|| this.y == 570)
			return true;
		return false;
	}

	void caida() { // Si el objeto esta en el suelo.
		if (enElSuelo() == false)
		this.y = getY()+ 2;
	}
	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.2); // 0.1= tamaño de la imagen
		//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GREEN);
		
	}
	
	public void crearLaser(Entorno entorno) {
			
			if (this.direccion == null) return;
			this.poder = new Laser(this.x, this.y, direccion);
		}
	
	

	public void efectuarLaser(Entorno entorno) {
		
		this.poder.dibujarse(entorno);
		
		switch (this.poder.getDireccion()) {
		
		case "derecha":
			this.poder.moverDerecha();
			break;
			
		case "izquierda":
			this.poder.moverIzquierda();
			break;
		}
		
		// Cuando el rayo toque algun borde vuelvo el objeto rayo a null 
	
		if (this.poder.getX() <= 0 || this.poder.getX() >= entorno.ancho()  ) {	
			this.poder = null;
		}
	}
	
	 //1
	 public boolean choqueRayoDino(Rayo rayo) {//colision entre reyo de barbariana y los dinos
	    	
		 if (rayo == null) 
	    		return false;
	    	
	    	if(Math.abs(this.x-rayo.getX())<=15 && Math.abs(this.y-rayo.getY())<=27){
		        return true;
		    }
	    	
	    	return false;
	    }
	 
	 
	 
		//2
	 public boolean choqueBarbariannaDino(Barbarianna barb) {//colision entre los personajes 
		 if (barb != null) 
	    	if(Math.abs(this.x-barb.getX())<=25 && Math.abs(this.y-barb.getY())<=27){
		        return true;
		    }
	    return false;
	    
	    }

	 
	 
	 
	
	
}
