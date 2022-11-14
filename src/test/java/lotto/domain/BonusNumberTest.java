package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
	@Test
	@DisplayName("보너스 번호가 제한된 범위를 벗어난 경우 예외를 발생시킨다.")
	void bonusNumberBoundaryTest() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		String inputBonusNumber = "47";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);
		});

		String expectedMessage = "[ERROR] 1-45 사이의 숫자만 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("보너스 번호에 숫자 외 다른 문자가 입력된 경우 예외를 발생시킨다.")
	void bonusNumberInputLetterTest() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		String inputBonusNumber = "4a";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);
		});

		String expectedMessage = "[ERROR] 숫자만 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("보너스 번호가 두자리 숫자이며 첫번째 숫자가 0일때 예외를 발생시킨다.")
	void bonusNumberFirstNumberZeroTest() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		String inputBonusNumber = "07";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);
		});

		String expectedMessage = "[ERROR] 두자리 이상의 숫자중 첫째자리는 1이상으로 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}

	@Test
	@DisplayName("보너스 번호가 당첨번호와 중복인 경우 예외를 발생시킨다.")
	void bonusNumberOverLapTest() {
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		String inputBonusNumber = "5";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);
		});

		String expectedMessage = "[ERROR] 보너스번호는 당첨번호와 중복없이 입력해 주시기 바랍니다.";
		assertThat(expectedMessage).isEqualTo(exception.getMessage());
	}
}
