package lotto.model;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeTest {
    static Stream<Arguments> setPrize() {
        return Stream.of(
                Arguments.arguments(
                        Map.ofEntries(
                                Map.entry(Rank.FIRST, 1),
                                Map.entry(Rank.SECOND, 1),
                                Map.entry(Rank.THIRD, 1),
                                Map.entry(Rank.FOURTH, 1),
                                Map.entry(Rank.FIFTH, 1),
                                Map.entry(Rank.DEFAULT, 1)
                        ), 2031555000
                ),
                Arguments.arguments(
                        Map.ofEntries(
                                Map.entry(Rank.FIRST, 3),
                                Map.entry(Rank.SECOND, 0),
                                Map.entry(Rank.THIRD, 2),
                                Map.entry(Rank.FOURTH, 0),
                                Map.entry(Rank.FIFTH, 4),
                                Map.entry(Rank.DEFAULT, 1)
                        ), 6003020000L
                ),
                Arguments.arguments(
                        Map.ofEntries(
                                Map.entry(Rank.FIRST, 0),
                                Map.entry(Rank.SECOND, 0),
                                Map.entry(Rank.THIRD, 0),
                                Map.entry(Rank.FOURTH, 0),
                                Map.entry(Rank.FIFTH, 1),
                                Map.entry(Rank.DEFAULT, 0)
                        ), 5000
                )
        );
    }
    @ParameterizedTest(name="총 당첨 금액 계산")
    @MethodSource("setPrize")
    void setPrizeTest(Map<Rank, Integer> ranks, long expected) {
        Prize prize = new Prize(ranks);
        assertEquals(prize.getPrize(), expected);
    }
}