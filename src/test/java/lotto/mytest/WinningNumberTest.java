package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.WinningNumber;

public class WinningNumberTest {
	@DisplayName("구분자가 쉼표가 아닌 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1 2 3 4 5 6", "1/2/3/4/5/6", "1# 2# 3# 4# 5# 6", "1, 2. 3, 4, 5, 6"})
	void notComma(String winningNumber) {
		assertThatThrownBy(() -> {
			WinningNumber.checkWinningNumber(winningNumber);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
