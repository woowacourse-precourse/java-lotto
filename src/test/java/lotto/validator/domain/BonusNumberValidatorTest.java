package lotto.validator.domain;

import lotto.constants.ErrorMessageConstant;
import lotto.domain.LottoTest;
import lotto.validator.domain.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class BonusNumberValidatorTest {
    @Test
    @DisplayName("올바른 보너스 번호 입력 시")
    void correctBonusNumber() {
        assertThatNoException()
                .isThrownBy(() -> BonusNumberValidator.validate(LottoTest.FROM_ONE_TO_SIX, 7));
    }
    
    @DisplayName("예외 처리 : 보너스 번호가 1~45 의 범위를 벗어난 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 46})
    void outOfRangeException(final int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BonusNumberValidator.validate(LottoTest.FROM_ONE_TO_SIX, bonusNumber))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 중복되는 번호가 있는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {1, 6})
    void duplicateLottoNumberException(final int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BonusNumberValidator.validate(LottoTest.FROM_ONE_TO_SIX, bonusNumber))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}