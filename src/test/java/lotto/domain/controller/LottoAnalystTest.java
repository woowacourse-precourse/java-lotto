package lotto.domain.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.RankingInformation;
import lotto.domain.LottoGameExample;
import lotto.domain.LottoGameExample.ExampleLottosAndRanks;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoAnalystTest {

    LottoAnalyst lottoAnalyst;
    List<Lotto> lottos;

    Map<RankingInformation, Integer> statisticsActual;
    Map<RankingInformation, Integer> statisticsExpected;

    WinningLotto winningLottoExample = LottoGameExample.getWinningNumber();

    @BeforeEach
    void setLottosAndStatistics() {
        lottoAnalyst = new LottoAnalyst();
        lottos = new ArrayList<>();

        statisticsActual = new HashMap<>();
        statisticsExpected = new HashMap<>();

        for (RankingInformation oneRank : RankingInformation.values()) {
            statisticsExpected.put(oneRank, 0);
        }
    }

    @Test
    @DisplayName("당첨통계 - 3개 미만으로 일치하면 통계가 모두 0의 값을 갖는다.")
    void makeWinningStatistics_UnderFifthRankTest() {
        lottos.add(LottoGameExample.getNotWinNumber());

        statisticsActual = lottoAnalyst.makeWinningStatistics(lottos, winningLottoExample);

        assertThat(statisticsActual).isEqualTo(statisticsExpected);
    }

    @Test
    @DisplayName("당첨통계 - 3개가 일치하면 5등이 1 증가한다.")
    void makeWinningStatistics_FifthRankTest() {
        statisticsTest(ExampleLottosAndRanks.FIFTH_PLACE);
    }

    @Test
    @DisplayName("당첨통계 - 4개가 일치하면 4등이 1 증가한다.")
    void makeWinningStatistics_FourthRankTest() {
        statisticsTest(ExampleLottosAndRanks.FOURTH_PLACE);
    }

    @Test
    @DisplayName("당첨통계 - 5개가 일치하면 3등이 1 증가한다.")
    void makeWinningStatistics_ThirdRankTest() {
        statisticsTest(ExampleLottosAndRanks.THIRD_PLACE);
    }

    @Test
    @DisplayName("당첨통계 - 5개와 보너스 번호가 일치하면 2등이 1 증가한다.")
    void makeWinningStatistics_SecondRankTest() {
        statisticsTest(ExampleLottosAndRanks.SECOND_PLACE);
    }

    @Test
    @DisplayName("당첨통계 - 6개가 일치하면 1등이 1 증가한다.")
    void makeWinningStatistics_FirstRankTest() {
        statisticsTest(ExampleLottosAndRanks.FIRST_PLACE);
    }

    void statisticsTest(ExampleLottosAndRanks exampleLottosAndRanks) {
        Lotto exampleLotto = exampleLottosAndRanks.getLotto();
        RankingInformation exampleRank = exampleLottosAndRanks.getRank();

        lottos.add(exampleLotto);
        statisticsExpected.put(exampleRank, 1);

        statisticsActual = lottoAnalyst.makeWinningStatistics(lottos, winningLottoExample);

        assertThat(statisticsActual).isEqualTo(statisticsExpected);
    }
}
