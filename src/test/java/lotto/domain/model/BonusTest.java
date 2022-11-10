package lotto.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("보너스 번호 객체 생성 테스트")
    @Test
    void createBonus() {
        Assertions.assertThat(new Bonus(new FirstPlace("1,2,3,4,5,6"), "7")).isEqualTo(new Bonus(7));
    }

    @DisplayName("보너스 번호가 로또번호랑 겹치면 예외가 발생한다.")
    @Test
    void createBonusDuplicateByFirstPlace() {
        Assertions.assertThatThrownBy(() -> new Bonus(new FirstPlace("1,2,3,4,5,6"), "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}