package br.com.calcard.creditanalysis.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.creditanalysis.model.Client;
import br.com.calcard.creditanalysis.model.CreditAnalysis;
import br.com.calcard.creditanalysis.model.CreditAnalysisStatus;
import br.com.calcard.creditanalysis.model.MaritalStatus;
import br.com.calcard.creditanalysis.repository.ClientRepository;
import br.com.calcard.creditanalysis.repository.CreditAnalysisRepository;

@Service
public class CreditAnalysisService {

	private final String LOW_REMUNERATION = "renda baixa";
	private final BigDecimal MINIMUM_REMUNERATION = new BigDecimal(500.00);
	private final String DISAPPROVED_BY_CREDIT_POLICY = "reprovado pela política de crédito";

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CreditAnalysisRepository creditAnalysisRepository;

	public CreditAnalysis doAnalysis(Client client) {

		CreditAnalysis creditAnalysis = new CreditAnalysis(client);

		if (hasLowRemuneration(client)) {
			creditAnalysis.setStatus(CreditAnalysisStatus.NEGADO);
			creditAnalysis.setDescription(LOW_REMUNERATION);
			return creditAnalysis;
		}

		if (isDivorced(client) || isWidowAndHasDependents(client)) {
			creditAnalysis.setStatus(CreditAnalysisStatus.NEGADO);
			creditAnalysis.setDescription(DISAPPROVED_BY_CREDIT_POLICY);
			return creditAnalysis;
		}

		creditAnalysis.setStatus(CreditAnalysisStatus.APROVADO);
		creditAnalysis.setDescription(getResultDescriptionByScore(calculateScore(client)));

		client = clientRepository.save(client);
		creditAnalysis = creditAnalysisRepository.save(creditAnalysis);

		return creditAnalysis;

	}

	private int calculateScore(Client client) {
		int limiar = getLimiar(client);
		return client.getRemuneration().subtract(MINIMUM_REMUNERATION)
				.divide(new BigDecimal(limiar), 2, RoundingMode.HALF_UP)
				.divide(new BigDecimal(client.getDependents() + 1), 2, RoundingMode.HALF_UP)
				.multiply(new BigDecimal(100)).intValue();
	}

	private int getLimiar(Client client) {
		if (client.getMaritalStatus() == MaritalStatus.CASADO) {
			return 100;
		} else if (client.getMaritalStatus() == MaritalStatus.SOLTEIRO) {
			return 200;
		} else if (client.getMaritalStatus() == MaritalStatus.VIUVA) {
			return 300;
		} else {
			return 0;
		}
	}

	private String getResultDescriptionByScore(int score) {
		if (score > 2000)
			return "superior 2000";
		if (score > 1500 && score <= 2000)
			return "entre 1500 - 2000";
		if (score > 1000 && score <= 1500)
			return "entre 1000 - 1500";
		if (score > 500 && score <= 1000)
			return "entre 500 - 1000";
		if (score > 100 && score <= 500)
			return "entre 100 - 500";

		return null;
	}

	private boolean hasLowRemuneration(Client client) {
		return client.getRemuneration().doubleValue() <= MINIMUM_REMUNERATION.doubleValue();
	}

	private boolean isDivorced(Client client) {
		return client.getMaritalStatus() == MaritalStatus.DIVORCIADO;
	}

	private boolean isWidowAndHasDependents(Client client) {
		return client.getMaritalStatus() == MaritalStatus.VIUVA && client.getDependents() > 0;
	}

}
