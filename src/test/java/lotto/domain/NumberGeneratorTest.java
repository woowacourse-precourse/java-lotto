package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
    void checkNumbersSize() {
        assertThat(numbers)
                .hasSize(6);
    }

}