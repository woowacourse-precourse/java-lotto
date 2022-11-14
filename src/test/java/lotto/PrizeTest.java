package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createPrizeByOverSize() {
        assertThatThrownBy(() -> new Prize(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
