package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.BonusNumber;

public class BonusNumberTest {
	@DisplayName("숫자가 아닌 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"a", " ", "12b", "1,2,3,4,5,6"})
	void notNumber(String input) {
		assertThatThrownBy(() -> {
			BonusNumber.checkBonusNumber(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("양의 정수가 아닌 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "2.5", "5+4"})
	void notPositiveNumber(String input) {
		assertThatThrownBy(() -> {
			BonusNumber.checkBonusNumber(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
