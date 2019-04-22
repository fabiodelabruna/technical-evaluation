package br.com.calcard.creditanalysis.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.creditanalysis.model.State;
import br.com.calcard.creditanalysis.repository.StateRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/states")
@Api(value = "Estado")
public class StateResource {

	@Autowired
	private StateRepository stateRepository;

	@GetMapping
	@ApiOperation(value = "Retorna os estados cadastrados")
	public List<State> findAll() {
		return stateRepository.findAll();
	}

}
