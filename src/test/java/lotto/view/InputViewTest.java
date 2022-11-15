package lotto.view;

import static lotto.validator.ErrorMessage.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.validator.MoneyInputValidator;

public class InputViewTest {
	private static InputView inputView;

	@BeforeAll
	static void beforeAll() {
		MoneyInputValidator moneyInputValidator = new MoneyInputValidator();
		inputView = new InputView(moneyInputValidator);
	}

	@DisplayName("유효성거친 돈입력 올바른 반환여부확인")
	@Test
	void inputMoney() {
		//	given
		String input = "8000";
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		//	when
		Integer expectedMoney = 8000;

		//	then
		// 올바른 값 반환
		// assertThat(inputView.inputMoney()).isEqualTo(expectedMoney);

		// 오류출력
		assertThatThrownBy(() -> inputView.inputMoney())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_DIVIDED.getErrorMessage());
	}

	/*@Test
	void 유효성거친_보너스번호_올바른_반환여부확인() {
		//	given
		String input = "1,2,3,4,5,6";
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		inputView.inputWinningNumbers()
		//	when
		//	then
	}*/
}
