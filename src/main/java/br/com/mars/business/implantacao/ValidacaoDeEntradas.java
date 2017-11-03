package br.com.mars.business.implantacao;

import br.com.mars.entities.implantacao.IValidacaoDeEntradas;

public class ValidacaoDeEntradas implements IValidacaoDeEntradas {

	private String comandoDeDimensaoDoPlanalto;
	private String comandoDePosicaoDoRobo;
	private String comandoDeMovimentoDoRobo;
	
	private int xPlanalto;
	private int yPlanalto;
	private int xRobo;
	private int yRobo;	
	
	public ValidacaoDeEntradas(String comandoDeDimensaoDoPlanalto,
							 String comandoDePosicaoDoRobo,
							 String comandoDeMovimentoDoRobo){
		
		this.comandoDeDimensaoDoPlanalto = comandoDeDimensaoDoPlanalto;
		this.comandoDePosicaoDoRobo = comandoDePosicaoDoRobo;
		this.comandoDeMovimentoDoRobo = comandoDeMovimentoDoRobo;
	}
	
	@Override
	public boolean validarDimensaoDoPlanalto() {
		
		String[] dimensoes = comandoDeDimensaoDoPlanalto.split(",");
		
		if (dimensoes.length != 2)  
			return false;
					
		try {
			xPlanalto = Integer.parseInt(dimensoes[0]);
			yPlanalto = Integer.parseInt(dimensoes[1]);
		} catch (Exception e) {
			return false;
		}
		
		return (xPlanalto > 0) && (yPlanalto > 0);			
		
	}

	@Override
	public boolean validarPosicaoDoRobo() {
		
		String[] posicaoDoRobo = comandoDePosicaoDoRobo.split(",");
		
		if (posicaoDoRobo.length != 3)
			return false;
	
		try {
			xRobo = Integer.parseInt(posicaoDoRobo[0]);
			yRobo = Integer.parseInt(posicaoDoRobo[1]);
		} catch (Exception e) {
			return false;
		}
		
		if (new MapaDeDirecao().getDirecao(posicaoDoRobo[2]) == null)
			return false;
		
		return (xRobo >= 0) && (yRobo >= 0) && (xRobo <= xPlanalto) && (yRobo <= yPlanalto);
	}

	@Override
	public boolean validarMovimentoDoRobo() {
		
		return comandoDeMovimentoDoRobo.matches("[RLM]+");		
		
	}

}