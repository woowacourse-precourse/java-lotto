package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class ProfitTest {
    @CsvSource(value = {
            "THIRD : 3 : FIFTH : 1 : 50000 : 9010.0",
            "FIFTH : 1 : SECOND : 0 : 8000 : 62.5",
            "FOURTH : 2 : FAIL : 3 : 500000 : 20.0",
            "FIRST : 1 : FAIL : 0 : 50000000 : 4000.0",
            "SECOND: 2 : THIRD : 0 : 500000000 : 12.0",
            "FAIL : 0 :  FAIL : 0 : 80000 : 0.0",
            "FIFTH : 3 : SECOND : 0 : 960000 : 1.6",
            "FOURTH : 1 : FIFTH : 1 : 6333000 : 0.9"
    }, delimiter = ':')
    @ParameterizedTest
    void 수익률을_구한다(LottoRank lottoRank1, int count1, LottoRank lottoRank2, int count2, long purchaseAmount, String expected) {
        Map<LottoRank, Integer> lottoResult = new TreeMap<>(Collections.reverseOrder());

        lottoResult.put(lottoRank1, count1);
        lottoResult.put(lottoRank2, count2);

        double result = Profit.calculateProfit(lottoResult, purchaseAmount);

        String resultFormat = String.format("%.1f", result);

        assertThat(resultFormat).isEqualTo(expected);
    }

    @CsvSource(value = {
            "THIRD : 3 : FIFTH : 1 : 4505000",
            "FOURTH : 2 : FAIL : 3 : 100000",
            "FIRST : 1 : FAIL : 0 : 2000000000",
            "SECOND: 2 : THIRD : 0 : 60000000",
            "FAIL : 0 :  FAIL : 0 : 0",
            "FIFTH : 10 : SECOND : 2 : 60050000",
            "FOURTH : 1 : FIRST : 1 : 2000050000"
    }, delimiter = ':')
    @ParameterizedTest
    void 당첨되어_얻게_된_총_금액을_구한다(LottoRank lottoRank1, int count1, LottoRank lottoRank2, int count2, long expected) {
        Map<LottoRank, Integer> lottoResult = new TreeMap<>(Collections.reverseOrder());

        lottoResult.put(lottoRank1, count1);
        lottoResult.put(lottoRank2, count2);

        long result = Profit.calculateIncome(lottoResult);

        assertThat(result).isEqualTo(expected);
    }
}