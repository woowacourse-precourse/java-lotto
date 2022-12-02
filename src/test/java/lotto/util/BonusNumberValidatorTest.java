package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.model.numbers.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {

    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void setUp() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외 처리한다.")
    @Test
    void 당첨_번호와_중복() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> bonusNumberValidator.validateDuplicates("1", lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage());
    }

}