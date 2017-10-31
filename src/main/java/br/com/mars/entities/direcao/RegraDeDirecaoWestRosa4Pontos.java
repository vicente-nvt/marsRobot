package br.com.mars.entities.direcao;

public class RegraDeDirecaoWestRosa4Pontos implements IRegraDeDirecao{

	@Override
	public Direcao getPosicaoDaDireita() {
		return Direcao.NORTH;
	}

	@Override
	public Direcao getPosicaoDaEsquerda() {
		return Direcao.SOUTH;
	}
	
}
