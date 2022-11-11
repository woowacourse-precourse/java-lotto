package lotto.validator;

import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
import static lotto.constants.LottoConstant.VALID_MAX_RANGE;
import static lotto.validator.BonusNumberValidator.hasValidBonusNumber;
import static lotto.validator.ErrorMessages.DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_RANGE_ERROR_MESSAGE;
import static lotto.validator.NumberValidator.hasNonDuplicateNumbers;
import static lotto.validator.NumberValidator.hasValidRange;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    @Test
    @DisplayName("당첨 번호와 겹치는 보너스 번호인 경우 예외를 반환한다.")
    void validCheckOfDuplicateBonusNumber() {
        //given
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int duplicateBonusNumber = lottoNumbers.get(0);
        lottoNumbers.add(duplicateBonusNumber);

        //when, then
        assertThatThrownBy(() -> hasNonDuplicateNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("범위에 맞지 않는 보너스 번호인 경우 예외를 반환한다.")
    void validCheckOfOutOfRangeBonusNumber() {
        //given
        int validInput = VALID_MAX_RANGE + 1;

        //when, then
        assertThatThrownBy(() -> hasValidRange(validInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("조건에 맞는 보너스 번호인 경우 유효성 검사를 모두 통과한다.")
    void validCheckOfValidBonusNumber() {
        //given
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int validInput = 7;

        //when, then
        assertThatNoException().isThrownBy(() -> hasValidBonusNumber(lottoNumbers, validInput));
    }
}
