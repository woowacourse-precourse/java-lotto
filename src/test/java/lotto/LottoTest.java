package lotto;

import static lotto.common.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_VALID_SIZE);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_VALID_LOTTO_DUPLICATE);
	}

	@DisplayName("로또 번호의 개수가 부족하면 예외가 발생한다.")
	@Test
	void createLottoByLessSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_VALID_SIZE);
	}

	@DisplayName("로또 번호 범위에 벗어나면 예외가 발생한다.")
	@Test
	void createLottoByOverRange() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 66)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_VALID_NUMBER);
	}
}
