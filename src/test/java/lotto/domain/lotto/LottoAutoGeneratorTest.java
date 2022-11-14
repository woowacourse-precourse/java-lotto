package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lotto.domain.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

	private LottoAutoGenerator lottoAutoGenerator;

	@BeforeEach
	void setUp() {
		lottoAutoGenerator = new LottoAutoGenerator();
	}

	@DisplayName("금액에 맞는 로또 개수 리턴")
	@Test
	void createLottoAccordingToTheAmount() {
		List<Lotto> lottos = lottoAutoGenerator.createLottoAccordingToTheAmount(
				new Money("8000"));
		assertEquals(8,lottos.size());
	}


	@DisplayName("로또 자동 생성")
	@Test
	void 로또_자동_생성() {
		Lotto lotto = lottoAutoGenerator.createLottoByAuto();
		assertNotNull(lotto.getNumbers());
	}
}