package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
	@Test
	@DisplayName("로또 번호가 범위에 맞지 않으면 예외 발생")
	void checkRangeNumbersTest() {
		assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("기존 로또 번호와 새롭게 반환 받은 로또 번호는 동일")
	void getLottoNumbersTest() {
		List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
		Lotto lotto = new Lotto(lottoNumbers);

		List<Integer> getNumbers = lotto.getNumbers();
		Assertions.assertThat(getNumbers).isEqualTo(lottoNumbers);
	}
}
