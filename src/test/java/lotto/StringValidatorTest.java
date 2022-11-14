package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringValidatorTest {

	StringValidator stringValidator = new StringValidator();
	Lotto sampleLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

	@DisplayName("구입 금액이 숫자가 아니라면 예외가 발생한다.")
	@Test
	void checkIsNumberTest() {
		assertThatThrownBy(() -> stringValidator.checkIsNumber("힣"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구입 금액이 음수라면 예외가 발생한다.")
	@Test
	void checkIsNumberPositiveTest() {
		assertThatThrownBy(() -> stringValidator.checkIsPositiveNumber("-1000"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
	@Test
	void checkIsMultipliedBy1000Test() {
		assertThatThrownBy(() -> stringValidator.checkIsMultipliedBy1000("30001"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
	@Test
	void validateBonusStringTest1() {
		assertThatThrownBy(() -> stringValidator.validateBonusString("3하", sampleLotto))
			.isInstanceOf(IllegalArgumentException.class);
	}
	@DisplayName("보너스 번호가 범위 내의 숫자가 아니라면 예외가 발생한다.")
	@Test
	void validateBonusStringTest2() {
		assertThatThrownBy(() -> stringValidator.validateBonusString("46", sampleLotto))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 당첨 번호에 포함되었다면 예외가 발생한다.")
	@Test
	void validateBonusStringTest3() {
		assertThatThrownBy(() -> stringValidator.validateBonusString("6", sampleLotto))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
