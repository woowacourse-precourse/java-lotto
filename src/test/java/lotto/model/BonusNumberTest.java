package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.constants.ErrorCode;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void getBonusNumber_7_7() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(lotto, 7);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void validateContains_exception_message_test() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(lotto, 6);
        });
        assertEquals(ErrorCode.NOT_CONTAINS_IN_LOTTO.getErrorMessage(), exception.getMessage());
    }

}