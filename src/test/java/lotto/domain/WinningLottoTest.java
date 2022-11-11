package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 정상적으로 입력된 경우")
    @Test
    void inputCorrectWinningNumberAndBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(List.of("1", "2", "3", "4", "5", "6"));
        winningLotto.pickBonusBall("45");
        assertThat(winningLotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getBonusBall()).isEqualTo(45);
    }

    @Nested
    class InputWinningBallTest {
        @DisplayName("당첨 번호에 숫자가 아닌 입력이 있는 경우")
        @Test
        void inputWinningNumberByNotNumber() {
            assertThatThrownBy(() -> new WinningLotto(List.of("A", "2", "3", "4", "5", "6")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호에 중복 입력이 있는 경우")
        @Test
        void inputWinningNumberByDuplicateNumber() {
            assertThatThrownBy(() -> new WinningLotto(List.of("1", "1", "3", "4", "5", "6")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 입력 개수가 6개가 넘은 경우")
        @Test
        void inputWinningNumberByOverSize() {
            assertThatThrownBy(() -> new WinningLotto(List.of("1", "2", "3", "4", "5", "6", "7")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호에 1~45 범위 밖 숫자 입력이 있는 경우")
        @Test
        void inputWinningNumberByNoLottoNumber() {
            assertThatThrownBy(() -> new WinningLotto(List.of("0", "46", "3", "4", "5", "6")))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class InputBonusBallTest {
        WinningLotto winningLotto = new WinningLotto(List.of("1", "2", "3", "4", "5", "6"));

        @DisplayName("보너스 번호에 숫자가 아닌 입력을 한 경우")
        @Test
        void inputBonusBallByNotNumber() {
            assertThatThrownBy(() -> winningLotto.pickBonusBall("test"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호에 1~45 범위 밖 숫자 입력한 경우")
        @Test
        void inputBonusBallByNoLottoNumber() {
            assertThatThrownBy(() -> winningLotto.pickBonusBall("47"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복인 경우")
        @Test
        void inputBonusBallByDuplicateWinningNumber() {
            assertThatThrownBy(() -> winningLotto.pickBonusBall("6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
