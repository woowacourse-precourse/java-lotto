package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("만들어진 번호의 갯수는 6개이다.")
    void createdRandomNumbersHasSixNumber() {
        RandomNumbersGenerator randomNumbers = new RandomNumbersGenerator();

        List<Integer> sortedNumbers = randomNumbers.createRandomNumbers();
        assertThat(sortedNumbers).hasSize(6);
    }
}
