package lotto.domain.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.constants.RankingInformation;
import lotto.domain.LottoGameExample;
import lotto.domain.LottoGameExample.ExampleLottosAndRanks;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoIssuerTest {

    LottoIssuer lottoIssuer = new LottoIssuer();
    List<Lotto> lottos;

    @BeforeEach
    void setLottosAndStatistics() {
        lottos = new ArrayList<>();

        statisticsActual = new HashMap<>();
        statisticsExpected = new HashMap<>();

        for (RankingInformation oneRank : RankingInformation.values()) {
            statisticsExpected.put(oneRank, 0);
        }
    }

    // ========== 로또 발행 테스트 ==========

    int numberOfIssueTestLottos = 8;

    @Test
    @DisplayName("로또발행 - 입력된 개수만큼 발행된다.")
    void issueLottos_LottosCountTest() {
        issueLottos();

        assertThat(lottos.size()).isEqualTo(numberOfIssueTestLottos);
    }

    @Test
    @DisplayName("로또발행 - 각각 6개의 숫자가 발행된다.")
    void issueLottos_NumbersCountTest() {
        issueLottos();

        int lottoNumberCount = 6;

        lottos.forEach(l -> assertThat(l.getNumbers().size()).isEqualTo(lottoNumberCount));
    }

    @Test
    @DisplayName("로또발행 - 각 숫자는 1~45 범위에 해당한다.")
    void issueLottos_RangeTest() {
        issueLottos();

        for (Lotto oneLotto : lottos) {
            List<Integer> numbers = oneLotto.getNumbers();
            numbers.forEach(n -> assertThat(checkRange(n)).isTrue());
        }
    }

    void issueLottos() {
        lottos = lottoIssuer.issueLottos(numberOfIssueTestLottos);
    }

    boolean checkRange(int number) {
        if (1 <= number && number <= 45) {
            return true;
        }

        return false;
    }

    @Test
    @DisplayName("로또발행 - 각 숫자는 중복되지 않는다.")
    void issueLottos_DuplicatedTest() {
        lottos = lottoIssuer.issueLottos(numberOfIssueTestLottos);

        for (Lotto oneLotto : lottos) {
            Set<Integer> checkDuplicate = new HashSet<>();

            List<Integer> numbers = oneLotto.getNumbers();
            numbers.forEach(n -> assertThat(checkDuplicate.add(n)).isTrue());
        }
    }

    // ========== 당첨 통계 테스트 ==========
    Map<RankingInformation, Integer> statisticsActual;

    Map<RankingInformation, Integer> statisticsExpected;
    WinningNumber winningNumberExample = LottoGameExample.getWinningNumber();

    @Test
    @DisplayName("당첨통계 - 3개 미만으로 일치하면 통계가 모두 0의 값을 갖는다.")
    void makeWinningStatistics_UnderFifthRankTest() {
        lottos.add(LottoGameExample.getNotWinNumber());

        statisticsActual = lottoIssuer.makeWinningStatistics(lottos, winningNumberExample);

        assertThat(statisticsActual).isEqualTo(statisticsExpected);
    }

    @Test
    @DisplayName("당첨통계 - 3개가 일치하면 5등이 1 증가한다.")
    void makeWinningStatistics_FifthRankTest() {
        statisticsTest(ExampleLottosAndRanks.FIFTH_RANK);
    }

    @Test
    @DisplayName("당첨통계 - 4개가 일치하면 4등이 1 증가한다.")
    void makeWinningStatistics_FourthRankTest() {
        statisticsTest(ExampleLottosAndRanks.FOURTH_RANK);
    }

    @Test
    @DisplayName("당첨통계 - 5개가 일치하면 3등이 1 증가한다.")
    void makeWinningStatistics_ThirdRankTest() {
        statisticsTest(ExampleLottosAndRanks.THIRD_RANK);
    }

    @Test
    @DisplayName("당첨통계 - 5개와 보너스 번호가 일치하면 2등이 1 증가한다.")
    void makeWinningStatistics_SecondRankTest() {
        statisticsTest(ExampleLottosAndRanks.SECOND_RANK);
    }

    @Test
    @DisplayName("당첨통계 - 6개가 일치하면 1등이 1 증가한다.")
    void makeWinningStatistics_FirstRankTest() {
        statisticsTest(ExampleLottosAndRanks.FIRST_RANK);
    }

    void statisticsTest(ExampleLottosAndRanks exampleLottosAndRanks) {
        Lotto exampleLotto = exampleLottosAndRanks.getLotto();
        RankingInformation exampleRank = exampleLottosAndRanks.getRank();

        lottos.add(exampleLotto);
        statisticsExpected.put(exampleRank, 1);

        statisticsActual = lottoIssuer.makeWinningStatistics(lottos, winningNumberExample);

        assertThat(statisticsActual).isEqualTo(statisticsExpected);
    }

}
