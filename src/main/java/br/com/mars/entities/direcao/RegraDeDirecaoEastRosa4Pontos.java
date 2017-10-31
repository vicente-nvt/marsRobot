package br.com.mars.entities.direcao;

public class RegraDeDirecaoEastRosa4Pontos implements IRegraDeDirecao{

	@Override
	public Direcao getPosicaoDaDireita() {
		return Direcao.SOUTH;
	}

	@Override
	public Direcao getPosicaoDaEsquerda() {
		return Direcao.NORTH;
	}

}
