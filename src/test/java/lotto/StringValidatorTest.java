package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringValidatorTest {

	StringValidator stringValidator = new StringValidator();

	@DisplayName("구입 금액이 숫자가 아니라면 예외가 발생한다.")
	@Test
	void checkIsNumberTest() {
		assertThatThrownBy(() -> stringValidator.checkIsNumber("힣"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구입 금액이 음수라면 예외가 발생한다.")
	@Test
	void checkIsNumberPositive() {
		assertThatThrownBy(() -> stringValidator.checkIsNumberPositive("-1000"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
