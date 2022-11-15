package lotto;

import lotto.domain.Rank;
import lotto.util.Statistic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"SAME_THREE:2", "SAME_FIVE:2", "SAME_SIX:2", "SAME_FOUR:1", "SAME_FIVE_BONUS:1"}, delimiter = ':')
    @DisplayName("일치하는 개수에 따라 HashMap에 등록된다.")
    void registerRank(Statistic input, int expected) {
        Rank rank = new Rank();
        Arrays.asList(3, 3, 5, 6, 6, 4, 5).forEach((number) -> {
            rank.setCount(number, false);
        });
        rank.setCount(5, true);
        assertThat(rank.getRanks().get(input)).isEqualTo(expected);
    }
}
