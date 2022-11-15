package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    @DisplayName("보너스 번호의 개수가 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber(){
        assertThatThrownBy(() -> new Bonus(3,new Lotto(List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusByInvalidNumber(){
        assertThatThrownBy(() -> new Bonus(46, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
