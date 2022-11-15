package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

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

	// 아래에 추가 테스트 작성 가능
	@DisplayName("로또 번호에 1보다 작거나 45보다 큰 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByNumbersInAdditionToForm() {
		assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 25, 35, 46)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또 구입 시 정렬이 되는지 확인하는 테스트")
	void checkSortedNumberTest() {
		Lotto lotto = new Lotto(Arrays.asList(7, 4, 2, 8, 1, 5));
		Assertions.assertThat(lotto.getNumbers()).isSorted();
	}
}
