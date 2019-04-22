package br.com.calcard.creditanalysis.resource;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.creditanalysis.model.Genre;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/genres")
@Api(value = "Gênero")
public class GenreResource {

	@GetMapping
	@ApiOperation(value = "Retorna os gêneros cadastrados")
	public List<Genre> findAll() {
		return new ArrayList<Genre>(EnumSet.allOf(Genre.class));
	}

}
