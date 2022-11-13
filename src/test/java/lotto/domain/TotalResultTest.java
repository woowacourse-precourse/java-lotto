package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalResultTest {
    @DisplayName("각 등수에 당첨된 로또의 개수를 반환한다")
    @Test
    void getRankCountsByEnumMap() {
        JackpotBonus jackpotBonus = new JackpotBonus(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lotteries = getLotteries();
        Map<Rank, Integer> expected = getExpected();

        assertThat(TotalResult.getRankCounts(jackpotBonus, lotteries))
                .isEqualTo(expected);
    }

    private static List<Lotto> getLotteries(){
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

    private static Map<Rank, Integer> getExpected(){
        Map<Rank, Integer> expected = new EnumMap<Rank, Integer>(Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 1,
                Rank.FOURTH, 1,
                Rank.FIFTH, 1,
                Rank.NO_LUCK, 2
        ));

        return expected;
    }

}
