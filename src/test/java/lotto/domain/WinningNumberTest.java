package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
	@DisplayName("로또 당첨 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createWinningNumberByDuplicated() {
		Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(1);
		assertThatThrownBy(() -> new WinningNumber(winningLotto, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
