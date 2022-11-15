package lotto;

import static lotto.domain.lotto.Lotto.makeLotto;
import static lotto.domain.lotto.Lotto.makeRandomLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.BonusNum;
import lotto.domain.lotto.Lotto;
import lotto.domain.place.PlaceCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> makeLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 5개가 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> makeLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> makeLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_범위_예외_검사() {
        assertThatThrownBy(() -> makeLotto(List.of(-1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> makeLotto(List.of(46, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> makeLotto(List.of(0, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    class PurchaseLottoTest {
        private Lotto winningLotto;
        private BonusNum bonusNum;


        @BeforeEach
        void setUp() {
            winningLotto = makeLotto(List.of(1, 2, 3, 4, 5, 6));
            bonusNum = new BonusNum(7);
        }

        @Test
        void 중복_검사() {
            for (int i = 0; i < 1000; ++i) {
                makeRandomLotto();
            }
        }

        @Nested
        @DisplayName("매칭_결과_검사")
        class MatchResultTest {
            @Test
            @DisplayName("1등 조건 검사")
            void check_1_place() {
                Lotto purchaseLotto = makeLotto(List.of(1, 2, 3, 4, 5, 6));
                PlaceCondition expected = PlaceCondition.FIRST_PLACE_CONDITION;

                PlaceCondition placeCondition = purchaseLotto.makeCondition(winningLotto, bonusNum);

                assertThat(placeCondition).isEqualTo(expected);
            }

            @Test
            @DisplayName("2등 조건 검사")
            void check_2_place() {
                Lotto purchaseLotto = makeLotto(List.of(1, 7, 3, 4, 5, 6));
                PlaceCondition expected = PlaceCondition.SECOND_PLACE_CONDITION;

                PlaceCondition placeCondition = purchaseLotto.makeCondition(winningLotto, bonusNum);

                assertThat(placeCondition).isEqualTo(expected);
            }

            @Test
            @DisplayName("3등 조건 검사")
            void check_3_place() {
                Lotto purchaseLotto = makeLotto(List.of(1, 2, 3, 34, 5, 6));
                PlaceCondition expected = PlaceCondition.THIRD_PLACE_CONDITION;

                PlaceCondition placeCondition = purchaseLotto.makeCondition(winningLotto, bonusNum);

                assertThat(placeCondition).isEqualTo(expected);
            }

            @Test
            @DisplayName("4등 조건 검사")
            void check_4_place() {
                Lotto purchaseLotto = makeLotto(List.of(11, 12, 3, 4, 5, 6));
                PlaceCondition expected = PlaceCondition.FOURTH_PLACE_CONDITION;

                PlaceCondition placeCondition = purchaseLotto.makeCondition(winningLotto, bonusNum);

                assertThat(placeCondition).isEqualTo(expected);
            }

            @Test
            @DisplayName("5등 조건 검사")
            void check_5_place() {
                Lotto purchaseLotto = makeLotto(List.of(11, 12, 3, 14, 5, 6));
                PlaceCondition expected = PlaceCondition.FIFTH_PLACE_CONDITION;

                PlaceCondition placeCondition = purchaseLotto.makeCondition(winningLotto, bonusNum);

                assertThat(placeCondition).isEqualTo(expected);
            }

            @Test
            @DisplayName("그외 조건 검사")
            void check_rest_place() {
                Lotto purchaseLotto = makeLotto(List.of(11, 12, 3, 14, 15, 6));
                PlaceCondition expected = PlaceCondition.NONE_CONDITION;

                PlaceCondition placeCondition = purchaseLotto.makeCondition(winningLotto, bonusNum);

                assertThat(placeCondition).isEqualTo(expected);
            }
        }
//        @Nested
//        @DisplayName("매칭_결과_검사")
//        class MatchCount {
//            @Test
//            @DisplayName("6회 매칭")
//            void check_6() {
//                Lotto lotto = makeLotto(List.of(1, 2, 3, 4, 5, 6));
//
//                int matchCount = purchaseLotto.matchCount(lotto);
//
//                assertThat(matchCount).isEqualTo(expected);
//            }
//
//            @Test
//            @DisplayName("5회 매칭")
//            void check_5() {
//                Lotto lotto = makeLotto(List.of(11, 2, 3, 4, 5, 6));
//                int expected = 5;
//
//                int matchCount = purchaseLotto.matchCount(lotto);
//
//                assertThat(matchCount).isEqualTo(expected);
//            }
//
//            @Test
//            @DisplayName("4회 매칭")
//            void check_4() {
//                Lotto lotto = makeLotto(List.of(11, 12, 3, 4, 5, 6));
//                int expected = 4;
//
//                int matchCount = purchaseLotto.matchCount(lotto);
//
//                assertThat(matchCount).isEqualTo(expected);
//            }
//
//            @Test
//            @DisplayName("3회 매칭")
//            void check_3() {
//                Lotto lotto = makeLotto(List.of(11, 12, 13, 4, 5, 6));
//                int expected = 3;
//
//                int matchCount = purchaseLotto.matchCount(lotto);
//
//                assertThat(matchCount).isEqualTo(expected);
//            }
//
//            @Test
//            @DisplayName("2회 매칭")
//            void check_2() {
//                Lotto lotto = makeLotto(List.of(11, 12, 13, 14, 5, 6));
//                int expected = 2;
//
//                int matchCount = purchaseLotto.matchCount(lotto);
//
//                assertThat(matchCount).isEqualTo(expected);
//            }
//
//            @Test
//            @DisplayName("1회 매칭")
//            void check_1() {
//                Lotto lotto = makeLotto(List.of(11, 12, 13, 14, 15, 6));
//                int expected = 1;
//
//                int matchCount = purchaseLotto.matchCount(lotto);
//
//                assertThat(matchCount).isEqualTo(expected);
//            }
//
//            @Test
//            @DisplayName("0회 매칭")
//            void check_0() {
//                Lotto lotto = makeLotto(List.of(11, 12, 13, 14, 15, 16));
//                int expected = 0;
//
//                int matchCount = purchaseLotto.matchCount(lotto);
//
//                assertThat(matchCount).isEqualTo(expected);
//            }
//
//        }
//
//        @Nested
//        @DisplayName("보너스_매칭_검사")
//        class BonusMatch {
//            @Test
//            @DisplayName("보너스 일치 O")
//            void check_true() {
//                BonusNum bonusNum = new BonusNum(6);
//                boolean expected = true;
//
//                boolean isMatched = purchaseLotto.isBonusNumMatch(bonusNum);
//
//                assertThat(isMatched).isEqualTo(expected);
//            }
//
//            @Test
//            @DisplayName("보너스 일치 X")
//            void check_false() {
//                BonusNum bonusNum = new BonusNum(12);
//                boolean expected = false;
//
//                boolean isMatched = purchaseLotto.isBonusNumMatch(bonusNum);
//
//                assertThat(isMatched).isEqualTo(expected);
//            }
//        }
//    }
    }
}
