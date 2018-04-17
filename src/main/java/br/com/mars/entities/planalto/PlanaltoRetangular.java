package br.com.mars.entities.planalto;

public class PlanaltoRetangular implements IPlanalto {

	private int x;
	private int y;
		
	public PlanaltoRetangular(int x, int y) {
		this.x = x - 1;
		this.y = y - 1;
	}
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public int getY() {
		return y;
	}

	@Override
	public boolean validarDimensoesDoPlanalto(int x, int y) {
		return getX() > 0 && getY() > 0;
	}
	
	public boolean equals(PlanaltoRetangular planalto){
	
		return (planalto.getX() == this.getX()) && 
			   (planalto.getY() == this.getY());
	}


}
