package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("보너스 숫자가 티켓 범위가 아니면 예외가 발생한다.")
    @Test
    void 보너스_생성_예외_테스트() {
        int bonus = 47;
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}