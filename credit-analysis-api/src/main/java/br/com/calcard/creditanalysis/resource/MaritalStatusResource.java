package br.com.calcard.creditanalysis.resource;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.creditanalysis.model.MaritalStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/marital-status")
@Api(value = "Estado civil")
public class MaritalStatusResource {

	@GetMapping
	@ApiOperation(value = "Retorna os estados civis cadastrados")
	public List<MaritalStatus> findAll() {
		return new ArrayList<MaritalStatus>(EnumSet.allOf(MaritalStatus.class));
	}

}
