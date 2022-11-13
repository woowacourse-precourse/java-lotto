package lotto.mytest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Comparison;

public class ComparisonTest {
	List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
	int bonusNumber = 7;

	@DisplayName("로또 1등 당첨 확인")
	@Test
	void compareLotto() {
		List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 6);
		assertEquals(Comparison.matchLottoNumber(winningLotto, myLotto), 6);
	}

	@DisplayName("로또 2등 당첨 확인")
	@Test
	void compareLotto2() {
		List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 45);
		assertAll(
			() -> assertEquals(Comparison.matchLottoNumber(winningLotto, myLotto), 5),
			() -> assertTrue(Comparison.matchBonusNumber(bonusNumber, myLotto))
		);
	}

	@DisplayName("로또 3등 당첨 확인")
	@Test
	void compareLotto3() {
		List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 45);
		assertEquals(Comparison.matchLottoNumber(winningLotto, myLotto), 5);
	}

	@DisplayName("로또 4등 당첨 확인")
	@Test
	void compareLotto4() {
		List<Integer> myLotto = List.of(1, 2, 3, 4, 44, 45);
		assertEquals(Comparison.matchLottoNumber(winningLotto, myLotto), 4);
	}

	@DisplayName("로또 5등 당첨 확인")
	@Test
	void compareLotto5() {
		List<Integer> myLotto = List.of(1, 2, 3, 43, 44, 45);
		assertEquals(Comparison.matchLottoNumber(winningLotto, myLotto), 3);
	}

	@DisplayName("로또 꽝 확인")
	@Test
	void compareLotto6() {
		List<Integer> myLotto = List.of(1, 2, 43, 44, 45, 46);
		assertEquals(Comparison.matchLottoNumber(winningLotto, myLotto), 2);
	}
}
