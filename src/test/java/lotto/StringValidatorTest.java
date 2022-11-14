package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringValidatorTest {

	StringValidator stringValidator = new StringValidator();

	@DisplayName("문자열이 숫자가 아니라면 예외가 발생한다.")
	@Test
	void checkIsNumberTest() {
		assertThatThrownBy(() -> stringValidator.checkIsNumber("힣"))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
