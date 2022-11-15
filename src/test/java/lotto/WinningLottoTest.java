package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    void createByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6),6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void createByNotRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6),46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}