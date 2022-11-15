package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultCalculatorTest {

    @ParameterizedTest(name = "로또의 당첨결과를 이용해 총 상금을 계산한다")
    @MethodSource("provideLottoRanks")
    void calculatePrize(Map<Lotto, LottoRank> ranks, Long expected) {
        Long totalPrize = LottoResultCalculator.calculateTotalPrize(ranks);
        assertThat(totalPrize).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoRanks() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(5, 4, 3, 2, 1, 7));
        Lotto lotto3 = new Lotto(List.of(5, 4, 3, 2, 1, 45));
        Lotto lotto4 = new Lotto(List.of(5, 4, 3, 1, 44, 45));
        Lotto lotto5 = new Lotto(List.of(33, 22, 1, 3, 5, 45));
        Lotto lotto6 = new Lotto(List.of(33, 22, 1, 3, 7, 45));
        Lotto lotto7 = new Lotto(List.of(6, 8, 9, 10, 11, 12));
        Lotto lotto8 = new Lotto(List.of(33, 22, 1, 3, 5, 45));

        Map<Lotto, LottoRank> ranks1 = new HashMap<>();
        ranks1.put(lotto1, LottoRank.FIRST_PLACE);
        ranks1.put(lotto2, LottoRank.SECOND_PLACE);
        ranks1.put(lotto3, LottoRank.THIRD_PLACE);
        ranks1.put(lotto4, LottoRank.FOURTH_PLACE);
        ranks1.put(lotto5, LottoRank.FIFTH_PLACE);
        ranks1.put(lotto6, null);
        ranks1.put(lotto7, null);

        Map<Lotto, LottoRank> ranks2 = new HashMap<>();
        ranks2.put(lotto1, LottoRank.FIRST_PLACE);
        ranks2.put(lotto5, LottoRank.FIFTH_PLACE);
        ranks2.put(lotto8, LottoRank.FIFTH_PLACE);

        Map<Lotto, LottoRank> ranks3 = new HashMap<>();
        ranks1.put(lotto6, null);
        ranks1.put(lotto7, null);

        return Stream.of(
                Arguments.of(ranks1, 2_031_555_000L),
                Arguments.of(ranks2, 2_000_010_000L),
                Arguments.of(ranks3, 0L)
        );
    }


    @ParameterizedTest(name = "로또의 당첨결과를 이용해 수익률을 계산한다")
    @MethodSource
    void calculateEarningsRatio(Long totalCost, Long totalPrize, Double expected) {
        Double actual = LottoResultCalculator.calculateEarningsRatio(totalCost, totalPrize);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> calculateEarningsRatio() {
        return Stream.of(
                Arguments.of(7000L, 2031555000L, 29022214.3),
                Arguments.of(3000L, 2000010000L, 66667000d),
                Arguments.of(2000L, 0L, 0d),
                Arguments.of(8000L, 5000L, 62.5d),
                Arguments.of(0L, 0L, 0d)
        );
    }
}