package lotto.randomnumber;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.randomnumber.RandomGenerator.generateRandomNumbers;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * RandomGenerator 클래스에 관한 테스트 클래스입니다.
 */
class RandomGeneratorTest {

    /**
     * 정상적으로 7개의 중복되지 않는 난수를 생성하는지 테스트합니다.
     */
    @Test
    void generateRandomNumbersTest() {
        for (int i = 0; i < 100; i++) {
            List<Integer> randomNumbers = generateRandomNumbers();
            Set<Integer> uniqueRandomNumbers = new HashSet<>(randomNumbers);
            assertThat(uniqueRandomNumbers.size()).isEqualTo(6);
        }
    }
}