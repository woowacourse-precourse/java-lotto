package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserTest {

    private User user = new User();

    private List winningNumberCase1 = List.of("1", "1", "1", "1", "1", "1");
    private List winningNumberCase2 = List.of("1", "2");
    private List winningNumberCase3 = List.of("1", "2", "3", "4", "5", "47");

    private List winningNumberCase4 = List.of(1, 2, 3, 4, 5, 6);
    private int bonusNumberCase1 = 6;

    @Test
    void 당첨_번호_중복_입력_예외() {
        Assertions.assertThatThrownBy(() -> user.enterWinningNumberValidation(winningNumberCase1))
                .hasMessageContaining("[ERROR] 중복되는 숫자가 있습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_입력_개수_예외() {
        Assertions.assertThatThrownBy(() -> user.enterWinningNumberValidation(winningNumberCase2))
                .hasMessageContaining("[ERROR] 6자리 숫자를 입력해주세요")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_입력_범위_예외() {
        Assertions.assertThatThrownBy(() -> user.enterWinningNumberValidation(winningNumberCase3))
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_예외() {
        Assertions.assertThatThrownBy(() -> user.enterBonusNumberValidation(winningNumberCase4, bonusNumberCase1))
                .hasMessageContaining("[ERROR] 로또 번호와 보너스 번호가 중복됩니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

}