package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    final Rank rank = new Rank();
    final List<Integer> firstAnswer = List.of(6, 7, 5, 4, 3, 0);
    final List<Integer> secondAnswer = List.of(0, 5, 7, 0, 3, 0);

    @Nested
    class rankNumbersTest {

        @DisplayName("첫번째 답 도출 하여 맞는지")
        @Test
        void case1() {
            List<Integer> testNumbers = List.of(6, 7, 5, 4, 3, 2);
            assertEquals(firstAnswer, rank.rankNumbers(testNumbers));
        }

        @DisplayName("두번째 답 도출 하여 맞는지")
        @Test
        void case2() {
            List<Integer> testNumbers = List.of(1, 5, 7, 2, 3, 0);
            assertEquals(secondAnswer, rank.rankNumbers(testNumbers));
        }
    }

}