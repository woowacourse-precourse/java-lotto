package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import lotto.domain.WinningNumbers;

public class WinningNumbersTest {

	@DisplayName("로또 번호가 6개가 넘으면 예외가 발생한다")
	@Test
	void createLottoNumbersByOverSize() {
		assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호가 1~45가 아니면 예외가 발생한다")
	@Test
	void createLottoNumbersByOverRange() {
		assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46), 8))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호가 중복되면 예외가 발생한다")
	@Test
	void createLottoNumbersByDuplicate() {
		assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 1), 8))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 1~45가 아니면 예외가 발생한다")
	@Test
	void createBonusNumbersByOverRange() {
		assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 0))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다")
	@Test
	void createBonusNumbersByDuplicate() {
		assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
			.isInstanceOf(IllegalArgumentException.class);
	}


}
