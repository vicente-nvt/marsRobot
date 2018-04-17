package br.com.mars.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mars.business.implantacao.ImplantacaoDeRobos;
import br.com.mars.business.implantacao.InstrucaoDeMovimentacaoPlanaltoRetangular;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
 
@RestController
public class ImplantacaoDeRoboController {
	
    @RequestMapping(value = "/rest/mars/{comandosRobo}", method = RequestMethod.POST)
    public ResponseEntity<String> enviarRobo(@PathVariable("comandosRobo") String comandosRobo) {
            	 
    	IPlanalto planalto = new PlanaltoRetangular(5, 5);    	
    	InstrucaoDeMovimentacaoPlanaltoRetangular instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);
    	    	
    	ImplantacaoDeRobos implantacao;
    	String resposta;
    	
		try {
			implantacao = new ImplantacaoDeRobos(instrucao, "0,0,N");
	    	resposta = implantacao.movimentarRobo(comandosRobo);
		} catch (Exception e) {
			return new ResponseEntity<String>("400 Bad Request", HttpStatus.BAD_REQUEST);	
		}
    	
    	return ResponseEntity.ok(resposta);
    			       
    }	
}