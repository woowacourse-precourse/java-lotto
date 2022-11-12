package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    void validateBonusDuplication() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.DUPLICATION_ERROR_MESSAGE);
    }

    @Test
    void validateBonusNumberScope() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.SCOPE_ERROR_MESSAGE);
    }
}