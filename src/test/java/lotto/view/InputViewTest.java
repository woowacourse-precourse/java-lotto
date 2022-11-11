package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
	private InputView inputView;

	@BeforeEach
	void setUp() {
		inputView = new InputView();
	}

	@DisplayName("구입금액을 아예 입력하지 않았을 때")
	@Test
	void notInputValue() {
		String input = "";
		assertThrows(IllegalArgumentException.class, () -> inputView.validMoney(input));
	}

	@DisplayName("구입 금액의 첫 글자가 0일 떄")
	@Test
	void notFirstLetterZero() {
		String input = "0";
		String input2 = "01000";
		assertThrows(IllegalArgumentException.class, () -> inputView.validMoney(input));
		assertThrows(IllegalArgumentException.class, () -> inputView.validMoney(input2));
	}

	@DisplayName("구입금액이 숫자가 아닐 때")
	@Test
	void notNumber() {
		String input = "dss~";
		assertThrows(IllegalArgumentException.class, () -> inputView.validMoney(input));
	}

	@DisplayName("구입금액이 1000으로 나누어 떨어지지 않을 때")
	@Test
	void notDivided1000() {
		String input = "100";
		String input2 = "100001";
		assertThrows(IllegalArgumentException.class, () -> inputView.validMoney(input));
		assertThrows(IllegalArgumentException.class, () -> inputView.validMoney(input2));
	}

	@DisplayName("당첨 번호가 숫자가 아닐 때")
	@Test
	void isNotNumber() {
		String input = "a,s,d,f~";
		assertThrows(IllegalArgumentException.class, () -> inputView.validWinningNumber(input));
	}

	@DisplayName("당첨 번호에 중복이 있을 때")
	@Test
	void isDuplicateNumber() {
		String input = "1,2,3,4,5,7";
		assertThrows(IllegalArgumentException.class, () -> inputView.validWinningNumber(input));
	}

	@DisplayName("당첨 번호가 더 많거나 적을 때")
	@Test
	void numberSizeTest() {
		String input = "1,2,3,4,5,6,7";
		String input2 = "4,5,6,7";
		assertThrows(IllegalArgumentException.class, () -> inputView.validWinningNumber(input));
		assertThrows(IllegalArgumentException.class, () -> inputView.validWinningNumber(input2));
	}

	@DisplayName("당첨 번호의 범위가 1~45가 아닐 때")
	@Test
	void numberRangeTest() {
		String input = "100,25,30,18,26,90";
		assertThrows(IllegalArgumentException.class, () -> inputView.validWinningNumber(input));
	}

	@DisplayName("보너스 번호의 범위가 1~45가 아닐 때")
	@Test
	void BonusNumberRangeTest() {
		String input = "100";
		assertThrows(IllegalArgumentException.class, () -> inputView.validBonusNumber(input));
	}

	@DisplayName("보너스 번호가 숫자가 아닐 때")
	@Test
	void BonusNumberNotNumberTest() {
		String input = "~~d";
		assertThrows(IllegalArgumentException.class, () -> inputView.validBonusNumber(input));
	}

	@Test
	void test() {
		String input = "1,2,3,4,5,6";
		assertDoesNotThrow(() -> inputView.validWinningNumber(input));
	}
}
