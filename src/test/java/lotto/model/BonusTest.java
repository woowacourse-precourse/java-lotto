package lotto.model;

import static lotto.model.Bonus.validateDuplicates;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    @ParameterizedTest
    @ValueSource(strings = {"6", "6    ", "   6  ", "006", "    0   6"})
    void 올바른_입력(String input) {
        Assertions.assertEquals(6, new Bonus(input).getBonusNumber());
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