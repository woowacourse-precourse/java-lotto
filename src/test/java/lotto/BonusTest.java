package lotto;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicateLotto() {
        assertThatThrownBy(() -> new Bonus(1, List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusByOutRange() {
        assertThatThrownBy(() -> new Bonus(-3, List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 보너스 번호 입력시 예외가 발생하지 않는다.")
    @Test
    void createBonusBySuccess() {
        assertDoesNotThrow(() -> new Bonus(10, List.of(1, 2, 3, 4, 5, 6)));
    }

}
