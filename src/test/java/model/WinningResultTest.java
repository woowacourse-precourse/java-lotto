package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static model.Win.FIFTH;
import static model.Win.FIRST;
import static model.Win.FOURTH;
import static model.Win.SECOND;
import static model.Win.THIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningResultTest {

    @ParameterizedTest(name = "{index} {0}원 구매로 1등 {1}개, 2등 {2}개, 3등 {3}개, 4등 {4}개, 5등 {5}개 당첨일 때 수익률 {6}%")
    @CsvSource(value = {"2_064_725_000:1:2:3:4:5:100", "30_456_000:0:0:10:0:0:49.3", "10_000:0:0:0:0:0:0"}, delimiter = ':')
    void 수익률을_계산한다(int money, int first, int second, int third, int fourth, int fifth, double rate) {
        Map<Win, Integer> winningResult = new HashMap<>() {{
            put(FIRST, first);
            put(SECOND, second);
            put(THIRD, third);
            put(FOURTH, fourth);
            put(FIFTH, fifth);
        }};

        WinningResult result = new WinningResult(winningResult);
        double earningsRate = result.getEarningsRate(new Money(money));
        assertEquals(earningsRate, rate);
    }
}