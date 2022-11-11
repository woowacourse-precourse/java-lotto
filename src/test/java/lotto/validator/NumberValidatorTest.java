package lotto.validator;

import static lotto.validator.ErrorMessages.INVALID_RANGE_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_TYPE_ERROR_MESSAGE;
import static lotto.validator.NumberValidator.hasValidRange;
import static lotto.validator.NumberValidator.hasValidType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
    @Test
    @DisplayName("로또 번호의 문자열 입력값에 정수가 아닌 요소가 포함되어 있으면 예외를 반환한다.")
    void validCheckOfInvalidTypeLotteryNumber() {
        //given
        String invalidTypeInput = "1,2,3,3.5";

        //when, then
        assertThatThrownBy(() -> hasValidType(invalidTypeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TYPE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호의 범위가 1과 45 사이가 아니면 예외를 반환한다.")
    void validCheckOfOutOfRangeLotteryNumber() {
        //given
        List<Integer> outOfRangeLotteryNumber = List.of(1, 2, 3, 4, 5, 4500);

        //when, then
        assertThatThrownBy(() -> outOfRangeLotteryNumber.forEach(NumberValidator::hasValidRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호의 문자열 입력값에 정수가 아닌 요소가 포함되어 있으면 예외를 반환한다.")
    void validCheckOfInvalidTypeBonusNumber() {
        //given
        String invalidTypeInput = "13h";

        //when, then
        assertThatThrownBy(() -> hasValidType(invalidTypeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TYPE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호의 범위가 1과 45 사이가 아니면 예외를 반환한다.")
    void validCheckOfRangeBonusNumber() {
        //given
        int outOfRangeNumber = 46;

        //when, then
        assertThatThrownBy(() -> hasValidRange(outOfRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_ERROR_MESSAGE);
    }
}
