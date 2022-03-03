package juego;
import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
//import java.awt.Image;

import entorno.Entorno;

public class Laser {
	private int x;
    private int y;
    private Image imagen;
    private double diametro;
    private String direccion;

    public Laser(int x, int y, String direccion) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        this.imagen = Herramientas.cargarImagen("images/laser.png");
        this.diametro = 11;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public String getDireccion() {
        return direccion;
    }

    void moverIzquierda() {
        this.x = this.x - 5;
    }

    void moverDerecha() {
        this.x = this.x + 5;
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.3);
    	//entorno.dibujarCirculo(this.x, this.y, this.diametro, Color.red);
}
}

