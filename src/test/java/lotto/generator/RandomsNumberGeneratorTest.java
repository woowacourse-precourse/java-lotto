package lotto.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomsNumberGeneratorTest {

    @Test
    void generateTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    NumberGenerator generator = new RandomsNumberGenerator();
                    List<Integer> numbers = generator.generate(1, 45, 6);

                    assertThat(numbers).isEqualTo(List.of(1, 11, 22, 41, 43, 44));
                },
                List.of(44, 43, 41, 22, 11, 1)
        );
    }

    @Test
    @DisplayName("min ~ max 범위의 크기가 size보다 커야함")
    void generateExceptionTest() {
        NumberGenerator generator = new RandomsNumberGenerator();
        assertThatThrownBy(() -> generator.generate(1, 5, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}