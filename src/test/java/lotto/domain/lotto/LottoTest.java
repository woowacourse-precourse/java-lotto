package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	Lotto lotto;
	@BeforeEach
	void setUp() {

	}

	@DisplayName("당첨 번호와 보너스번호 입력시 숫자인지 6개의 길이를 가지는지 1~45의 범위인지 중복되는 값이 포함되어있는지 여부 판단하여 예외 테스트")
	@Test
	void  예외_발생_테스트() {
		assertThatThrownBy(() -> new Lotto("A","B"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Lotto("1,2,3,4","7"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Lotto("1,2,3,4,5,46","7"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6","1"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}