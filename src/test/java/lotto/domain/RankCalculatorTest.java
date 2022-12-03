package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RankCalculatorTest {

    private List<Lotto> lottoTickets;
    private UserNumber userNumber;
    private RankCalculator rankCalculator;

    @BeforeEach
    void setUp() {
        lottoTickets = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(8, 21, 23, 41, 42, 43))
        );
        userNumber = new UserNumber("1,2,3,4,5,6", "7");
        rankCalculator = new RankCalculator(lottoTickets, userNumber);
    }

    @DisplayName("로또 번호들과 당첨 번호를 입력하면 등수를 반환한다.")
    @Test
    void calculateRankTest() {
        Map<Rank, Integer> expectedRank = Map.ofEntries(
                Map.entry(Rank.FIRST, 0),
                Map.entry(Rank.SECOND, 0),
                Map.entry(Rank.THIRD, 0),
                Map.entry(Rank.FOURTH, 0),
                Map.entry(Rank.FIFTH, 1),
                Map.entry(Rank.NONE, 5)
        );

        assertThat(rankCalculator.getRanks()).isEqualTo(expectedRank);
    }

    @DisplayName("등수를 초기화시킨다.")
    @Test
    void initialRankTest() {
        Map<Rank, Integer> expectedRank = Map.ofEntries(
                Map.entry(Rank.FIRST, 0),
                Map.entry(Rank.SECOND, 0),
                Map.entry(Rank.THIRD, 0),
                Map.entry(Rank.FOURTH, 0),
                Map.entry(Rank.FIFTH, 0),
                Map.entry(Rank.NONE, 0)
        );

        assertThat(rankCalculator.initializeRank()).isEqualTo(expectedRank);
    }
}
