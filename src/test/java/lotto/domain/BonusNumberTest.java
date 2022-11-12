package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
	@Test
	@DisplayName("숫자의 범위를 벗어난 경우 예외를 발생시킨다.")
	void bonusNumberBoundaryTest() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		String inputBonusNumber = "47";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);
		});

		String expectedMessage = "[ERROR] 보너스번호는 1-45사이의 숫자만 가능합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("숫자외 다른 문자가 입력된 경우 예외를 발생시킨다.")
	void bonusNumberInputLetterTest() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		String inputBonusNumber = "4a";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);
		});

		String expectedMessage = "[ERROR] 숫자만 입력이 가능합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("두자리 숫자이며 첫번째 숫자가 0일때 예외를 발생시킨다.")
	void bonusNumberFirstNumberZeroTest() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		String inputBonusNumber = "07";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);
		});

		String expectedMessage = "[ERROR] 두자리 숫자인 보너스번호의 첫번째 자리는 0이 올 수 없습니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("당첨번호와 중복이 있는 경우 예외를 발생시킨다.")
	void bonusNumberOverLapTest() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		String inputBonusNumber = "5";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);
		});

		String expectedMessage = "[ERROR] 보너스번호와 당첨번호에는 중복이 없어야 합니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}
}
