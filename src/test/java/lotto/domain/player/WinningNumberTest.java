package lotto.domain.player;

import lotto.domain.util.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {
	@DisplayName("유저가 당첨번호 입력시 WinningNumber 객체 생성을 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "5,10,20,30,40,45"})
	void verifyWinningNumberProperlyReceived(String input) {
		assertThat(WinningNumber.from(input)).isInstanceOf(WinningNumber.class);
	}

	@DisplayName("유저가 당첨번호를 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"123456", "1 2 3 4 5 6"})
	void verifyWinningNumberNotCorrectlyFormatted(String input) {
		assertThatThrownBy(() -> WinningNumber.from(input))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.WINNING_NUMBER_NOT_CORRECTLY_FORMATTED);
	}

	@DisplayName("유저가 당첨번호를 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "10,20,30,40,50,60,70"})
	void verifyWinningNumberNotCorrectlyCounted(String input) {
		assertThatThrownBy(() -> WinningNumber.from(input))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.WINNING_NUMBER_NOT_CORRECTLY_COUNTED);
	}

	@DisplayName("유저가 당첨번호를 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
	void verifyWinningNumberNotInBetween1and45(String input) {
		assertThatThrownBy(() -> WinningNumber.from(input))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.WINNING_NUMBER_NOT_IN_BETWEEN_1_45);
	}

	@DisplayName("유저가 당첨번호를 잘못된 값으로 입력시 Exception 발생과 메시지를 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,5"})
	void verifyWinningNumberDuplicated(String input) {
		assertThatThrownBy(() -> WinningNumber.from(input))
				.isInstanceOf(ValidationException.class)
				.hasMessage(ValidationException.WINNING_NUMBER_DUPLICATED);
	}

	@DisplayName("유저가 당첨번호를 잘못된 값으로 입력시 Exception 발생을 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"a,b,c,d,e,f", "1,2,3,4,5,a"})
	void verifyWinningNumberContainsOnlyNumber(String input) {
		assertThatThrownBy(() -> WinningNumber.from(input))
				.isInstanceOf(NumberFormatException.class);
	}
}
