package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoInfoTest {
    @DisplayName("보너스 번호가 1~45 범위를 벗어날 때 예외가 발생한다.")
    @Test
    void createLottoInfoByOutOfRangeBonusNum() {
        assertThatThrownBy(() -> new LottoInfo(new Lotto(List.of(49, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 때 예외가 발생한다.")
    @Test
    void createLottoInfoByOutOfRangeBonusNum2() {
        assertThatThrownBy(() -> new LottoInfo(new Lotto(List.of(49, 2, 3, 4, 5, 6)), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
