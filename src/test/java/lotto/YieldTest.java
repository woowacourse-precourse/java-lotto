package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class YieldTest {

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @CsvSource({
            "THREE, 8000, 62.5",
            "THREE, 9000, 55.6"
    })
    void testYield(Match match, int receive, double expectedYield) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.plusLottoResult(match);

        Money money = new Money(receive);

        Yield yield = new Yield(lottoResult, money);

        Assertions.assertThat(yield.ceilYield()).isEqualTo(expectedYield);
    }
}
