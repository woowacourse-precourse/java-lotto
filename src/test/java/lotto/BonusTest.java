package lotto;

import lotto.domain.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByNotNumber() {
        assertThatThrownBy(() -> new Bonus("woowa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createBonusByNotLottoNumber() {
        assertThatThrownBy(() -> new Bonus("55"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}