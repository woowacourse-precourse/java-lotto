package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgmentTest {
    @DisplayName("1등으로 당첨된 로또의 개수를 계산한다.")
    @Test
    void createFirstCount() {
        Judgment judgment = new Judgment(List.of(List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 7);
        assertEquals(2, judgment.firstCount);
    }

    @DisplayName("2등으로 당첨된 로또의 개수를 계산한다.")
    @Test
    void createSecondCount() {
        Judgment judgment = new Judgment(List.of(List.of(1, 2, 3, 4, 5, 7),
                List.of(2, 3, 4, 5, 6, 8),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 3, 4, 5, 6, 7)), List.of(1, 2, 3, 4, 5, 6), 7);
        assertEquals(2, judgment.secondCount);
    }

    @DisplayName("3등으로 당첨된 로또의 개수를 계산한다.")
    @Test
    void createThirdCount() {
        Judgment judgment = new Judgment(List.of(List.of(1, 2, 3, 4, 5, 7),
                List.of(2, 3, 4, 5, 6, 8),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 3, 4, 5, 6, 7)), List.of(1, 2, 3, 4, 5, 6), 7);
        assertEquals(1, judgment.thirdCount);
    }

    @DisplayName("4등으로 당첨된 로또의 개수를 계산한다.")
    @Test
    void createFourthCount() {
        Judgment judgment = new Judgment(List.of(List.of(1, 2, 3, 4, 5, 7),
                List.of(2, 3, 4, 5, 6, 8),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 3, 4, 5, 6, 42)), List.of(1, 2, 3, 4, 40, 41), 42);
        assertEquals(2, judgment.fourthCount);
    }

    @DisplayName("5등으로 당첨된 로또의 개수를 계산한다.")
    @Test
    void createFifthCount() {
        Judgment judgment = new Judgment(List.of(List.of(1, 2, 3, 4, 5, 7),
                List.of(2, 3, 4, 5, 6, 8),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 3, 4, 5, 6, 42)), List.of(1, 2, 3, 4, 40, 41), 42);
        assertEquals(2, judgment.fifthCount);
    }
}