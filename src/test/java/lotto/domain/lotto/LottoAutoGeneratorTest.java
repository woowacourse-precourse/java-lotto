package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

	private LottoAutoGenerator lottoAutoGenerator;
	@BeforeEach
	void setUp() {
		lottoAutoGenerator = new LottoAutoGenerator();
	}

	@Test
	void 로또_자동_생성() {
		Lotto lotto = lottoAutoGenerator.createLottoByAuto();
		assertNotNull(lotto.getNumbers());
	}
}