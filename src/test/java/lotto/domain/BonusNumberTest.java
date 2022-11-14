package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
	@DisplayName("보너스 번호가 1~45가 아니라면 예외가 발생한다.")
	@Test
	void createBonusNumberByInvalidNumber() {
		assertThatThrownBy(() -> new BonusNumber(46))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
