package lotto.models;

import lotto.constants.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BonusTest {

	@DisplayName("당첨로또 보너스 번호가 1~45 사이의 숫자로 정상적으로 들어왔을 때 예외처리없이 테스트 통과, 입력으로 넣은 보너스 번호가 나와야 함")
	@Test
	void checkLottoBonusNumberIsValidTest() {
		final int bonusNumber = 13;
		final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		Bonus bonus = new Bonus(bonusNumber, lotto);

		assertThatNoException().isThrownBy(() -> new Bonus(bonusNumber, lotto));
		assertThat(bonus.getNumberValue()).isEqualTo(bonusNumber);
	}

	@DisplayName("당첨로또 보너스 번호가 1~45 사이의 숫자가 아닐 때, 예외를 던짐")
	@Test
	void checkLottoBonusNumberIsOutOfRangeValueTest() {
		final int bonusNumber = 0;
		final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		assertThatThrownBy(() -> new Bonus(bonusNumber, lotto))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_HAS_INVALID_LOTTO_NUMBER_VALUE);
	}

	@DisplayName("당첨로또 보너스 번호가 기존에 뽑힌 6개의 당첨로또 번호들에 포함되는 경우, 예외를 던짐")
	@Test
	void checkLottoBonusNumberIsExistedInWinningLottoNumberTest() {
		final int bonusNumber = 5;
		final List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
		final Lotto lotto = new Lotto(winningLottoNumber);

		assertThatThrownBy(() -> new Bonus(bonusNumber, lotto))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Message.ERROR_EXISTED_LOTTO_BONUS_NUMBER);
	}
}