package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static lotto.domain.LottoWin.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {
    @ParameterizedTest(name = "[{index}] lottoResults = {0}, rate = {1}")
    @MethodSource("whenTotalRateThenSuccessDummy")
    @DisplayName("당첨 수익률 계산 성공 테스트")
    void whenTotalRateThenSuccessTest(Map<LottoWin, Integer> lottoResults, double rate) {
        LottoResults newLottoResults = new LottoResults(lottoResults);
        assertThat(newLottoResults.totalRate()).isEqualTo(rate);
    }

    static Stream<Arguments> whenTotalRateThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(Map.of(LOSER, 15,
                        FIFTH_PRICE_WINNER, 1,
                        FOURTH_PRICE_WINNER, 1,
                        THIRD_PRICE_WINNER, 3,
                        SECOND_PRICE_WINNER, 1,
                        FIRST_PRICE_WINNER, 0), 164547.61904761902),
                Arguments.arguments(Map.of(LOSER, 0,
                        FIFTH_PRICE_WINNER, 1,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 2,
                        SECOND_PRICE_WINNER, 0,
                        FIRST_PRICE_WINNER, 0), 100166.66666666666),
                Arguments.arguments(Map.of(LOSER, 1,
                        FIFTH_PRICE_WINNER, 0,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 1,
                        SECOND_PRICE_WINNER, 1,
                        FIRST_PRICE_WINNER, 0), 1050000.0),
                Arguments.arguments(Map.of(LOSER, 55,
                        FIFTH_PRICE_WINNER, 1,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 3,
                        SECOND_PRICE_WINNER, 1,
                        FIRST_PRICE_WINNER, 0), 57508.333333333336),
                Arguments.arguments(Map.of(LOSER, 152,
                        FIFTH_PRICE_WINNER, 1,
                        FOURTH_PRICE_WINNER, 12,
                        THIRD_PRICE_WINNER, 2,
                        SECOND_PRICE_WINNER, 0,
                        FIRST_PRICE_WINNER, 0), 2158.682634730539),
                Arguments.arguments(Map.of(LOSER, 1,
                        FIFTH_PRICE_WINNER, 3,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 1,
                        SECOND_PRICE_WINNER, 0,
                        FIRST_PRICE_WINNER, 0), 30300.0),
                Arguments.arguments(Map.of(LOSER, 0,
                        FIFTH_PRICE_WINNER, 0,
                        FOURTH_PRICE_WINNER, 0,
                        THIRD_PRICE_WINNER, 0,
                        SECOND_PRICE_WINNER, 0,
                        FIRST_PRICE_WINNER, 1), 2.0E8)
        );
    }
}