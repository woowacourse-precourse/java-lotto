package lotto.domain.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BonusNumberValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    
    @DisplayName("예외 처리 : 보너스 번호가 1~45 의 범위를 벗어난 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 46})
    void outOfRangeException(final int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BonusNumberValidator.validate(new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 중복되는 번호가 있는 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {1, 6})
    void duplicateLottoNumberException(final int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BonusNumberValidator.validate(new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}