package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @DisplayName("중복되지 않는 숫자 6개를 추출하는 기능 테스트")
    @Test
    void createUniqueNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < 100; i++) {
            List<Integer> randomNumbers = numberGenerator.createUniqueRandomNumbers();
            List<Integer> uniqueRandomNumbers = randomNumbers.stream()
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(uniqueRandomNumbers);
            assertThat(uniqueRandomNumbers.size()).isEqualTo(6);
        }
    }
}
