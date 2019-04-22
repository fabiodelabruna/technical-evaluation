package br.com.calcard.creditanalysis.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.calcard.creditanalysis.model.Client;
import br.com.calcard.creditanalysis.model.CreditAnalysisStatus;
import br.com.calcard.creditanalysis.model.CreditAnalysis;
import br.com.calcard.creditanalysis.model.Genre;
import br.com.calcard.creditanalysis.model.MaritalStatus;
import br.com.calcard.creditanalysis.util.ExpectedResult;

@Ignore
@RunWith(SpringRunner.class)
public class CreditAnalysisServiceTest {

	private static Map<String, ExpectedResult> expectedResults;
	
	@BeforeClass
	public static void setup() {
		expectedResults = new HashMap<>();

		expectedResults.put("Lucas", new ExpectedResult(new Client(null, "Lucas", null, 28, 0, new BigDecimal(2500),
				Genre.MASCULINO, MaritalStatus.SOLTEIRO, null), CreditAnalysisStatus.APROVADO, "entre 500 - 1000"));

		expectedResults.put("Ana", new ExpectedResult(new Client(null, "Ana", null, 17, 0, new BigDecimal(1000),
				Genre.FEMININO, MaritalStatus.SOLTEIRO, null), CreditAnalysisStatus.APROVADO, "entre 100 - 500"));

		expectedResults.put("Pedro", new ExpectedResult(new Client(null, "Pedro", null, 68, 3, new BigDecimal(8000),
				Genre.MASCULINO, MaritalStatus.CASADO, null), CreditAnalysisStatus.APROVADO, "entre 1500 - 2000"));

		expectedResults.put("Paula", new ExpectedResult(new Client(null, "Paula", null, 61, 3, new BigDecimal(5000),
				Genre.FEMININO, MaritalStatus.CASADO, null), CreditAnalysisStatus.APROVADO, "entre 1000 - 1500"));

		expectedResults.put("João", new ExpectedResult(new Client(null, "João", null, 56, 2, new BigDecimal(2000),
				Genre.MASCULINO, MaritalStatus.DIVORCIADO, null), CreditAnalysisStatus.NEGADO, "reprovado pela política de crédito"));

		expectedResults.put("Maria", new ExpectedResult(new Client(null, "Maria", null, 45, 1, new BigDecimal(2000),
				Genre.FEMININO, MaritalStatus.DIVORCIADO, null), CreditAnalysisStatus.NEGADO, "reprovado pela política de crédito"));

		expectedResults.put("José", new ExpectedResult(new Client(null, "José", null, 30, 2, new BigDecimal(8000),
				Genre.MASCULINO, MaritalStatus.CASADO, null), CreditAnalysisStatus.APROVADO, "superior 2000"));

		expectedResults.put("Dinae", new ExpectedResult(new Client(null, "Dinae", null, 33, 1, new BigDecimal(10000),
				Genre.FEMININO, MaritalStatus.CASADO, null), CreditAnalysisStatus.APROVADO, "superior 2000"));

		expectedResults.put("Marcos", new ExpectedResult(new Client(null, "Marcos", null, 19, 1, new BigDecimal(400),
				Genre.MASCULINO, MaritalStatus.SOLTEIRO, null), CreditAnalysisStatus.NEGADO, "renda baixa"));

		expectedResults.put("Suzan", new ExpectedResult(
				new Client(null, "Suzan", null, 63, 3, new BigDecimal(1500), Genre.FEMININO, MaritalStatus.VIUVA, null),
				CreditAnalysisStatus.NEGADO, "reprovado pela política de crédito"));

		expectedResults.put("Luci", new ExpectedResult(new Client(null, "Luci", null, 28, 2, new BigDecimal(2500),
				Genre.FEMININO, MaritalStatus.SOLTEIRO, null), CreditAnalysisStatus.APROVADO, "entre 100 - 500"));

		expectedResults.put("Roberto", new ExpectedResult(new Client(null, "Roberto", null, 16, 0, new BigDecimal(500),
				Genre.MASCULINO, MaritalStatus.SOLTEIRO, null), CreditAnalysisStatus.NEGADO, "renda baixa"));

		expectedResults.put("Bruno", new ExpectedResult(new Client(null, "Bruno", null, 30, 5, new BigDecimal(8000),
				Genre.MASCULINO, MaritalStatus.CASADO, null), CreditAnalysisStatus.APROVADO, "entre 1000 - 1500"));

		expectedResults.put("Ariel", new ExpectedResult(new Client(null, "Ariel", null, 33, 0, new BigDecimal(10000),
				Genre.FEMININO, MaritalStatus.VIUVA, null), CreditAnalysisStatus.APROVADO, "superior 2000"));

	}

	@Test
	public void shouldDoAnalysisAndReturnCorrectResult() {
		CreditAnalysis porposal = null;
		ExpectedResult expectedResult = null;
		CreditAnalysisService service = new CreditAnalysisService();

		for (String clientName : expectedResults.keySet()) {
			expectedResult = expectedResults.get(clientName);
			porposal = service.doAnalysis(expectedResult.getClient());
			assertEquals(expectedResult.getStatus(), porposal.getStatus());
			assertEquals(expectedResult.getResultDescription(), porposal.getDescription());
		}
	}

}
