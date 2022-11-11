package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
	@Nested
	@DisplayName("당첨번호 입력 형식을 검증한다.")
	class FormatTest {
		@Test
		@DisplayName("당첨번호를 6개미만 입력한 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest1() {
			String inputWinnerNumber = "45,23,44,33,42";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호들은 숫자 6개와 쉼표로 구분되는 형식이어야 합니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}

		@Test
		@DisplayName("숫자 구분을 쉽표가 아닌 다른 문자로 한 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest2() {
			String inputWinnerNumber = "45,23,44,33,42.31";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호들은 숫자 6개와 쉼표로 구분되는 형식이어야 합니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}

		@Test
		@DisplayName("숫자 마지막에 쉽표를 붙인 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest3() {
			String inputWinnerNumber = "45,23,44,33,42,31,";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호들은 숫자 6개와 쉼표로 구분되는 형식이어야 합니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}

		@Test
		@DisplayName("쉼표앞이나 뒤에 공백을 붙이는 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest4() {
			String inputWinnerNumber = "45, 23, 44, 33, 42, 31";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호들은 숫자 6개와 쉼표로 구분되는 형식이어야 합니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}

		@Test
		@DisplayName("당첨번호중 숫자가 아닌 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest5() {
			String inputWinnerNumber = "45,23,44,33,a4,12";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호들은 숫자 6개와 쉼표로 구분되는 형식이어야 합니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}
	}

	@Test
	@DisplayName("당첨번호중 제한 범위를 벗어난 경우 예외가 발생한다.")
	void validateWinningNumbersBoundaryTest2() {
		String inputWinnerNumber = "45,23,44,33,46,12";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
		});

		String expectedMessage = "[ERROR] 당첨번호들은 1~45의 숫자로만 구성되어야 합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("당첨숫자중 중복이 발생할 경우 예외가 발생한다.")
	void validateWinnerNumberOverlapTest1() {
		String inputWinnerNumber = "1,2,3,4,5,1";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
		});

		String expectedMessage = "[ERROR] 당첨번호들은 중복이 되지 않아야 합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}
}
