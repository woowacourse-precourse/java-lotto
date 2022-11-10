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
		assertThrows(IllegalArgumentException.class, () -> inputView.validCheck(input));
	}

	@DisplayName("구입 금액의 첫 글자가 0일 떄")
	@Test
	void notFirstLetterZero() {
		String input = "0";
		String input2 = "01000";
		assertThrows(IllegalArgumentException.class, () -> inputView.validCheck(input));
		assertThrows(IllegalArgumentException.class, () -> inputView.validCheck(input2));
	}

	@DisplayName("구입금액이 숫자가 아닐 때")
	@Test
	void notNumber() {
		String input = "dss~";
		assertThrows(IllegalArgumentException.class, () -> inputView.validCheck(input));
	}

	@DisplayName("구입금액이 1000으로 나누어 떨어지지 않을 때")
	@Test
	void notDivided1000() {
		String input = "100";
		String input2 = "100001";
		assertThrows(IllegalArgumentException.class, () -> inputView.validCheck(input));
		assertThrows(IllegalArgumentException.class, () -> inputView.validCheck(input2));
	}

}
