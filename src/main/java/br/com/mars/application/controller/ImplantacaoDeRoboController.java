package br.com.mars.application.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mars.business.implantacao.ImplantacaoDeRobos;
 
@RestController
@EnableAutoConfiguration
public class ImplantacaoDeRoboController {
	
    @RequestMapping(value = "/rest/mars/{comandosRobo}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> enviarRobo(@PathVariable("comandosRobo") String comandosRobo) {
        
    	ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos();
    	
    	String resposta = implantacao.implantarEMoverRobo("5,5", "0,0,N", comandosRobo);
        
    	if (implantacao.getfalhaNaImplantacao()) 
    		return new ResponseEntity<String>("400 Bad Request", HttpStatus.BAD_REQUEST);
    	else
    		return new ResponseEntity<String>(resposta, HttpStatus.OK);
    			       
    }	
}