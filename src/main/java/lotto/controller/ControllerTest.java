package lotto.controller;

import java.util.List;

import lotto.model.RankOfLotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.*;

public class ControllerTest {
    @Nested
    class RankOfThisLottoTest {
        final List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        final int bonusNumber = 7;

        @Test
        void nothing1() {
            List<Integer> myLotto = List.of(7,8,9,10,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.NOTHING.ordinal());
        }

        @Test
        void nothing2() {
            List<Integer> myLotto = List.of(1,8,9,10,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.NOTHING.ordinal());
        }

        @Test
        void nothing3() {
            List<Integer> myLotto = List.of(1,2,9,10,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.NOTHING.ordinal());
        }

        @Test
        void fifthRank() {
            List<Integer> myLotto = List.of(1,2,3,10,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.FIFTHPRIZE.ordinal());
        }

        @Test
        void fourthRank() {
            List<Integer> myLotto = List.of(1,2,3,4,11,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.FOURTHPRIZE.ordinal());
        }

        @Test
        void thidRank() {
            List<Integer> myLotto = List.of(1,2,3,4,5,12);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.THIRDPRIZE.ordinal());
        }

        @Test
        void secondRank() {
            List<Integer> myLotto = List.of(1,2,3,4,5,7);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.SECONDPRIZE.ordinal());
        }

        @Test
        void firstRank() {
            List<Integer> myLotto = List.of(1,2,3,4,5,6);
            assertThat(LottoCalculator.rankOfThisLotto(myLotto, winningLotto, bonusNumber))
                    .isEqualTo(RankOfLotto.FIRSTPRIZE.ordinal());
        }
    }

    @Nested
    class ManageLottoTest {
        @Test
        void NumberOfLottoTest1() {
            int budget = 5000;
            ManageLotto manageLotto = new ManageLotto(budget);
            assertThat(manageLotto.getLottoNum()).isEqualTo(5);
        }

        @Test
        void NumberOfLottoTest2() {
            int budget = 100000;
            ManageLotto manageLotto = new ManageLotto(budget);
            assertThat(manageLotto.getLottoNum()).isEqualTo(100);
        }

        @Test
        void NumberOfLottoTest3() {
            int budget = 23000;
            ManageLotto manageLotto = new ManageLotto(budget);
            assertThat(manageLotto.getLottoNum()).isEqualTo(23);
        }
    }
}
