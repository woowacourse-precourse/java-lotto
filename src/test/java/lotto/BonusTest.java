package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
	@DisplayName("보너스 번호가 1보다 작으면 예외 발생")
	@Test
	void inputBySmallNumber() {
		assertThatThrownBy(() -> new Bonus(0))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("보너스 번호가 45보다 크면 예외 발생")
	@Test
	void inputByBiggerNumber() {
		assertThatThrownBy(() -> new Bonus(46))
			.isInstanceOf(IllegalArgumentException.class);
	}
}