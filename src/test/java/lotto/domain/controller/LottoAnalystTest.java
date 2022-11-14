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

@DisplayName("당첨 통계 및 수익률 계산 기능 클래스 테스트")
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

    // ====== 당첨 통계 기능 테스트 ======

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

    // ====== 수익률 계산 기능 테스트 ======

    @Test
    @DisplayName("수익률 - 수익률은 소수점 한자리로 반환된다.")
    void calculateRateOfReturn_FormatTest() {
        int purchaseAmount = 6000;

        int numberOfLottos = purchaseAmount / LottoIssuer.PRICE_OF_LOTTO;
        lottos = LottoIssuer.issueLottos(numberOfLottos);

        lottoAnalyst.makeWinningStatistics(lottos, winningLottoExample);

        String expectedRegex = "^[0-9]+(.)[0-9]$";
        String actual = Double.toString(lottoAnalyst.calculateRateOfReturn());

        assertThat(actual).matches(expectedRegex);
    }

    @Test
    @DisplayName("수익률 - 100% 미만 테스트")
    void calculateRateOfReturn_UnderHundredPercentTest() {
        int purchaseAmount = 8000;
        int numberOfNotWin = (purchaseAmount / LottoIssuer.PRICE_OF_LOTTO) - 1;
        int fifthRankReturn = RankingInformation.FIFTH_PLACE.getAmountOfReturn();

        setOneFifthLottoAndNotWinLottosConsistingOf(numberOfNotWin);

        lottoAnalyst.makeWinningStatistics(lottos, winningLottoExample);

        double expected = (double) fifthRankReturn / (double) purchaseAmount * 100;
        expected = Math.round(expected * 10) / 10.0;

        double actual = lottoAnalyst.calculateRateOfReturn();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률 - 100% 테스트")
    void calculateRateOfReturn_HundredPercentTest() {
        int purchaseAmount = 5000;
        int numberOfNotWin = (purchaseAmount / 1000) - 1;
        int fifthRankReturn = RankingInformation.FIFTH_PLACE.getAmountOfReturn();

        setOneFifthLottoAndNotWinLottosConsistingOf(numberOfNotWin);

        lottoAnalyst.makeWinningStatistics(lottos, winningLottoExample);

        double expected = (double) fifthRankReturn / (double) purchaseAmount * 100;
        expected = Math.round(expected * 10) / 10.0;

        double actual = lottoAnalyst.calculateRateOfReturn();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률 - 100% 초과 테스트")
    void calculateRateOfReturn_OverHundredPercentTest() {
        int purchaseAmount = 3000;
        int numberOfNotWin = (purchaseAmount / 1000) - 1;
        int fifthRankReturn = RankingInformation.FIFTH_PLACE.getAmountOfReturn();

        setOneFifthLottoAndNotWinLottosConsistingOf(numberOfNotWin);

        lottoAnalyst.makeWinningStatistics(lottos, winningLottoExample);

        double expected = (double) fifthRankReturn / (double) purchaseAmount * 100;
        expected = Math.round(expected * 10) / 10.0;

        double actual = lottoAnalyst.calculateRateOfReturn();

        assertThat(actual).isEqualTo(expected);
    }

    void setOneFifthLottoAndNotWinLottosConsistingOf(int numberOfNotWin) {
        for (int i = 0; i < numberOfNotWin; i++) {
            lottos.add(LottoGameExample.getNotWinNumber());
        }

        lottos.add(ExampleLottosAndRanks.FIFTH_PLACE.getLotto());
    }

}
