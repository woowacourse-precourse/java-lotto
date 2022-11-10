package lotto;

import java.util.Arrays;
import javax.swing.JApplet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Nested
    class duplicateNumberTest {
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void createWinningLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 2))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("범위를 벗어난 번호가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 4, 2 ,3, 50, 11)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어날 시 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 없이 로또 번호가 생성되는지 확인한다.")
    @Test
    void createLottosWithNoExcpetion() {
        assertDoesNotThrow(() -> {
            Lotto.generate();
        });
    }

    @DisplayName("올바른 당첨 내역을 반환하는지 확인한다.")
    @Nested
    class checkWinningCTest {

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(6, 5, 4, 3, 2, 1), 7);

        @Test
        void winFirstPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat("FIRST".equals(winning.name())).isTrue();
        }

        @Test
        void winSecondPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat("SECOND".equals(winning.name())).isTrue();
        }

        @Test
        void winThirdPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
            Winning winning = Application.getWinning(userLotto, winningLotto);


            assertThat("THIRD".equals(winning.name())).isTrue();
        }

        @Test
        void winForthPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat("FOURTH".equals(winning.name())).isTrue();
        }

        @Test
        void winFifthPlace() {
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertThat("FIFTH".equals(winning.name())).isTrue();
        }

        @Test
        void winNoPlace() {
            Lotto userLotto = new Lotto(List.of(10, 11, 12, 13, 14, 15));
            Winning winning = Application.getWinning(userLotto, winningLotto);

            assertNull(winning);
        }
    }
}
