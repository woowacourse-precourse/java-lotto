package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.TargetNumbers;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class TargetNumberTest {
    @DisplayName("당첨번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinNumberByOverSize() {
        assertThatThrownBy(() -> TargetNumbers.getInstance("1,2,3,4,5,6,7")
                .isInstanceOf(IllegalArgumentException.class));
    }

}