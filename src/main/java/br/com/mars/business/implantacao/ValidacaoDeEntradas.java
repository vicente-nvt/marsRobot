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
	
	public ValidacaoDeEntradas(){};	
	
	public ValidacaoDeEntradas(String comandoDeDimensaoDoPlanalto,
							 String comandoDePosicaoDoRobo,
							 String comandoDeMovimentoDoRobo){
		
		this.setComandoDeDimensaoDoPlanalto(comandoDeDimensaoDoPlanalto);
		this.setComandoDePosicaoDoRobo(comandoDePosicaoDoRobo);
		this.setComandoDeMovimentoDoRobo(comandoDeMovimentoDoRobo);
	}
	
	@Override
	public boolean validarDimensaoDoPlanalto() {
		
		String[] dimensoes = getComandoDeDimensaoDoPlanalto().split(",");
		
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
		
		String[] posicaoDoRobo = getComandoDePosicaoDoRobo().split(",");
		
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
		
		return getComandoDeMovimentoDoRobo().matches("[RLM]+");		
		
	}
	
	public String getComandoDeDimensaoDoPlanalto() {
		return comandoDeDimensaoDoPlanalto;
	}

	public void setComandoDeDimensaoDoPlanalto(String comandoDeDimensaoDoPlanalto) {
		this.comandoDeDimensaoDoPlanalto = comandoDeDimensaoDoPlanalto;
	}

	public String getComandoDePosicaoDoRobo() {
		return comandoDePosicaoDoRobo;
	}

	public void setComandoDePosicaoDoRobo(String comandoDePosicaoDoRobo) {
		this.comandoDePosicaoDoRobo = comandoDePosicaoDoRobo;
	}

	public String getComandoDeMovimentoDoRobo() {
		return comandoDeMovimentoDoRobo;
	}

	public void setComandoDeMovimentoDoRobo(String comandoDeMovimentoDoRobo) {
		this.comandoDeMovimentoDoRobo = comandoDeMovimentoDoRobo;
	}

	public void setDimensaoDoPlanalto(int x, int y) {
		xPlanalto = x;
		yPlanalto = y;		
	}

}