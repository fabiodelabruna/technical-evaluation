package br.com.calcard.creditanalysis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.STRING)
public enum MaritalStatus {

	SOLTEIRO, CASADO, DIVORCIADO, VIUVA;

}
