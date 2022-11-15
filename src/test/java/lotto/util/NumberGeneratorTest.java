package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = NumberGenerator.createDifferentRandomNumbers();
    }

    @DisplayName("생성한 임의의 수 개수가 6개인지 확인한다.")
    @Test
    void isNumbersSize6() {
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("생성한 임의의 수 범위가 1부터 45까지인지 확인한다.")
    @Test
    void checkNumbersRange() {
        numbers.forEach(number -> assertThat(number).isBetween(1, 45 + 1));
    }

}