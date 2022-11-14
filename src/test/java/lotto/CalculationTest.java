package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.calculation.calculateResultByOne;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {

    @DisplayName("숫자 6개가 일치")
    @Test
    void calculateResultMATCH6(){
        int result = calculateResultByOne(
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                8);
        assertEquals(result, WinningType.MATCH6.key);
    }

    @DisplayName("숫자 5개와 보너스 번호가 일치")
    @Test
    void calculateResultMATCH5WITHBONUS(){
        int result = calculateResultByOne(
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,7),
                6);
        assertEquals(result, WinningType.MATCH5WITHBONUS.key);
    }

    @DisplayName("숫자 4개가 일치")
    @Test
    void calculateResultMATCH4(){
        int result = calculateResultByOne(
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,8,7),
                10);
        assertEquals(result, WinningType.MATCH4.key);
    }

    @DisplayName("숫자 3개가 일치")
    @Test
    void calculateResultMATCH3(){
        int result = calculateResultByOne(
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,19,15,17),
                10);
        assertEquals(result, WinningType.MATCH3.key);
    }

    @DisplayName("숫자 3개 미만이 일치")
    @Test
    void calculateResultNOTHING(){
        int result = calculateResultByOne(
                List.of(1,2,13,14,15,16),
                List.of(1,2,23,24,25,27),
                6);
        assertEquals(result, WinningType.NOTHING.key);
    }

}
