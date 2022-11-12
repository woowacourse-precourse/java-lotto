package lotto;

import lotto.Model.JudgmentModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

class JudgmentTest {
    private JudgmentModel judgment;
    private Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private Bonus bonus = new Bonus(7, winningLotto);

    @DisplayName("compare 메소드 테스트")
    @Nested
    class compareTest {
        @BeforeEach
        void setup() {
            judgment = new JudgmentModel();
        }

        @DisplayName("0개 매치")
        @Test
        void case1() {
            Lotto myLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
            int result = 0;
            int actual = judgment.compare(winningLotto, myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("1개 매치")
        @Test
        void case2() {
            Lotto myLotto = new Lotto(List.of(6, 7, 8, 9, 10, 11));
            int result = 1;
            int actual = judgment.compare(winningLotto, myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("2개 매치")
        @Test
        void case3() {
            Lotto myLotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
            int result = 2;
            int actual = judgment.compare(winningLotto, myLotto);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("3개 매치")
        @Test
        void case4() {
            Lotto myLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));
            int result = 3;
            int actual = judgment.compare(winningLotto, myLotto);

            assertThat(actual).isEqualTo(result);
        }
    }

    @DisplayName("hasBonusNumber 메소드 테스트")
    @Nested
    class hasBonusNumberTest {
        @BeforeEach
        void setup() {
            judgment = new JudgmentModel();
        }

        @DisplayName("매치하는 경우")
        @Test
        void case1() {
            Lotto myLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
            boolean result = true;
            boolean actual = judgment.hasBonusNumber(myLotto, bonus);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("매치하지 않는 경우")
        @Test
        void case2() {
            Lotto myLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
            boolean result = false;
            boolean actual = judgment.hasBonusNumber(myLotto, bonus);

            assertThat(actual).isEqualTo(result);
        }
    }
}
