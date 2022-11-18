package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinningLotto;

public class WinningLottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> WinningLotto.createWinningLotto("1,2,3,4,5,6,7"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		assertThatThrownBy(() -> WinningLotto.createWinningLotto("1,2,3,4,5,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호의 개수가 부족하면 예외가 발생한다.")
	@Test
	void createLottoByLessSize() {
		assertThatThrownBy(() -> WinningLotto.createWinningLotto("1,2,3,4,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호 범위에 벗어나면 예외가 발생한다.")
	@Test
	void createLottoByOverRange() {
		assertThatThrownBy(() -> WinningLotto.createWinningLotto("1,2,3,4,5,66"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호 구분자가 ,가 아니면 예외가 발생한다.")
	@Test
	void 구분자_테스트() {
		assertThatThrownBy(() -> WinningLotto.createWinningLotto("1,2,3,4,5.6"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호가 숫자가 아니면 예외가 발생한다.")
	@Test
	void 숫자_테스트() {
		assertThatThrownBy(() -> WinningLotto.createWinningLotto("1,2,3,4,5,a"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
	@Test
	void 보너스_숫자_테스트() {
		assertThatThrownBy(() -> WinningLotto.createBonusNumber("a"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
	@Test
	void 보너스_중복_테스트() {
		WinningLotto.createWinningLotto("1,2,3,4,5,6");

		assertThatThrownBy(() -> WinningLotto.createBonusNumber("1"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호 범위에 벗어나면 예외가 발생한다.")
	@Test
	void 보너스_범위_테스트() {
		WinningLotto.createWinningLotto("1,2,3,4,5,6");

		assertThatThrownBy(() -> WinningLotto.createBonusNumber("66"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
