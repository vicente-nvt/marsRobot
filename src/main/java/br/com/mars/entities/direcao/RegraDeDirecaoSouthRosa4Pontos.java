package br.com.mars.entities.direcao;

public class RegraDeDirecaoSouthRosa4Pontos implements IRegraDeDirecao{

	@Override
	public Direcao getPosicaoDaDireita() {
		return Direcao.WEST;
	}

	@Override
	public Direcao getPosicaoDaEsquerda() {
		return Direcao.EAST;
	}

}
