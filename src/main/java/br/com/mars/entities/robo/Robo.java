package br.com.mars.entities.robo;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.planalto.IPlanalto;

public class Robo {

	private int x;
	private int y;
	private Direcao direcao;
	private IPlanalto planalto;
	
	public Robo (IPlanalto planalto, int posicaoInicialEmX, int posicaoInicialEmY, Direcao direcao){
		this.planalto = planalto;
		this.x = posicaoInicialEmX;
		this.y = posicaoInicialEmY;
		this.direcao = direcao;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public IPlanalto getPlanalto() {
		return planalto;
	}	
	
	public boolean equals (Robo robo){
		return robo.getX() == this.getX() &&
			   robo.getY() == this.getY() &&
			   robo.getPlanalto() == this.getPlanalto() &&
			   robo.getDirecao() == this.getDirecao();
	}
}

