package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    @DisplayName("보너스 번호의 범위가 1보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRange() {
        assertThatThrownBy(() -> new Bonus(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 45보다 크면 예외가 발생한다.")
    @Test
    void creatBonusByOverRange() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
