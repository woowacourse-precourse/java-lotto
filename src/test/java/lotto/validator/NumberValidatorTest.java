package lotto.validator;

import static lotto.validator.ErrorMessages.DUPLICATE_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_LENGTH_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_RANGE_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_TYPE_ERROR_MESSAGE;
import static lotto.validator.NumberValidator.hasNonDuplicateNumbers;
import static lotto.validator.NumberValidator.hasValidBonusNumber;
import static lotto.validator.NumberValidator.hasValidLength;
import static lotto.validator.NumberValidator.hasValidLotteryNumber;
import static lotto.validator.NumberValidator.hasValidRange;
import static lotto.validator.NumberValidator.hasValidType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외를 반환한다.")
    void validCheckOfOversizeLotteryNumber() {
        //given
        List<Integer> oversizeLotteryNumber = List.of(1, 2, 3, 4, 5, 6, 7);

        //when, then
        assertThatThrownBy(() -> hasValidLength(oversizeLotteryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LENGTH_ERROR_MESSAGE);
    }

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
        assertThatThrownBy(() -> hasValidRange(outOfRangeLotteryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외를 반환한다.")
    void validCheckOfDuplicateLotteryNumber() {
        //given
        List<Integer> duplicateInput = List.of(1, 2, 3, 4, 5, 5);

        //when, then
        assertThatThrownBy(() -> hasNonDuplicateNumbers(duplicateInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("조건에 맞는 로또 번호인 경우 유효성 검사를 모두 통과한다.")
    void validCheckOfValidLotteryNumber() {
        //given
        List<Integer> validInput = List.of(1, 2, 3, 4, 5, 6);

        //when, then
        assertThatNoException().isThrownBy(() -> hasValidLotteryNumber(validInput));
    }

    @Test
    @DisplayName("로또 번호의 문자열 입력값에 정수가 아닌 요소가 포함되어 있으면 예외를 반환한다.")
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

    @Test
    @DisplayName("조건에 맞는 보너스 번호인 경우 유효성 검사를 모두 통과한다.")
    void validCheckOfValidBonusNumber() {
        //given
        int validInput = 3;

        //when, then
        assertThatNoException().isThrownBy(() -> hasValidBonusNumber(validInput));
    }
}
