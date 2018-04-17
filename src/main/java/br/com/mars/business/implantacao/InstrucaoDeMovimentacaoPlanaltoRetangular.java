package br.com.mars.business.implantacao;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.implantacao.IInstrucaoDeMovimentacao;
import br.com.mars.entities.planalto.IPlanalto;

public class InstrucaoDeMovimentacaoPlanaltoRetangular implements IInstrucaoDeMovimentacao {
		
	private IPlanalto planalto;
	private int x, y;

	public InstrucaoDeMovimentacaoPlanaltoRetangular(IPlanalto planalto){
		this.planalto = planalto;
	}
		
	@Override
	public boolean moverNoPlanalto(Direcao direcao, int x, int y) {
		
		setX(x);
		setY(y);
		
		switch (direcao){
			case NORTH:
				return moveParaNorth();
			case EAST:
				return moveParaEast();
			case SOUTH:
				return moveParaSouth();
			case WEST:
				return moveParaWest();
			default: return false;
		}				
	}
		
	private boolean moveParaNorth (){
		if (getY() < this.planalto.getY()){
			setY(getY() + 1);
			return true;
		}

		return false;		
	}
	
	private boolean moveParaSouth (){
		if (getY() > 0){
			setY(getY() - 1);
			return true;
		}

		return false;
	}
	
	private boolean moveParaEast (){
		if (getX() < this.planalto.getX()){
			setX(getX() + 1);
			return true;
		}
		
		return false;		
	}
	
	private boolean moveParaWest (){
		if (getX() > 0){
			setX(getX() - 1);
			return true;
		}
		
		return false;
	}

	@Override
	public IPlanalto getPlanalto() {
		return this.planalto;	
	}

	@Override
	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}
}
