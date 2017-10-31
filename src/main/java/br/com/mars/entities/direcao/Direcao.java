package br.com.mars.entities.direcao;

public enum Direcao {
	NORTH (new RegraDeDirecaoNorthRosa4Pontos()),
	SOUTH (new RegraDeDirecaoSouthRosa4Pontos()),
	WEST (new RegraDeDirecaoWestRosa4Pontos()),
	EAST (new RegraDeDirecaoEastRosa4Pontos());

	private final IRegraDeDirecao regraDeDirecao;
		
	private Direcao(IRegraDeDirecao regra){
		this.regraDeDirecao = regra;
	}
	
	public IRegraDeDirecao getRegra(){
		return this.regraDeDirecao;
	}	
	
	
}
