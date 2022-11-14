package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.constants.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void getBonusNumber_7_7() {
        LottoWithBonus bonusNumber = new LottoWithBonus(lotto, 7);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("Contains Bonus")
    @ParameterizedTest(name = "{index} input {0} ")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void validateContains_123456_6_NOTCONTAINS() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoWithBonus(lotto, 6);
        });
        assertEquals(ErrorCode.NOT_CONTAINS_IN_LOTTO.getErrorMessage(), exception.getMessage());
    }

    @DisplayName("unvalidated Range")
    @ParameterizedTest(name = "{index} input {0} ")
    @ValueSource(ints = {-1, 0, 46})
    void validateRange_0or46_NOTINRANGE(int bonus) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoWithBonus(lotto, bonus);
        });
        assertEquals(ErrorCode.NOT_IN_RANGE.getErrorMessage(), exception.getMessage());
    }
}