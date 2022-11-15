package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static model.Win.FIFTH;
import static model.Win.FIRST;
import static model.Win.FOURTH;
import static model.Win.SECOND;
import static model.Win.THIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningResultTest {
    static Stream<Arguments> winningResult() {
        return Stream.of(
                Arguments.of( 2_064_725_000, List.of(1, 2, 3, 4, 5), 100),
                Arguments.of(30_456_000, List.of(0, 0, 10, 0, 0), 49.3),
                Arguments.of(10_000, List.of(0, 0, 0, 0, 0), 0)
        );
    }

    @MethodSource("winningResult")
    @ParameterizedTest(name = "{index} {0}원 구매 시 당첨 개수가 {1}일 때 수익률 {2}%")
    void 수익률을_계산한다(int money, List<Integer> rankingCount, double rate) {
        WinningResult winningResult = new WinningResult();

        Win[] wins = Win.values();
        for (int ranking = 0; ranking < wins.length; ranking++) {
            for (int count = 0; count < rankingCount.get(ranking); count++) {
                winningResult.putWinningResult(wins[ranking]);
            }
        }

        EarningsRate earningsRate = winningResult.getEarningsRate(new Money(money));
        assertEquals(earningsRate.getEarningRate(), rate);
    }
}