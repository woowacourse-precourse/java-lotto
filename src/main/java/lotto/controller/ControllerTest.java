package lotto.controller;

import java.util.List;

import lotto.model.RankOfLotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.*;

public class ControllerTest {
    @Nested
    class LottoCalculatorTest {
        final List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        final int bonusNumber = 7;

        @Test
        void rankOfLotto0() {
            List<Integer> myLotto = List.of(7,8,9,10,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.NOTHING.ordinal());
        }

        @Test
        void rankOfLotto1() {
            List<Integer> myLotto = List.of(1,8,9,10,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.NOTHING.ordinal());
        }

        @Test
        void rankOfLotto2() {
            List<Integer> myLotto = List.of(1,2,9,10,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.NOTHING.ordinal());
        }

        @Test
        void rankOfLotto3() {
            List<Integer> myLotto = List.of(1,2,3,10,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.FIFTHPRIZE.ordinal());
        }

        @Test
        void rankOfLotto4() {
            List<Integer> myLotto = List.of(1,2,3,4,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.FOURTHPRIZE.ordinal());
        }

        @Test
        void rankOfLotto5() {
            List<Integer> myLotto = List.of(1,2,3,4,5,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.THIRDPRIZE.ordinal());
        }

        @Test
        void rankOfLotto5PlusBonus() {
            List<Integer> myLotto = List.of(1,2,3,4,5,7);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.SECONDPRIZE.ordinal());
        }

        @Test
        void rankOfLotto6() {
            List<Integer> myLotto = List.of(1,2,3,4,5,6);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.FIRSTPRIZE.ordinal());
        }
    }
}
