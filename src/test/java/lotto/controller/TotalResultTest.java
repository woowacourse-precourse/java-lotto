package lotto.controller;

import lotto.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalResultTest {
    private static TotalResult totalResult;

    @BeforeAll
    static void setTotalResult() {
        JackpotBonus jackpotBonus = new JackpotBonus(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lotteries = getLotteries();

        totalResult = new TotalResult(jackpotBonus, lotteries);
    }

    @DisplayName("각 등수에 당첨된 로또의 개수를 반환한다.")
    @Test
    void getRankCountsTest() {
        Map<Rank, Integer> expected = getExpected();
        assertThat(totalResult.getRankCounts()).isEqualTo(expected);
    }

    @DisplayName("수익률을 반환한다")
    @Test
    void getYield() {
        assertThat(totalResult.getYield()).isEqualTo("29,022,214.3");
    }

    private static List<Lotto> getLotteries() {
        List<List<Integer>> lottoNumbers = List.of(
                List.of(7, 8, 9, 10, 11, 12),
                List.of(1, 2, 7, 8, 9, 10),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 6)
        );

        return lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private static Map<Rank, Integer> getExpected() {
        return new EnumMap<>(Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 1,
                Rank.FOURTH, 1,
                Rank.FIFTH, 1,
                Rank.NO_LUCK, 2
        ));
    }

}
