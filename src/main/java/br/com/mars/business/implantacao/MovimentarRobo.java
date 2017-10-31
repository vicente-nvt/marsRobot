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
		
		for (int i = 0; i < movimento.length(); i++){
			
			if (movimento.charAt(i) == 'L')
				robo.setDirecao(robo.getDirecao().getRegra().getPosicaoDaEsquerda());
			else if (movimento.charAt(i) == 'R')
				robo.setDirecao(robo.getDirecao().getRegra().getPosicaoDaDireita());
			else if (movimento.charAt(i) == 'M'){
				if (!robo.getPlanalto().moverNoPlanalto(robo)) 
					return false;					
			}
		}
		return true;
	}
}
