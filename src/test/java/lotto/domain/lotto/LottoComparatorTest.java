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

	@DisplayName(" 번호 포함 False")
	@Test
	void hasNumberFalse(){
		Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
		assertFalse(lottoComparator.hasBonusNumber(lotto));
	}

	@DisplayName("로또 숫자 6개 일치 테스트")
	@Test
	void 로또번호_6개_일치(){
		Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
		assertEquals(6,lottoComparator.getMatchCount(lotto));
	}
	@DisplayName("로또 숫자 5개 일치 테스트")
	@Test
	void 로또번호_5개_일치(){
		Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
		assertEquals(5,lottoComparator.getMatchCount(lotto));
	}
	@DisplayName("로또 숫자 4개 일치 테스트")
	@Test
	void 로또번호_4개_일치(){
		Lotto lotto = new Lotto(List.of(1,2,3,4,7,8));
		assertEquals(4,lottoComparator.getMatchCount(lotto));
	}
	@DisplayName("로또 숫자 3개 일치 테스트")
	@Test
	void 로또번호_3개_일치(){
		Lotto lotto = new Lotto(List.of(1,2,3,7,8,9));
		assertEquals(3,lottoComparator.getMatchCount(lotto));
	}

}