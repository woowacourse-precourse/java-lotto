package lotto.validator;

import static lotto.validator.BonusNumberValidator.hasValidBonusNumber;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    @Test
    @DisplayName("조건에 맞는 보너스 번호인 경우 유효성 검사를 모두 통과한다.")
    void validCheckOfValidBonusNumber() {
        //given
        int validInput = 3;

        //when, then
        assertThatNoException().isThrownBy(() -> hasValidBonusNumber(validInput));
    }
}
