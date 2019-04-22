package br.com.calcard.creditanalysis.util;

import br.com.calcard.creditanalysis.model.Client;
import br.com.calcard.creditanalysis.model.CreditAnalysisStatus;

public class ExpectedResult {

	private Client client;

	private CreditAnalysisStatus status;

	private String resultDescription;

	public ExpectedResult(Client client, CreditAnalysisStatus status, String resultDescription) {
		this.client = client;
		this.status = status;
		this.resultDescription = resultDescription;
	}

	public Client getClient() {
		return client;
	}

	public CreditAnalysisStatus getStatus() {
		return status;
	}

	public String getResultDescription() {
		return resultDescription;
	}

}
