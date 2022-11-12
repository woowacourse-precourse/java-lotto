package lotto.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

}