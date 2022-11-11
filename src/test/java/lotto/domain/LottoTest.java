package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 숫자범위(1~45)를 넘어가는 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByBoundaryNumber1() {
		assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 숫자범위(1~45)를 넘어가는 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByBoundaryNumber2() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 46, 4, 5, 6)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
