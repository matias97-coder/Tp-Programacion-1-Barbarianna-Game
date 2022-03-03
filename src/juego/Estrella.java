package juego;

import entorno.Entorno;

	import java.awt.Image;

	import entorno.Herramientas;
	
public class Estrella {
	
		private int x;
		private int y;
		private Image imagen;
		private int ancho, alto;
		
		public Estrella(int x, int y){
			this.x = x;
			this.y = y;
			this.ancho=20;
			this.alto=30;
			this.imagen = Herramientas.cargarImagen("images/star.png");
		}
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
		public int getAncho() {
			return ancho;
		}

		public int getAlto() {
			return alto;
		}
		
		public void dibujarse(Entorno entorno) {
			entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.10);
		}

		
		}
	

