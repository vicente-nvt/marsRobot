package br.com.mars.entities.robo;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.implantacao.IInstrucaoDeMovimentacao;

public class Robo {

	private int x;
	private int y;
	private Direcao direcao;
	IInstrucaoDeMovimentacao instrucao;
	
	public Robo (IInstrucaoDeMovimentacao instrucao, int posicaoInicialEmX, int posicaoInicialEmY, Direcao direcao){
		this.instrucao = instrucao;
		setX(posicaoInicialEmX);
		setY(posicaoInicialEmY);
		setDirecao(direcao);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public boolean equals (Robo robo){
		return robo.getX() == this.getX() &&
			   robo.getY() == this.getY() &&			 
			   robo.getDirecao() == this.getDirecao();
	}

	public void virarParaEsquerda() {
		setDirecao(this.getDirecao().getRegra().getPosicaoDaEsquerda());		
	}

	public void virarParaDireita() {
		setDirecao(this.getDirecao().getRegra().getPosicaoDaDireita());		
	}

	public String getPosicaoAposMovimentar() {		
		return "("  + this.getX() + "," + this.getY() + "," + this.getDirecao().toString().charAt(0) + ")";
	}

	public boolean moverNoPlanalto() {		
		
		boolean moveu = instrucao.moverNoPlanalto(direcao, getX(), getY());
		
		atualizaPosicaoDoRoboAposMover();
		
		return moveu;		
	}

	private void atualizaPosicaoDoRoboAposMover() {
		setX(instrucao.getX());
		setY(instrucao.getY());
	}

	public boolean executarComandos(String comandosMovimento) {
		char[] listaComandos = comandosMovimento.toCharArray();
		
		for (char acao: listaComandos){
			
			switch (acao){
				case 'L': 
					virarParaEsquerda();
					break;
				case 'R':
					virarParaDireita();
					break;
				case 'M':
					if (!moverNoPlanalto()) 
						return false;					
			}
		}
		return true;	
	}
}

