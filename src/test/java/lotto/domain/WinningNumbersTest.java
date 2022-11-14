package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

			String expectedMessage = "[ERROR] 당첨번호는 1~45 숫자 6개와 쉼표로 구분되는 형식으로 입력해 주시기 바랍니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}

		@Test
		@DisplayName("당첨번호 구분을 쉽표가 아닌 다른 문자로 한 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest2() {
			String inputWinnerNumber = "45,23,44,33,42.31";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호는 1~45 숫자 6개와 쉼표로 구분되는 형식으로 입력해 주시기 바랍니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}

		@Test
		@DisplayName("마지막 당첨번호 뒤에 쉽표를 붙인 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest3() {
			String inputWinnerNumber = "45,23,44,33,42,31,";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호는 1~45 숫자 6개와 쉼표로 구분되는 형식으로 입력해 주시기 바랍니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}

		@Test
		@DisplayName("당첨번호를 구분하는 쉼표앞이나 뒤에 공백을 붙이는 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest4() {
			String inputWinnerNumber = "45, 23, 44, 33, 42, 31";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호는 1~45 숫자 6개와 쉼표로 구분되는 형식으로 입력해 주시기 바랍니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}

		@Test
		@DisplayName("당첨번호중 숫자가 아닌 경우 예외가 발생한다.")
		void validateWinningNumbersFormatTest5() {
			String inputWinnerNumber = "45,23,44,33,a4,12";
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
			});

			String expectedMessage = "[ERROR] 당첨번호는 1~45 숫자 6개와 쉼표로 구분되는 형식으로 입력해 주시기 바랍니다.";
			assertThat(expectedMessage).isEqualTo(exception.getMessage());
		}
	}

	@Test
	@DisplayName("당첨번호중 제한 범위를 벗어난 경우 예외가 발생한다.")
	void validateWinningNumbersBoundaryTest1() {
		String inputWinnerNumber = "45,23,44,33,46,12";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
		});

		String expectedMessage = "[ERROR] 1-45 사이의 숫자만 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("당첨번호중 두자리 숫자이며 첫번째 자리가 0이면 예외가 발생한다.")
	void validateWinningNumbersBoundaryTest2() {
		String inputWinnerNumber = "45,23,44,33,06,12";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
		});

		String expectedMessage = "[ERROR] 두자리 이상의 숫자중 첫째자리는 1이상으로 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("당첨번호중 중복이 발생할 경우 예외가 발생한다.")
	void validateWinnerNumberOverlapTest1() {
		String inputWinnerNumber = "1,2,3,4,5,1";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			WinningNumbers winningNumbers = new WinningNumbers(inputWinnerNumber);
		});

		String expectedMessage = "[ERROR] 당첨번호들을 중복없이 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}
}
