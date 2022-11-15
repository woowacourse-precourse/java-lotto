package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Stream;

import static lotto.domain.LottoWin.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {
    private static final DecimalFormat rateFormat = new DecimalFormat("###,###.0%");

    @ParameterizedTest(name = "[{index}] lottoResults = {0}, percent = {1}")
    @MethodSource("whenTotalPercentThenSuccessDummy")
    @DisplayName("당첨 수익률 계산 성공 테스트")
    void whenTotalPercentThenSuccessTest(Map<LottoWin, Integer> lottoResults, String percent) {
        LottoResults newLottoResults = new LottoResults(lottoResults);
        String resultPercent = rateFormat.format(newLottoResults.totalRate());
        System.out.println(resultPercent);
        assertThat(resultPercent).isEqualTo(percent);
    }

    static Stream<Arguments> whenTotalPercentThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(Map.of(LOSER, 15,
                        FIFTH_PRICE_WINNER, 1,
                        FOURTH_PRICE_WINNER, 1,
                        THIRD_PRICE_WINNER, 3,
                        SECOND_PRICE_WINNER, 1,
                        FIRST_PRICE_WINNER, 0), "164,547.6%"),
                Arguments.arguments(Map.of(LOSER, 0,
                        FIFTH_PRICE_WINNER, 1,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 2,
                        SECOND_PRICE_WINNER, 0,
                        FIRST_PRICE_WINNER, 0), "100,166.7%"),
                Arguments.arguments(Map.of(LOSER, 1,
                        FIFTH_PRICE_WINNER, 0,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 1,
                        SECOND_PRICE_WINNER, 1,
                        FIRST_PRICE_WINNER, 0), "1,050,000.0%"),
                Arguments.arguments(Map.of(LOSER, 55,
                        FIFTH_PRICE_WINNER, 1,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 3,
                        SECOND_PRICE_WINNER, 1,
                        FIRST_PRICE_WINNER, 0), "57,508.3%"),
                Arguments.arguments(Map.of(LOSER, 152,
                        FIFTH_PRICE_WINNER, 1,
                        FOURTH_PRICE_WINNER, 12,
                        THIRD_PRICE_WINNER, 2,
                        SECOND_PRICE_WINNER, 0,
                        FIRST_PRICE_WINNER, 0), "2,158.7%"),
                Arguments.arguments(Map.of(LOSER, 1,
                        FIFTH_PRICE_WINNER, 3,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 1,
                        SECOND_PRICE_WINNER, 0,
                        FIRST_PRICE_WINNER, 0), "30,300.0%"),
                Arguments.arguments(Map.of(LOSER, 0,
                        FIFTH_PRICE_WINNER, 0,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 0,
                        SECOND_PRICE_WINNER, 0,
                        FIRST_PRICE_WINNER, 1), "200,000,000.0%")
        );
    }
}