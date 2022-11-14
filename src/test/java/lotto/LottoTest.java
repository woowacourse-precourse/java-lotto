package lotto;

import static lotto.domain.lotto.Lotto.makeRandomLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.BonusNum;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_범위_예외_검사() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    class PurchaseLottoTest {
        private Lotto purchaseLotto;

        @BeforeEach
        void setUp() {
            purchaseLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @Test
        void 중복_검사() {
            for (int i = 0; i < 1000; ++i) {
                makeRandomLotto();
            }
        }

        @Nested
        @DisplayName("매칭_횟수_검사")
        class MatchCount {
            @Test
            @DisplayName("6회 매칭")
            void check_6() {
                Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                int expected = 6;

                int matchCount = purchaseLotto.matchCount(lotto);

                assertThat(matchCount).isEqualTo(expected);
            }

            @Test
            @DisplayName("5회 매칭")
            void check_5() {
                Lotto lotto = new Lotto(List.of(11, 2, 3, 4, 5, 6));
                int expected = 5;

                int matchCount = purchaseLotto.matchCount(lotto);

                assertThat(matchCount).isEqualTo(expected);
            }

            @Test
            @DisplayName("4회 매칭")
            void check_4() {
                Lotto lotto = new Lotto(List.of(11, 12, 3, 4, 5, 6));
                int expected = 4;

                int matchCount = purchaseLotto.matchCount(lotto);

                assertThat(matchCount).isEqualTo(expected);
            }

            @Test
            @DisplayName("3회 매칭")
            void check_3() {
                Lotto lotto = new Lotto(List.of(11, 12, 13, 4, 5, 6));
                int expected = 3;

                int matchCount = purchaseLotto.matchCount(lotto);

                assertThat(matchCount).isEqualTo(expected);
            }

            @Test
            @DisplayName("2회 매칭")
            void check_2() {
                Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 5, 6));
                int expected = 2;

                int matchCount = purchaseLotto.matchCount(lotto);

                assertThat(matchCount).isEqualTo(expected);
            }

            @Test
            @DisplayName("1회 매칭")
            void check_1() {
                Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 15, 6));
                int expected = 1;

                int matchCount = purchaseLotto.matchCount(lotto);

                assertThat(matchCount).isEqualTo(expected);
            }

            @Test
            @DisplayName("0회 매칭")
            void check_0() {
                Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));
                int expected = 0;

                int matchCount = purchaseLotto.matchCount(lotto);

                assertThat(matchCount).isEqualTo(expected);
            }

        }

        @Nested
        @DisplayName("보너스_매칭_검사")
        class BonusMatch {
            @Test
            @DisplayName("보너스 일치 O")
            void check_true() {
                BonusNum bonusNum = new BonusNum(6);
                boolean expected = true;

                boolean isMatched = purchaseLotto.isBonusNumMatch(bonusNum);

                assertThat(isMatched).isEqualTo(expected);
            }

            @Test
            @DisplayName("보너스 일치 X")
            void check_false() {
                BonusNum bonusNum = new BonusNum(12);
                boolean expected = false;

                boolean isMatched = purchaseLotto.isBonusNumMatch(bonusNum);

                assertThat(isMatched).isEqualTo(expected);
            }
        }
    }

    // 아래에 추가 테스트 작성 가능
}
