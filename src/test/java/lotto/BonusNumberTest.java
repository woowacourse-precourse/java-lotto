package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,7));

    @DisplayName("보너스 번호가 2개 이상인 경우 예외 발생")
    @Test
    void case1() {
        List<Integer> bonus = List.of(19,2);
        assertThatThrownBy(() -> new BonusNumber(bonus, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함된 경우 예외 발생")
    @Test
    void case2() {
        List<Integer> bonus = List.of(5);
        assertThatThrownBy(() -> new BonusNumber(bonus, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닌 경우 예외 발생")
    @Test
    void case3() {
        List<Integer> bonus = List.of(60);
        assertThatThrownBy(() -> new BonusNumber(bonus, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
