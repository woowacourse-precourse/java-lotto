package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

	@Test
	@DisplayName("보너스 번호의 개수가 1개가 넘어가면 예외가 발생")
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new WinningLotto(
			new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("보너스 번호가 범위에 맞지 않으면 예외 발생")
	void checkRangeBonusNumbersTest() {
		assertThatThrownBy(() -> new WinningLotto(
			new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(0)))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new WinningLotto(
			new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(46)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생")
	void checkDuplicateBonusNumbersTest() {
		assertThatThrownBy(() -> new WinningLotto(
			new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(1)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("기존 보너스 번호와 새롭게 반환 받은 보너스 번호는 동일")
	void getBonusNumbersTest() {
		List<Integer> bonusNumbers = List.of(1);
		WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(2, 3, 4, 5, 6, 7)), bonusNumbers);

		List<Integer> getBonusNumbers = winningLotto.getBonusNumbers();
		Assertions.assertThat(getBonusNumbers).isEqualTo(bonusNumbers);
	}
}
