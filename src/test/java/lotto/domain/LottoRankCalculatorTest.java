package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankCalculatorTest {
    private static WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

    @ParameterizedTest(name = "순위를_계산한다")
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
    @DisplayName("싱글톤_인스턴스를_반환한다")
    void return_singleton_instance_test() {
        LottoRankCalculator instance1 = LottoRankCalculator.getInstance();
        LottoRankCalculator instance2 = LottoRankCalculator.getInstance();
        assertThat(instance1).isEqualTo(instance2);
    }


}