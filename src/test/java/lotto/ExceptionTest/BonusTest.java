package lotto.ExceptionTest;

import lotto.Model.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    @DisplayName("보너스 번호가 로또 번호와 중복이면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> new Bonus(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 번호가 1~45까지의 정수가 아니면 예외가 발생한다.")
    @Test
    void createBonusByInvalidRangeNumber() {
        assertThatThrownBy(() -> new Bonus(47, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
