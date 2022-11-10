package lotto.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BonusNumberValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    
    @DisplayName("예외 처리 : 보너스 번호가 1~45 의 범위를 벗어난 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 46})
    void outOfRangeException(final int lottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BonusNumberValidator.validate(lottoNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}