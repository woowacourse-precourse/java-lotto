package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;



public class WinningLottoTest {
    @DisplayName("올바른 당첨 내역을 반환하는지 확인한다.")
    @Nested
    class checkWinningCTest {

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(6, 5, 4, 3, 2, 1), 7);

        @Test
        void winFirstPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat(winning.name()).isEqualTo("FIRST");
        }

        @Test
        void winSecondPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat(winning.name()).isEqualTo("SECOND");
        }

        @Test
        void winThirdPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat(winning.name()).isEqualTo("THIRD");
        }

        @Test
        void winFourthPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat(winning.name()).isEqualTo("FOURTH");
        }

        @Test
        void winFifthPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat(winning.name()).isEqualTo("FIFTH");
        }

        @Test
        void winNoPlace() {
            Lotto userLotto = new Lotto(List.of(10, 11, 12, 13, 14, 15));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat(winning.name()).isEqualTo("DEFAULT");
        }
    }
}
