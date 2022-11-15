package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.service.WinningNumber;

public class WinningNumberTest {
	@DisplayName("구분자가 쉼표가 아닌 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1 2 3 4 5 6", "1/2/3/4/5/6", "1# 2# 3# 4# 5# 6", "1, 2. 3, 4, 5, 6"})
	void notComma(String winningNumber) {
		assertThatThrownBy(() -> {
			WinningNumber.checkWinningNumber(winningNumber);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("번호의 개수가 6개가 아닌 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
	void notSixNumbers(String winningNumber) {
		assertThatThrownBy(() -> {
			WinningNumber.checkWinningNumber(winningNumber);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자가 아닌 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1, 2,3,4,5,6", "a,b,c,d,e,f", ",,,,,", " , , , , , ", "1, 2, 3, 4, 5, 6", "",
		"a,1,2,3,4,5"})
	void notNumber(String winningNumber) {
		assertThatThrownBy(() -> {
			WinningNumber.checkWinningNumber(winningNumber);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("양의 정수가 아닌 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"0,1,2,3,4,5", "-1,2,3,4,5,6", "1.5,2.3,4,5,6,7", "3,2.2,1,4,5,6"})
	void notPositiveNumber(String winningNumber) {
		assertThatThrownBy(() -> {
			WinningNumber.checkWinningNumber(winningNumber);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("0이 포함된 경우 예외가 발생")
	@Test
	void zero() {
		assertThatThrownBy(() -> {
			WinningNumber.checkWinningNumber("0,1,2,3,4,5");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("1부터 45사이의 숫자가 아닌 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,46", "51,2,3,4,5,6", "123,456,789,101,112,113"})
	void notRangeNumber(String winningNumber) {
		assertThatThrownBy(() -> {
			WinningNumber.checkWinningNumber(winningNumber);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("중복된 숫자가 있는 경우 예외가 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,4,5", "1,2,2,3,4,5"})
	void duplicateNumber(String winningNumber) {
		assertThatThrownBy(() -> {
			WinningNumber.checkWinningNumber(winningNumber);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
