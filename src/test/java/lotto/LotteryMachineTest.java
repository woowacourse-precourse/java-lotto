package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {
    static private Lotto lotto;

    @BeforeAll
    static void initLotto() {
        lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 당첨 번호와 보너스 번호가 같은 경우 예외가 발생")
    @Test
    void winningNumberAndBonusNumberCannotBeSame() {
        assertThatThrownBy(() -> new LotteryMachine(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스번호는 6개의 로또 번호와 다른 숫자여야 합니다.");

    }

    @Test
    @DisplayName("보너스번호가 1~45내의 값이 아니라면")
    void invalidBonusNumber() {
        assertThatThrownBy(() -> new LotteryMachine(lotto, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스번호는 1-45 범위 내의 숫자여야 합니다.");
    }
}