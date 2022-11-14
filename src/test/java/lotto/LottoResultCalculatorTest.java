package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultCalculatorTest {
    private static LottoResultCalculator lottoResultCalculator;

    @BeforeEach
    void setUp() {
        lottoResultCalculator = LottoResultCalculator.getInstance();
        lottoResultCalculator.setWinningNums(List.of(1, 2, 3, 4, 5, 6));
        lottoResultCalculator.setBonusNum(7);
    }

    private static EnumMap<Rank, Integer> expectedConstructor(List<Integer> values) {
        return new EnumMap<>(Map.ofEntries(
                Map.entry(Rank.FIRST_PRIZE, values.get(0)),
                Map.entry(Rank.SECOND_PRIZE, values.get(1)),
                Map.entry(Rank.THIRD_PRIZE, values.get(2)),
                Map.entry(Rank.FOURTH_PRIZE, values.get(3)),
                Map.entry(Rank.FIFTH_PRIZE, values.get(4)),
                Map.entry(Rank.NOTHING, values.get(5))
        ));
    }

    static Stream<Arguments> parameterProvider() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        EnumMap<Rank, Integer> expected = expectedConstructor(List.of(1, 0, 1, 0, 0, 0));

        List<Lotto> lottos1 = List.of(new Lotto(List.of(8, 9, 10, 11, 12, 13)),
                new Lotto(List.of(1, 2, 3, 21, 22, 23)));
        EnumMap<Rank, Integer> expected1 = expectedConstructor(List.of(0, 0, 0, 0, 1, 1));

        List<Lotto> lottos2 = List.of(new Lotto(List.of(1, 9, 10, 11, 12, 13)), new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        EnumMap<Rank, Integer> expected2 = expectedConstructor(List.of(0, 1, 0, 0, 0, 1));

        return Stream.of(
                arguments(lottos, expected),
                arguments(lottos1, expected1),
                arguments(lottos2, expected2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void calRankAll(List<Lotto> lottos, EnumMap<Rank, Integer> expected) {
        assertThat(lottoResultCalculator.calRankAll(lottos)).isEqualTo(expected);
    }
}