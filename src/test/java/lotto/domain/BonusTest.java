package lotto.domain;

import static lotto.domain.Bonus.validateDuplicates;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    @Test
    void 올바른_입력() {
        Assertions.assertEquals(6, new Bonus("6").getBonusNumber());
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호는 예외 처리한다.")
    @Test
    void 당첨번호와_중복된_입력() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus("6");
        assertThatThrownBy(() -> validateDuplicates(lotto.getWinningNumbers(), bonus.getBonusNumber()))
                .isInstanceOf(IllegalArgumentException.class);

    }
}