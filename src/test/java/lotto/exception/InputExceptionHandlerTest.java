package lotto.exception;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

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

	@ParameterizedTest
	@DisplayName("당첨번호가 중복되지 않은1~45숫자로 입력 받을 경우 예외 발생하지않음")
	@ValueSource(strings = {"1,4,6,20,30,45"})
	void checkWinningNumberFormTest(String input) {
		assertThatCode(
			() -> InputExceptionHandler.checkWinningNumberForm(input)
		).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("당첨 번호가 중복 될 경우 예외 발생")
	@ValueSource(strings = {"1,2,3,4,5,5", "1,2,2,2,2,2"})
	void checkDuplicatedWinningNumberTest(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkWinningNumberForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("당첨 번호입력이 숫자와 쉼표가 아닐 경우 예외 발생")
	@ValueSource(strings = {"1.2.3.4.5.6", "a,b,3,4,5,6"})
	void checkNumberAndRest(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkWinningNumberForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("당첨 번호가 1~45 사이가 아닐 경우 예외 발생")
	@ValueSource(strings = {"1,2,56,3,4,5", "0,1,2,3,4,5,6"})
	void checkBetweenNumbersTest(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkWinningNumberForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("당첨 번호가 1~45 사이가 아닐 경우 예외 발생")
	@ValueSource(strings = {"1,2,3,4,5,6,7", "0,1,2,3"})
	void checkWinningNumberCountTest(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkWinningNumberForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("보너스 번호는 당첨 번호와 중복되지 않은 숫자로 구성되어야 한다. -성공할 경우")
	@ValueSource(strings = {"7", "15", "28"})
	void checkBonusNumberTest(String input) {
		assertThatCode(
			() -> InputExceptionHandler.checkBonusNumberForm(Arrays.asList(1, 2, 3, 4, 5, 6), input)
		).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("보너스 번호는 당첨 번호와 중복되지 않은 숫자로 구성되지 않을 경우 예외 발생한다. -실패할 경우")
	@ValueSource(strings = {"5", "qw", "47"})
	void checkBonusNumberExceptionTest(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkBonusNumberForm(Arrays.asList(1, 2, 3, 4, 5, 6), input)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
