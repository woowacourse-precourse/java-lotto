package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("6개 일치")
    @Test
    void six() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        calculator.compare(lotto);
        Result result = calculator.getResult();
        List<Integer> actual = result.getStatus();
        List<Integer> expected = List.of(0, 0, 0, 0, 1);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("5개 보너스 일치")
    @Test
    void fiveBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        calculator.compare(lotto);
        Result result = calculator.getResult();
        List<Integer> actual = result.getStatus();
        List<Integer> expected = List.of(0, 0, 0, 1, 0);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("5개 일치")
    @Test
    void five() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        calculator.compare(lotto);
        Result result = calculator.getResult();
        List<Integer> actual = result.getStatus();
        List<Integer> expected = List.of(0, 0, 1, 0, 0);
        assertThat(actual).isEqualTo(expected);
    }
}