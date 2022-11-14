package lotto.mytest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Comparison;

public class ComparisonTest {
	List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
	int bonusNumber = 45;
	Comparison comparison = new Comparison(winningLotto, bonusNumber);

	@DisplayName("당첨 번호와 일치하는 번호의 개수가 6개인 경우")
	@Test
	void compareLotto() {
		List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 6);
		assertEquals(Comparison.matchLottoCount(myLotto), 6);
	}

	@DisplayName("당첨 번호와 일치하는 번호의 개수가 5개이고, 보너스 번호가 일치하는 경우")
	@Test
	void compareLotto2() {
		List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 45);
		assertAll(
			() -> assertEquals(Comparison.matchLottoCount(myLotto), 5),
			() -> assertTrue(Comparison.isMatchBonusNumber(myLotto))
		);
	}

	@DisplayName("당첨 번호와 일치하는 번호의 개수가 5개인 경우")
	@Test
	void compareLotto3() {
		List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 45);
		assertEquals(Comparison.matchLottoCount(myLotto), 5);
	}

	@DisplayName("당첨 번호와 일치하는 번호의 개수가 4개인 경우")
	@Test
	void compareLotto4() {
		List<Integer> myLotto = List.of(1, 2, 3, 4, 44, 45);
		assertEquals(Comparison.matchLottoCount(myLotto), 4);
	}

	@DisplayName("당첨 번호와 일치하는 번호의 개수가 3개인 경우")
	@Test
	void compareLotto5() {
		List<Integer> myLotto = List.of(1, 2, 3, 43, 44, 45);
		assertEquals(Comparison.matchLottoCount(myLotto), 3);
	}

	@DisplayName("당첨 번호와 일치하는 번호의 개수가 2개인 경우")
	@Test
	void compareLotto6() {
		List<Integer> myLotto = List.of(1, 2, 43, 44, 45, 46);
		assertEquals(Comparison.matchLottoCount(myLotto), 2);
	}
}
