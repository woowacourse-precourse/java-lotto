package lotto.model;

import lotto.domain.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("입력된 보너스 번호가 1~45 범위를 벗어나는 경우 예외가 발생한다.")
    @Test
    void 보너스_번호_범위_벗어난_경우_예외_테스트() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
