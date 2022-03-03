package juego;
import entorno.Entorno;

import java.awt.Color;
import java.awt.Image;

import entorno.Herramientas;

public class Barbarianna {
	private int x;
	private int y;
	private Image imagen;
	private String direccion;
	private Rayo poder;
	private int ancho, alto;
	
	
	
	public Barbarianna(int x, int y) {
		this.x = x;
		this.y = y;
		this.ancho=30;
		this.alto=60;
		this.poder = null;
		this.imagen = Herramientas.cargarImagen("images/barb_izq.png");
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rayo getRayo() {
		return poder;
	}

	void setRayo(Rayo rayo) {
		this.poder = rayo;
	}

	void moverIzquierda() {
		this.x = this.x - 4;
		this.imagen = Herramientas.cargarImagen("images/barb_izq.png");
		this.direccion = "izquierda";		
	}

	void moverDerecha() {
		this.x = this.x + 4;
		this.imagen = Herramientas.cargarImagen("images/barb_der.png");
		this.direccion = "derecha";		
	}
	
	public boolean enElSuelo() { // Chequea si barbarianna esta tocando alguno de los niveles (VER EJE DE Y) En el eje x sólo toma las partes amarillas.
		if 		((this.getY() ==90 && this.getX() + this.getAncho()/2>200)|| 
				(this.getY() == 210 && this.getX() -this.getAncho()/2<600) || 
				(this.getY() == 330  && this.getX() +this.getAncho()/2>200)||	//
				(this.getY() == 450 && this.getX() -this.getAncho()/2<600)  || //1
				(this.getY() == 570 ))
				
			return true;
		
		return false;
	}

	void caida() { // Si el objeto esta en el suelo.
		if (enElSuelo() == false)
		this.y = getY()+ 2;
	}

	// CONTROLAR EL EJE DE Y PARA QUE SE AGACHE BIEN Y NO SE RECORTE EL ALTO.
	
	/*void agacharse() {	// Para que no se siga agachando hasta desaparecer.
			if (enElSuelo())
	
				this.alto =30;
				this.y+=10;
		
		}
	

	void pararse() {	
		if (this.alto <=40 ) // Para que no se pare y crezca demasiado.
		this.alto =60;
		
	
		
	}*/

	void saltar() { 
		if (enElSuelo() == true) // Si esta tocando el suelo, puede saltar.
		this.y = getY()-70;
	}

	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.26); // 0.1= tamaño de la imagen
		//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.pink);
	}
	
	public void crearRayo(Entorno entorno) {
			
			if (this.direccion == null) return;
			
			this.poder = new Rayo(this.x, this.y,this.direccion);
		}
	

	public void efectuarRayo(Entorno entorno) {
		
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
	
	void subirPiso() {
		if(enElSuelo() && this.getX()>600) {
			this.y =getY() -160;
			this.x =580;
		}
		else {
			if(enElSuelo() && this.getX()<200 && this.getY()<500) {
				this.y=getY()-160;
				this.x=220;
			}
		}
	}
	

	
}
