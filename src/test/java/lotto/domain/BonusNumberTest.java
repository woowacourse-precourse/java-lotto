package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

	@DisplayName("보너스 숫자가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
	@Test
	void validateBonusNumberRange() {
		WinningNumbers winningNumbers = new WinningNumbers("10,15,20,25,30,35");
		assertThatThrownBy(() -> new BonusNumber(56, winningNumbers)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 숫자가 당첨 번호 중 하나와 중복되면 예외가 발생한다.")
	@Test
	void validateNoDuplicationWithWinningNumber() {
		WinningNumbers winningNumbers = new WinningNumbers("10,15,20,25,30,35");
		assertThatThrownBy(() -> new BonusNumber(10, winningNumbers)).isInstanceOf(IllegalArgumentException.class);
	}
}