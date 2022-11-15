package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    void createByDuplicatedNumber() {
        // expect
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호와 보너스 번호는 달라야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호는 숫자로만 이루어져야 한다.")
    void createWinningByOnlyNumber() {
        // expect
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,j", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자와 ,만 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 번호는 숫자로만 이루어져야 한다.")
    void createBonusByOnlyNumber() {
        // expect
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해 주세요.");
    }
}
