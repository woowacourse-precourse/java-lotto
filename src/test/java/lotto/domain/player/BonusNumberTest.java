package lotto.domain.player;

import lotto.domain.util.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {
	private WinningNumber winningNumber;

	@BeforeEach
	void ObjectSetUp() {
		winningNumber = WinningNumber.from("1,2,3,4,5,6");
	}

	@DisplayName("유저가 보너스번호 입력시 BonusNumber 객체 생성을 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6"})
	void verifyBonusNumberProperlyReceived() {
		assertThat(BonusNumber.from("7", winningNumber)).isInstanceOf(BonusNumber.class);
	}

	@DisplayName("유저가 보너스번호를 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"0", "46"})
	void verifyBonusNumberNotInBetween1and45(String input) {
		assertThatThrownBy(() -> BonusNumber.from(input, winningNumber))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.BONUS_NUMBER_NOT_IN_BETWEEN_1_45);
	}

	@DisplayName("유저가 보너스번호를 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"1,2"})
	void verifyBonusNumberNotCorrectlyCounted(String input) {
		assertThatThrownBy(() -> BonusNumber.from(input, winningNumber))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.BONUS_NUMBER_NOT_CORRECTLY_COUNTED);
	}

	@DisplayName("유저가 보너스번호를 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	void verifyBonusNumberDuplicated(String input) {
		assertThatThrownBy(() -> BonusNumber.from(input, winningNumber))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.BONUS_NUMBER_DUPLICATED);
	}

	@DisplayName("유저가 당첨번호를 잘못된 값으로 입력시 Exception 발생을 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"a"})
	void verifyBonusNumberContainsOnlyNumber(String input) {
		assertThatThrownBy(() -> BonusNumber.from(input, winningNumber))
				.isInstanceOf(NumberFormatException.class);
	}
}
