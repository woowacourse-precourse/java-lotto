package lotto.model;

import lotto.model.JackpotBonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

public class JackpotBonusTest {
    private static final JackpotBonus jackpotBonus = new JackpotBonus(List.of(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberByDuplicateNumber() {
        List<Integer> jackpotNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new JackpotBonus(jackpotNumbers, bonusNumber);
                });
    }
}
