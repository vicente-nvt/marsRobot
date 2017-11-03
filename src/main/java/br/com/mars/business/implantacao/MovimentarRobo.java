package br.com.mars.business.implantacao;

import br.com.mars.entities.robo.Robo;

public class MovimentarRobo {

	private Robo robo;
	private String movimento;
	
	public MovimentarRobo(Robo robo, String movimento){
		this.robo = robo;
		this.movimento = movimento;
	}
	
	public boolean movimentar() {
		
		char[] movimentos = this.movimento.toCharArray();
		
		for (char acao: movimentos){
			
			switch (acao){
				case 'L': 
					robo.setDirecao(robo.getDirecao().getRegra().getPosicaoDaEsquerda());
					break;
				case 'R':
					robo.setDirecao(robo.getDirecao().getRegra().getPosicaoDaDireita());
					break;
				case 'M':
					if (!robo.getPlanalto().moverNoPlanalto(robo)) 
						return false;					
			}
		}
		return true;
	}
}
