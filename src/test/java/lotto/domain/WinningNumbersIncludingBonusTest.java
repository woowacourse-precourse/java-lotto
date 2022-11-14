package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersIncludingBonusTest {

	@DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
	@Test
	void inputBonusNumberByOutOfRange() {
		assertThatThrownBy(() -> new WinningNumbersIncludingBonus(
				new Lotto(List.of(1, 2, 3, 4, 5, 6)), 50))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호와 중복된 숫자가 당첨 번호 리스트에 있으면 예외가 발생한다.")
	@Test
	void inputBonusNumberByDuplicatedNumber() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() -> new WinningNumbersIncludingBonus(
				new Lotto(List.of(1, 2, 3, 4, 5, 6)), 5))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void Getter_테스트() {
		Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		int testBonusNumber = 10;
		WinningNumbersIncludingBonus winnings = new WinningNumbersIncludingBonus(testLotto, testBonusNumber);

		assertThat(winnings.getWinningNumbers()).isEqualTo(testLotto);
		assertThat(winnings.getBonusNumber()).isEqualTo(testBonusNumber);
	}

}
