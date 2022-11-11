package lotto.validator;

import static lotto.validator.ErrorMessage.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberValidatorTest {
	@DisplayName("당첨번호 입력값이 콤마와 숫자로 구성되어있는지 확인")
	@Test
	void runWinningNumberValidator() {
		//	given
		WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

		// when
		String noUseComma = "1.2.3.4.5.6";
		String noComma = "123456";
		String wrongInputPlace = "123456,,,,,";
		String outboundNumber = "1,2,47,3,4,5";
		String correct = "1,2,3,4,5,6";

		//	then
		assertThatThrownBy(() -> winningNumberValidator.runWinningNumberValidator(outboundNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(COMMA_CLASSIFICATION.getErrorMessage());
	}

	@DisplayName("Stirng의 List변환여부 확인")
	@Test
	void inputNumbersToLottoBalls() {
		// given
		WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

		//when
		String input = "1,2,3,4,5,6";
		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
		// then
		assertThat(winningNumberValidator.inputNumbersToLottoBalls(input)).isEqualTo(expected);
	}
}
