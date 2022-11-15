package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.controller.LottoNumbersGenerator;

class LottoNumbersGeneratorTest {
	@DisplayName("사용자가 정상적으로 로또 숫자를 입력했을 때.")
	@Test
	void createLottoRightWay() {
		assertThat(LottoNumbersGenerator.generate("1,2,3,4,5,6")).isEqualTo(
			List.of(1, 2, 3, 4, 5, 6));
	}

	@DisplayName("사용자가 비정상적인 문자를 입력했을 때.")
	@Test
	void createLottoByInvalidCharater() {
		assertThatThrownBy(() -> LottoNumbersGenerator.generate("1,2,3,4,5,a"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> LottoNumbersGenerator.generate("1,2,3,4,5,6 "))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
