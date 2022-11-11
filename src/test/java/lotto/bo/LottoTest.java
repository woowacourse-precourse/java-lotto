package lotto.bo;

import lotto.model.Checker;
import lotto.model.Checker.WinningPlace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 3, 4, 5, 10, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class CheckerTest {
        private Lotto lotto;

        @BeforeEach
        public void setupForTest() {
            lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @DisplayName("숫자 6개가 일치할 경우 1등")
        @Test
        void calcWinningPlaceFirst() {
            WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");
            WinningPlace actual = Checker.calcWinningPlace(lotto, winningNumber);
            WinningPlace expected = WinningPlace.FIRST;

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("숫자 5개 + 보너스번호가 일치할 경우 2등")
        @Test
        void calcWinningPlaceSecond() {
            WinningNumber winningNumber = new WinningNumber("1,2,4,3,5,7", "6");
            WinningPlace actual = Checker.calcWinningPlace(lotto, winningNumber);
            WinningPlace expected = WinningPlace.SECOND;

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("숫자 5개 일치할 경우 3등")
        @Test
        void calcWinningPlaceThird() {
            WinningNumber winningNumber = new WinningNumber("1,2,4,3,5,7", "8");
            WinningPlace actual = Checker.calcWinningPlace(lotto, winningNumber);
            WinningPlace expected = WinningPlace.THIRD;

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("숫자 4개 일치할 경우 4등")
        @Test
        void calcWinningPlaceFourth() {
            WinningNumber winningNumber = new WinningNumber("1,9,4,3,5,7", "6");
            WinningPlace actual = Checker.calcWinningPlace(lotto, winningNumber);
            WinningPlace expected = WinningPlace.FOURTH;

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("숫자 3개 일치할 경우 5등")
        @Test
        void calcWinningPlaceFifth() {
            WinningNumber winningNumber = new WinningNumber("1,9,10,3,5,7", "6");
            WinningPlace actual = Checker.calcWinningPlace(lotto, winningNumber);
            WinningPlace expected = WinningPlace.FIFTH;

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("숫자 3개 이하로 일치할 경우 NOTHING")
        @Test
        void calcWinningPlaceNothing() {
            WinningNumber winningNumber = new WinningNumber("1,9,4,10,28,7", "6");
            WinningPlace actual = Checker.calcWinningPlace(lotto, winningNumber);
            WinningPlace expected = WinningPlace.NOTHING;

            assertThat(actual).isEqualTo(expected);
        }
    }

}
