package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    final Counter counter = new Counter();
    final List<Integer> testRanking = List.of(7, 6, 6, 5, 5, 4, 3, 3);
    final List<Integer> testRankingTwo = List.of(0, 0, 0, 0, 0, 0);

    @Nested
    class countFirst {

        @DisplayName("1등이 2명 일때")
        @Test
        void firstCountCase1() {
            int answer = 2;
            int testResult = counter.countFirst(testRanking);
            assertEquals(answer, testResult);

        }

        @DisplayName("1등이 0명 일때")
        @Test
        void firstCountCase2() {
            int answer = 0;
            int testResult = counter.countFirst(testRankingTwo);
            assertEquals(answer, testResult);
        }
    }

    @Nested
    class countSecond {

        @DisplayName("2등이 1명 일때")
        @Test
        void secondCountCase1() {
            int answer = 1;
            int testResult = counter.countSecond(testRanking);
            assertEquals(answer, testResult);
        }

        @DisplayName("2등이 0명 일때")
        @Test
        void secondCountCase2() {
            int answer = 0;
            int testResult = counter.countSecond(testRankingTwo);
            assertEquals(answer, testResult);
        }
    }

    @Nested
    class countThird {

        @DisplayName("3등이 2명 일때")
        @Test
        void secondCountCase1() {
            int answer = 2;
            int testResult = counter.countThird(testRanking);
            assertEquals(answer, testResult);
        }

        @DisplayName("3등이 0명 일때")
        @Test
        void secondCountCase2() {
            int answer = 0;
            int testResult = counter.countThird(testRankingTwo);
            assertEquals(answer, testResult);
        }
    }

    @Nested
    class countFourth {

        @DisplayName("4등이 1명 일때")
        @Test
        void secondCountCase1() {
            int answer = 1;
            int testResult = counter.countFourth(testRanking);
            assertEquals(answer, testResult);
        }

        @DisplayName("4등이 0명 일때")
        @Test
        void secondCountCase2() {
            int answer = 0;
            int testResult = counter.countFourth(testRankingTwo);
            assertEquals(answer, testResult);
        }
    }

    @Nested
    class countFifth {

        @DisplayName("5등이 2명 일때")
        @Test
        void secondCountCase1() {
            int answer = 2;
            int testResult = counter.countFifth(testRanking);
            assertEquals(answer, testResult);
        }

        @DisplayName("5등이 0명 일때")
        @Test
        void secondCountCase2() {
            int answer = 0;
            int testResult = counter.countFifth(testRankingTwo);
            assertEquals(answer, testResult);
        }
    }

}