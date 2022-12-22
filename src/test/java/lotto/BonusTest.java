package lotto;

import lotto.domain.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    @DisplayName("보너스 번호가 6개의 로또 번호에 이미 존재하면 예외가 발생한다.")
    @Test
    void createBonusByAlreadyExist() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
