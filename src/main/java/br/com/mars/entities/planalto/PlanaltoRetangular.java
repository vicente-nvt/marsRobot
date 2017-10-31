package br.com.mars.entities.planalto;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.robo.Robo;

public class PlanaltoRetangular implements IPlanalto {

	private int x;
	private int y;
		
	public PlanaltoRetangular(int x, int y) {
		this.x = x - 1;
		this.y = y - 1;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean equals(PlanaltoRetangular planalto){
				
		return (planalto.getX() == this.getX()) && 
			   (planalto.getY() == this.getY());
	}

	@Override
	public boolean moverNoPlanalto(Robo robo) {
		
		if (robo.getDirecao() == Direcao.NORTH){
			if (robo.getY() < this.getY())
				robo.setY(robo.getY() + 1);
			else
				return false;
			
		}			
		else if (robo.getDirecao() == Direcao.SOUTH){
			if (robo.getY() > 0)
				robo.setY(robo.getY() - 1);
			else
				return false;
			
		}			
		else if (robo.getDirecao() == Direcao.EAST){
			if (robo.getX() < this.getX())
				robo.setX(robo.getX() + 1);
			else
				return false;
		}			
		else if (robo.getDirecao() == Direcao.WEST){
			if (robo.getX() > 0)
				robo.setX(robo.getX() - 1);
			else
				return false;			
		}		
		
		return true;
	}
	
	public static boolean validarDimensoesPlanalto(int x, int y){
		return x > 0 && y > 0;
	}
}
