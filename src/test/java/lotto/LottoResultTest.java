package lotto;

import static lotto.LottoOperator.FIVE_BONUS;
import static lotto.LottoOperator.NO_LUCK;
import static lotto.LottoOperator.SIX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

    @Test
    @DisplayName("당첨 통계가 1 미만일 때 예외처리")
    void validateStatisticsSize() {
        assertThatThrownBy(() -> new LottoResult(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("당첨 통계를 가지고 결과 확인")
    @CsvSource(value = {
            "NO_LUCK,2",
            "THREE,0",
            "FOUR,0",
            "FIVE,0",
            "FIVE_BONUS,1",
            "SIX,1",
    })
    void makeResult(LottoOperator operator, int count) {
        List<LottoOperator> statistics = List.of(NO_LUCK, NO_LUCK, FIVE_BONUS, SIX);
        LottoResult result = new LottoResult(statistics);

        Map<LottoOperator, Integer> actual = result.matchWinningRank();

        assertThat(actual).containsEntry(operator, count);
    }

    @ParameterizedTest
    @DisplayName("수익률 확인 테스트")
    @CsvSource(value = {
            "NO_LUCK,0.0,1",
            "THREE,62.5,8",
            "FOUR,500.0,10",
            "FIVE,15000.0,10",
            "FIVE_BONUS,300000.0,10",
            "SIX,20000000.0,10"
    })
    void makeYield(LottoOperator operator, double expectedYield, int lottoTickets) {
        LottoResult result = new LottoResult(List.of(operator));

        result.matchWinningRank();
        double actualYield = result.makeYield(lottoTickets);

        assertThat(actualYield).isEqualTo(expectedYield);
    }
}
