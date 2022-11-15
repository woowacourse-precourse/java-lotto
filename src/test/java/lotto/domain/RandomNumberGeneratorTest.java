package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
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

    @Test
    @DisplayName("범위는 1~45 이다.")
    void createdRandomNumbersValidRange() {
        RandomNumbersGenerator randomNumbers = new RandomNumbersGenerator();
        List<Integer> sortedNumbers = randomNumbers.createRandomNumbers();
        assertThat(sortedNumbers).allMatch(n -> n > 0 && n < 46);
    }

}
