package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createPrizeByOverSize() {
        assertThatThrownBy(() -> new Prize(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createPrizeByDuplicatedNumber() {
        assertThatThrownBy(() -> new Prize(List.of(1, 2, 3, 3, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호의 숫자와 중복되면 예외가 발생한다.")
    @Test
    void createPrizeByBonusNumberAndWinningNumberOverlap() {
        assertThatThrownBy(() -> new Prize(List.of(1, 2, 3, 4, 6, 7), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
