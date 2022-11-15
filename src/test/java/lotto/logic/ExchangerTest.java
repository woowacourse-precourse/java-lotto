package lotto.logic;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExchangerTest {

    static Exchanger exchanger;

    @BeforeAll
    static void init() {
        exchanger = Exchanger.getInstance();
    }

    @DisplayName("로또 당첨의 결과에 대하여 수익금을 계산한다.")
    @Test
    void calculateProfit() {
        Map<Rank, Integer> countOfRank = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 2,
                Rank.THIRD, 0,
                Rank.FOURTH, 3,
                Rank.FIFTH, 9
        );

        long expected = Rank.FIRST.getWinnings() * 1 + Rank.SECOND.getWinnings() * 2
                        + Rank.THIRD.getWinnings() * 0 + Rank.FOURTH.getWinnings() * 3
                        + Rank.FIFTH.getWinnings() * 9;

        assertThat(exchanger.calculateProfit(countOfRank)).isEqualTo(expected);
    }

}
