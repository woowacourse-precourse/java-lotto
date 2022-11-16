package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

class LottoTest {
    private Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private Bonus bonus = new Bonus(7, winningLotto);

    @DisplayName("countMatch 메소드 테스트")
    @Nested
    class countMatch {
        @DisplayName("0개 매치")
        @Test
        void case1() {
            Lotto myLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
            int result = 0;
            int actual = winningLotto.countMatch(myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("1개 매치")
        @Test
        void case2() {
            Lotto myLotto = new Lotto(List.of(6, 7, 8, 9, 10, 11));
            int result = 1;
            int actual = winningLotto.countMatch(myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("2개 매치")
        @Test
        void case3() {
            Lotto myLotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
            int result = 2;
            int actual = winningLotto.countMatch(myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("3개 매치")
        @Test
        void case4() {
            Lotto myLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));
            int result = 3;
            int actual = winningLotto.countMatch(myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("4개 매치")
        @Test
        void case5() {
            Lotto myLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
            int result = 4;
            int actual = winningLotto.countMatch(myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("5개 매치")
        @Test
        void case6() {
            Lotto myLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));
            int result = 5;
            int actual = winningLotto.countMatch(myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("6개 매치")
        @Test
        void case7() {
            Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int result = 6;
            int actual = winningLotto.countMatch(myLotto);

            assertThat(actual).isEqualTo(result);
        }
    }

    @DisplayName("hasBonusNumber 메소드 테스트")
    @Nested
    class hasBonusNumberTest {
        @DisplayName("매치하는 경우")
        @Test
        void case1() {
            Lotto myLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
            boolean result = true;
            boolean actual = myLotto.hasBonusNumber(bonus);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("매치하지 않는 경우")
        @Test
        void case2() {
            Lotto myLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
            boolean result = false;
            boolean actual = myLotto.hasBonusNumber(bonus);

            assertThat(actual).isEqualTo(result);
        }
    }
}
