package br.com.calcard.creditanalysis.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.creditanalysis.model.Client;
import br.com.calcard.creditanalysis.model.CreditAnalysis;
import br.com.calcard.creditanalysis.service.CreditAnalysisService;
import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/credit-analysis")
@Api(value = "Análise de Crédito")
public class CreditAnalysisResource {

	@Autowired
	private CreditAnalysisService creditAnalysisService;

	@PostMapping
	public ResponseEntity<CreditAnalysis> doAnalysis(@RequestBody Client client) {
		return ResponseEntity.ok(creditAnalysisService.doAnalysis(client));
	}

}
