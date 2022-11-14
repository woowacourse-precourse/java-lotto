package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.constants.ErrorCode;
import lotto.domain.vo.Lotto;
import org.junit.jupiter.api.Test;

class LottoWithBonusTest {

    @Test
    void getBonusNumber_7_7() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWithBonus bonusNumber = new LottoWithBonus(lotto, 7);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void validateContains_exception_message_test() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoWithBonus(lotto, 6);
        });
        assertEquals(ErrorCode.NOT_CONTAINS_IN_LOTTO.getErrorMessage(), exception.getMessage());
    }

}