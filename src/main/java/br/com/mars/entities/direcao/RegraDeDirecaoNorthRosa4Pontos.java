package br.com.mars.entities.direcao;

public class RegraDeDirecaoNorthRosa4Pontos implements IRegraDeDirecao {

	@Override
	public Direcao getPosicaoDaDireita() {
		return Direcao.EAST;
	}

	@Override
	public Direcao getPosicaoDaEsquerda() {
		return Direcao.WEST;
	}
}
