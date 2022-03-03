package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Computadora {
	private int x;
    private float y;
    private int ancho, alto;
    private Image imagen;
    
    public Computadora(int x, float y) {
        this.x = x;
        this.y = y;
        this.imagen = Herramientas.cargarImagen("images/compu.png");
        this.ancho=35;
        this.alto=35;
        
    }

    public int getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.12); // 0.1= tamaño de la imagen
		//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.gray);
	}
	
	public boolean estaEnPosY () {
			
			if (this.getY()>=93)
				return true;
			
			return false;
			
		}
	
	void saltar() { 
		if (estaEnPosY() == true) // Si esta tocando el suelo, puede saltar.
		this.y =(float) getY()-10;
	}
	
	void caida() { // Si el objeto esta en el suelo.
		if (estaEnPosY() == false)
		this.y = (float) (getY()+ 0.27);
	}
	
	

}
