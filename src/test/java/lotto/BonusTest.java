package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("보너스 번호가 45를 넘어가면 에러가 발생한다.")
    @Test
    void createBonusOver45() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 46))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작으면 에러가 발생한다.")
    @Test
    void createBonusUnder1() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}