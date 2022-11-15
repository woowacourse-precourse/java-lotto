package domain;

import lotto.domain.LottoResult;
import lotto.domain.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 통계 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST,1",
            "SECOND,1",
            "THIRD,1",
            "FOURTH,1",
            "FIFTH,1",
            "NOTHING,1"
    })
    void checkResult(Ranking ranking, int count) {
        List<Ranking> statistics = List.of(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD,
                Ranking.FOURTH, Ranking.FIFTH, Ranking.NOTHING);
        LottoResult result = new LottoResult(statistics);

        Map<Ranking, Integer> actual = result.getRanks();

        assertThat(actual.get(ranking)).isEqualTo(count);
    }

    @DisplayName("총 수익률 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST,10000000,20",
            "SECOND,100000,30",
            "THIRD,10000,15",
            "FOURTH,500,10",
            "FIFTH,100,5",
            "NOTHING,0,10",
    })
    void checkProfit(Ranking ranking, double expectedProfit, int numberOfLottoTickets) {
        LottoResult result = new LottoResult(List.of(ranking));

        result.getRanks();
        double profit = result.calculateProfit(numberOfLottoTickets);

        assertThat(profit).isEqualTo(expectedProfit);
    }
}
