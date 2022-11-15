package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.constants.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    private static Result result;

    @BeforeEach
    void beforeEach() {
        result = new Result();
    }

    @ParameterizedTest
    @DisplayName("당첨 번호와 보너스 번호를 로또 번호와 비교해 당첨 결과를 구한다")
    @MethodSource("generateData")
    void getResultCompareWinningNumberAndBonsNumberWithLottoNumbers(List<Integer> winningNumbers,
                                                                    List<Integer> lottoNumbers, int bonusNumber,
                                                                    Rank rank, int expected) {
        List<Lotto> lottos = List.of(new Lotto(lottoNumbers));

        result.matchLotto(winningNumbers, lottos, bonusNumber);
        Map<Rank, Integer> rankInfo = result.getRankInfo();
        assertThat(rankInfo).contains(entry(rank, expected));

        rankInfo.remove(rank);
        for (Rank notMatchedRank : rankInfo.keySet()) {
            assertThat(rankInfo.get(notMatchedRank)).isEqualTo(0);
        }
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 7, Rank.FIRST, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7), 7, Rank.SECOND, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 8), 7, Rank.THIRD, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 9, 10), 7, Rank.FOURTH, 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 14, 19, 10), 7, Rank.FIFTH, 1)
        );
    }

    @Test
    @DisplayName("로또를 8000원을 구매해 5등 1개가 당첨됐을 경우 수익률은 62.5%이다.")
    void getWinningAmount() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 11, 15, 16)));

        result.matchLotto(winningNumber, lottos, bonusNumber);
        result.initWinningAmount(8000);

        assertThat(String.format("%.1f", result.getWinningAmount())).isEqualTo("62.5");
    }
}