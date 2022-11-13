package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.ResultStatistics;
import lotto.domain.WinLotto;
import lotto.enums.ResultStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {
    List<Lotto> lottos = new ArrayList<>();

    @DisplayName("발행된 로또 중 몇 개가 얼마짜리에 당첨되었는지 테스트1")
    @Nested
    class MatchTest1 {

        @BeforeEach
        void init() {
            lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
            lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
            lottos.add(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)));
        }

        @DisplayName("3개 일치 1개")
        @Test
        void case1() {
            WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 41, 42, 43), 10);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH3)).isEqualTo(1);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(5000);
        }

        @DisplayName("3개 일치 2개")
        @Test
        void case2() {
            WinLotto winLotto = new WinLotto(Arrays.asList(4, 5, 6, 7, 8, 9), 10);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH3)).isEqualTo(2);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(10000);
        }

        @DisplayName("4개 일치 1개")
        @Test
        void case3() {
            WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 41, 42), 10);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH4)).isEqualTo(1);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(50000);
        }

        @DisplayName("5개 일치 1개")
        @Test
        void case4() {
            WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 42), 10);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH5)).isEqualTo(1);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(1500000);
        }

        @DisplayName("5개 + 보너스볼 일치 1개")
        @Test
        void case5() {
            WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 42), 6);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH5_WITH_BONUS_BALL)).isEqualTo(1);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(30000000);
        }

        @DisplayName("6개 일치 1개")
        @Test
        void case6() {
            WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH6)).isEqualTo(1);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(2000000000);
        }
    }

    @DisplayName("발행된 로또 중 몇 개가 얼마짜리에 당첨되었는지 테스트1")
    @Nested
    class MatchTest2 {

        @BeforeEach
        void init() {
            lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
            lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)));
            lottos.add(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
            lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
            lottos.add(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)));
        }

        @DisplayName("3개 일치 1개, 4개 일치 2개")
        @Test
        void case1() {
            WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 42, 43), 10);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH3)).isEqualTo(1);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH4)).isEqualTo(2);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(105000);
        }

        @DisplayName("3개 일치 1개, 4개 일치 1개, 5개일치 1개")
        @Test
        void case2() {
            WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 43), 10);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH3)).isEqualTo(1);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH4)).isEqualTo(1);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH5)).isEqualTo(1);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(1555000);
        }

        @DisplayName("3개 일치 1개, 4개 일치 1개, 5개 & 보너스볼 일치 1개")
        @Test
        void case3() {
            WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 43), 6);
            List<Result> results = OutputView.getResults(lottos, winLotto);
            ResultStatistics resultStatistics = new ResultStatistics(results);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH3)).isEqualTo(1);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH4)).isEqualTo(1);
            assertThat(resultStatistics.getMatchCount(ResultStatus.MATCH5_WITH_BONUS_BALL)).isEqualTo(1);
            assertThat(resultStatistics.getTotalProfit()).isEqualTo(30055000);
        }
    }
}