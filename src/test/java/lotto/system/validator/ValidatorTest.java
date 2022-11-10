package lotto.system.validator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.system.holder.ValidationHolder;
import lotto.vo.LottoAmount;

class ValidatorTest {

	@BeforeEach
	void setup() {
		ValidationHolder.initializeValidators(List.of(new StringToLottoAmountValidator()));
	}

	@AfterEach
	void runAfter() {
		ValidationHolder.clearHolder();
	}

	@Test
	@DisplayName("유효한 String 을 LottoAmount 로 바꾸기 위해 검증 작업을 받으면 검증을 통과한다.")
	void givenValidString_whenValidatingForLottoAmount_thenPassesValidation() {
	    //given
		String input = "14000";

	    //when & then
		assertDoesNotThrow(() -> ValidationHolder.validate(input, LottoAmount.class));
	}

	@Test
	@DisplayName("한 장도 살 수 없는 금액의 String 을 LottoAmount 로 바꾸기 위해 검증 작업을 받으면 예외가 발생한다.")
	void givenStringLowerThanLotto_whenValidatingForLottoAmount_thenThrowsException() {
	    //given
		String input = "0";

	    //when & then
		assertThatThrownBy(() -> ValidationHolder.validate(input, LottoAmount.class))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(StringToLottoAmountValidator.LOWER_THEN_MIN_VALUE_MESSAGE);
	}

	@Test
	@DisplayName("1,000 으로 나누어지지 않는 금액의 String 을 LottoAmount 로 바꾸기 위해 검증 작업을 받으면 예외가 발생한다.")
	void givenStringNotDividedIn1000_whenValidatingForLottoAmount_thenThrowsException() {
	    //given
		String input = "14500";

	    //when & then
		assertThatThrownBy(() -> ValidationHolder.validate(input, LottoAmount.class))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(StringToLottoAmountValidator.NOT_DIVIDED_VALUE_MESSAGE);
	}

	@Test
	@DisplayName("정수가 아닌 값이 적힌 String 을 LottoAmount 로 바꾸기 위해 검증 작업을 받으면 예외가 발생한다.")
	void givenStringNotOnlyInteger_whenValidatingForLottoAmount_thenThrowsException() {
	    //given
		String input = "45.000";

	    //when & then
		assertThatThrownBy(() -> ValidationHolder.validate(input, LottoAmount.class))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(StringToLottoAmountValidator.NOT_NATURAL_NUMBER_MESSAGE);
	}

	@Test
	@DisplayName("숫자 사이에 , 을 넣는 것은 예외적으로 입력을 허용해준다.")
	void givenStringWithRest_whenValidatingForLottoAmount_thenPassesValidation() {
	    //given
		String input = "45,000,000";

	    //when & then
		assertDoesNotThrow(() -> ValidationHolder.validate(input, LottoAmount.class));
	}
}