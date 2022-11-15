package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {

	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void case1() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void case2() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호가 1이상 45이하에 속하지 않으면 예외가 발생한다.")
	@Test
	void case3() {
		assertThatThrownBy(() -> new Lotto(List.of(0, 46, 3, 4, 5, 5)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Nested
	class NewInstance {

		@DisplayName("오름차순 정렬된 랜덤 6개의 번호를 생성한다.")
		@Test
		void case1() {
			// given
			final int expected = 6;

			// when
			final Lotto lotto = Lotto.newInstance();

			// then
			assertThat(lotto.getNumbers().size()).isEqualTo(expected);
			assertThat(lotto.getNumbers()).isSorted();
		}

	}

}
