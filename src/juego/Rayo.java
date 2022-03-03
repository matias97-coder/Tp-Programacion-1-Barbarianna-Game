package juego;
import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
public class Rayo {
	private int x;
    private int y;
    private String direccion;
    private Image imagen;
    private double diametro;

    public Rayo(int x, int y, String direccion) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        this.imagen = Herramientas.cargarImagen("images/rayo.png");
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
        this.x = this.x - 8;
    }

    void moverDerecha() {
        this.x = this.x + 8;
    }


    public void dibujarse(Entorno entorno) {
       entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.3);
    	//entorno.dibujarCirculo(this.x, this.y, this.diametro, Color.YELLOW);
}

}