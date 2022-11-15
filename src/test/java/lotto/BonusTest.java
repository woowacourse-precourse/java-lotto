package lotto;

import lotto.exception.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @DisplayName("보너스 번호가 숫자가 아닐 경우 오류가 발생한다.")
    @Test
    void createBonusByNotNumber() {
        assertThatThrownBy(() ->
                BonusNumber.exceptionBonusNumber("a",List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }


}