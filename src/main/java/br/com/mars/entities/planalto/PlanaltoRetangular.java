package br.com.mars.entities.planalto;

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
		
		switch (robo.getDirecao()){
			case NORTH:
				return moveRoboParaNorth(robo);
			case EAST:
				return moveRoboParaEast(robo);
			case SOUTH:
				return moveRoboParaSouth(robo);
			case WEST:
				return moveRoboParaWest(robo);
			default: return false;
		}				
	}
		
	private boolean moveRoboParaNorth (Robo robo){
		if (robo.getY() < this.getY()){
			robo.setY(robo.getY() + 1);
			return true;
		}

		return false;		
	}
	
	private boolean moveRoboParaSouth (Robo robo){
		if (robo.getY() > 0){
			robo.setY(robo.getY() - 1);
			return true;
		}

		return false;
	}
	
	private boolean moveRoboParaEast (Robo robo){
		if (robo.getX() < this.getX()){
			robo.setX(robo.getX() + 1);
			return true;
		}
		
		return false;		
	}
	
	private boolean moveRoboParaWest (Robo robo){
		if (robo.getX() > 0){
			robo.setX(robo.getX() - 1);
			return true;
		}
		
		return false;
	}
		
	public static boolean validarDimensoesPlanalto(int x, int y){
		return x > 0 && y > 0;
	}
}
