package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.machine.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoComparatorTest {

	LottoMachine lottoMachine;
	LottoComparator lottoComparator;
	@BeforeEach
	void setUp() {
		lottoMachine = new LottoMachine("1,2,3,4,5,6","7");
	    lottoComparator = new LottoComparator(lottoMachine);
	}

	@DisplayName("보너스 번호 포함 True 테스트")
	@Test
	void hasNumberTrue() {
		Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
		assertTrue(lottoComparator.hasBonusNumber(lotto));
	}

	@DisplayName("보보너스 번호 포함 False")
	@Test
	void hasNumberFalse(){
		Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
		assertFalse(lottoComparator.hasBonusNumber(lotto));
	}
}