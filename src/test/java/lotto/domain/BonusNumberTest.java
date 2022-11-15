package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @DisplayName("보너스 번호는 로또 당첨 번호와 중복되지 않는다.")
    @Test
    void winLottoContainsBonusNumberTest() {
        assertThatThrownBy(() -> {
            new BonusNumber(1, new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 1~45 사이의 숫자여야 한다.")
    @Test
    void bonusNumberInNumberRangeTest() {
        assertThatThrownBy(() -> {
            new BonusNumber(333, new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
