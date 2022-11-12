package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;

class InputViewTest {
	private InputView inputView;

	@BeforeEach
	void setUp() {
		inputView = new InputView();
	}

	@DisplayName("구입금액이 1000으로 나누어 떨어지지 않을 때")
	@Test
	void notDivided1000() {
		int input = 100;
		int input2 = 100001;
		assertThrows(IllegalArgumentException.class, () -> inputView.validMoney(input));
		assertThrows(IllegalArgumentException.class, () -> inputView.validMoney(input2));
	}

	@DisplayName("당첨 번호에 중복이 있을 때")
	@Test
	void isDuplicateNumber() {
		List<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 3, 5));
		WinningNumber winningNumber = new WinningNumber(input);
		assertThrows(IllegalArgumentException.class, winningNumber::validWinningNumber);
	}

	@DisplayName("당첨 번호가 더 많거나 적을 때")
	@Test
	void numberSizeTest() {
		List<Integer> input = new ArrayList<>(List.of(1,2,3,4,5,6,7));
		List<Integer> input2 = new ArrayList<>(List.of(4,5,6,7));
		WinningNumber winningNumber = new WinningNumber(input);
		WinningNumber winningNumber2 = new WinningNumber(input2);
		assertThrows(IllegalArgumentException.class, winningNumber::validWinningNumber);
		assertThrows(IllegalArgumentException.class, winningNumber2::validWinningNumber);
	}

	@DisplayName("당첨 번호의 범위가 1~45가 아닐 때")
	@Test
	void numberRangeTest() {
		List<Integer> input = new ArrayList<>(List.of(100, 25, 30, 18, 26, 90));
		WinningNumber winningNumber = new WinningNumber(input);
		assertThrows(IllegalArgumentException.class, winningNumber::validWinningNumber);
	}

	@DisplayName("보너스 번호의 범위가 1~45가 아닐 때")
	@Test
	void BonusNumberRangeTest() {
		int input = 100;
		BonusNumber bonusNumber = new BonusNumber(input);
		assertThrows(IllegalArgumentException.class, bonusNumber::validBonusNumber);
	}
}
