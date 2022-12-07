package lotto.validator;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
	@DisplayName("당첨번호 입력값이 콤마와 숫자로 구성되어있는지 확인")
	@Test
	void runWinningNumberValidator() {
		//	given
		NumberValidator numberValidator = new NumberValidator();

		// when
		// String noUseComma = "1.2.3.4.5.6";
		String noComma = "123456";
		String wrongInputPlace = "123456,,,,,";
		List<Integer> outboundNumber = List.of(1, 2, 47, 3, 4, 5);
		List<Integer> outRangeNumber = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		// String correct = "1,2,3,4,5,6";
		List<Integer> correct = List.of(3, 11, 18, 33, 43, 45);

		//	then
		// System.out.println(winningNumberValidator.runWinningNumberValidator(outRangeNumber));
		// assertThatThrownBy(() -> numberValidator.runWinningNumberValidator(outboundNumber))
		// 	.isInstanceOf(IllegalArgumentException.class)
		// 	.hasMessageContaining(NOT_LOTTO_NUMBER_RANGE.getErrorMessage());
	}
}
