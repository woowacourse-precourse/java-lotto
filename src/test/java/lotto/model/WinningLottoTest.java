package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    private static final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호가 1~45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void bonusNumberOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto(lotto, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
    @Test
    void bonusNumberDuplicated() {
        assertThatThrownBy(() -> new WinningLotto(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
