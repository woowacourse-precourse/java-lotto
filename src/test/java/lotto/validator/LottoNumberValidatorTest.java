package lotto.validator;

import static lotto.validator.ErrorMessages.DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_LENGTH_ERROR_MESSAGE;
import static lotto.validator.LottoNumberValidator.hasNonDuplicateNumbers;
import static lotto.validator.LottoNumberValidator.hasValidLength;
import static lotto.validator.LottoNumberValidator.hasValidLotteryNumber;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {
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
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외를 반환한다.")
    void validCheckOfDuplicateLotteryNumber() {
        //given
        List<Integer> duplicateInput = List.of(1, 2, 3, 4, 5, 5);

        //when, then
        assertThatThrownBy(() -> hasNonDuplicateNumbers(duplicateInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("조건에 맞는 로또 번호인 경우 유효성 검사를 모두 통과한다.")
    void validCheckOfValidLotteryNumber() {
        //given
        List<Integer> validInput = List.of(1, 2, 3, 4, 5, 6);

        //when, then
        assertThatNoException().isThrownBy(() -> hasValidLotteryNumber(validInput));
    }


}
