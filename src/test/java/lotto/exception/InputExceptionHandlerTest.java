package lotto.exception;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputExceptionHandlerTest {

	@ParameterizedTest
	@DisplayName("구입 금액은 천원 단위 숫자로 입력 받을 때 예외 발생하지 않음")
	@ValueSource(strings = {"1000", "4000", "103000"})
	void checkAmountInputTest(String input) {
		assertThatCode(
			() -> InputExceptionHandler.checkPurchaseAmountForm(input)
		).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("금액은 천원 단위로 받지 않을 경우 예외 발생")
	@ValueSource(strings = {"0", "1999", "2553", "300"})
	void oneThousandUnitTest(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkPurchaseAmountForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("구입 금액을 숫자로 입력 받지 않을 경우 예외 발생")
	@ValueSource(strings = {"qewe", "1000h", "가나다", "30!0"})
	void checkNotNumberTest(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkPurchaseAmountForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

}
