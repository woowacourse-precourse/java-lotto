package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankCalculatorTest {
    private static WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

    @ParameterizedTest(name = "로또들의 순위를 계산한다")
    @MethodSource
    void calculate_lotto_ranks(Lottos lottos, Map<Lotto, LottoRank> expectedRanks) {
        LottoRankCalculator calculator = LottoRankCalculator.getInstance();
        Map<Lotto, LottoRank> actualRanks = calculator.calculateRanks(winningNumbers, lottos);
        for (Entry<Lotto, LottoRank> entry : actualRanks.entrySet()) {
            assertThat(entry.getValue()).isEqualTo(expectedRanks.get(entry.getKey()));

        }

    }

    private static Stream<Arguments> calculate_lotto_ranks() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(5, 4, 3, 2, 1, 7));
        Lotto lotto3 = new Lotto(List.of(5, 4, 3, 2, 1, 45));
        Lotto lotto4 = new Lotto(List.of(5, 4, 3, 1, 44, 45));
        Lotto lotto5 = new Lotto(List.of(33, 22, 1, 3, 5, 45));
        Lotto lotto6 = new Lotto(List.of(33, 22, 1, 3, 7, 45));
        Lotto lotto7 = new Lotto(List.of(6, 8, 9, 10, 11, 12));

        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7));
        Map<Lotto, LottoRank> ranks = new HashMap<>();
        ranks.put(lotto1, LottoRank.FIRST_PLACE);
        ranks.put(lotto2, LottoRank.SECOND_PLACE);
        ranks.put(lotto3, LottoRank.THIRD_PLACE);
        ranks.put(lotto4, LottoRank.FOURTH_PLACE);
        ranks.put(lotto5, LottoRank.FIFTH_PLACE);
        ranks.put(lotto6, null);
        ranks.put(lotto7, null);
        return Stream.of(Arguments.of(lottos, ranks));
    }

    @ParameterizedTest(name = "로또의 순위를 계산한다")
    @MethodSource
    void calculate_lotto_rank(Lotto lotto, LottoRank expectedRank) {
        LottoRankCalculator calculator = LottoRankCalculator.getInstance();
        assertThat(calculator.calculateRank(winningNumbers, lotto)).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> calculate_lotto_rank() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.FIRST_PLACE),
                Arguments.of(new Lotto(List.of(5, 4, 3, 2, 1, 7)), LottoRank.SECOND_PLACE),
                Arguments.of(new Lotto(List.of(5, 4, 3, 2, 1, 45)), LottoRank.THIRD_PLACE),
                Arguments.of(new Lotto(List.of(5, 4, 3, 1, 44, 45)), LottoRank.FOURTH_PLACE),
                Arguments.of(new Lotto(List.of(33, 22, 1, 3, 5, 45)), LottoRank.FIFTH_PLACE),
                Arguments.of(new Lotto(List.of(33, 22, 1, 3, 7, 45)), null),
                Arguments.of(new Lotto(List.of(6, 8, 9, 10, 11, 12)), null)
        );
    }


    @Test
    @DisplayName("싱글톤 인스턴스를 반환한다")
    void return_singleton_instance_test() {
        LottoRankCalculator instance1 = LottoRankCalculator.getInstance();
        LottoRankCalculator instance2 = LottoRankCalculator.getInstance();
        assertThat(instance1).isEqualTo(instance2);
    }


}