package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @DisplayName("보너스 번호가 1부터 45를 벗어난 숫자일 경우 예외가 발생한다.")
    @Test
    void createBonusByOverRange() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Bonus(46))
                  .isInstanceOf(IllegalArgumentException.class);
    }
}