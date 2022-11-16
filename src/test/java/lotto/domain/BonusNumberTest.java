package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 6, 46, 100})
	@DisplayName("보너스 번호 입력 후 예외 로직 체크")
	void bonusNumErrorTest(int number) {
		WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
		assertThrows(IllegalArgumentException.class,
			() -> new BonusNumber(number, winningNumber.getWinningNumber()));
	}
}
