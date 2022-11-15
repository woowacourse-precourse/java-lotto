package lotto.domain;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankCalculatorTest {
    private List<Lotto> lottoPapers;
    private ProvidNumber providNumber;
    private RankCalculator rankCalculator;

    @BeforeEach
    void setUp() {
        lottoPapers = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(10, 11, 23, 24, 33, 45)),
                new Lotto(List.of(10, 11, 23, 41, 42, 43))
        );
        providNumber = new ProvidNumber("10,11,23,24,33,45", "7");
        rankCalculator = new RankCalculator(lottoPapers, providNumber);
    }

    @DisplayName("여러개의 로또 번호와 당첨 번호를 입력하면 등수 반환.")
    @Test
    void calculateRankTest() {
        Map<Rank, Integer> expectedRank = Map.ofEntries(
                Map.entry(Rank.FIRST_PLACE, 1),
                Map.entry(Rank.SECOND_PLACE, 0),
                Map.entry(Rank.THIRD_PLACE, 0),
                Map.entry(Rank.FOURTH_PLACE, 0),
                Map.entry(Rank.FIFTH_PLACE, 1),
                Map.entry(Rank.NONE, 4)
        );

        assertThat(rankCalculator.getRanks()).isEqualTo(expectedRank);
    }

    @DisplayName("등수 초기화.")
    @Test
    void initialRankTest() {
        Map<Rank, Integer> expectedRank = Map.ofEntries(
                Map.entry(Rank.FIRST_PLACE, 0),
                Map.entry(Rank.SECOND_PLACE, 0),
                Map.entry(Rank.THIRD_PLACE, 0),
                Map.entry(Rank.FOURTH_PLACE, 0),
                Map.entry(Rank.FIFTH_PLACE, 0),
                Map.entry(Rank.NONE, 0)
        );

        assertThat(rankCalculator.initializeRank()).isEqualTo(expectedRank);
    }

}