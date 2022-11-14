package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @DisplayName("중복 되지 않는 숫자 6개를 생성한다.")
    @Test
    void createNumbers() {
        List<Integer> numbers = new LottoGenerator().numbers;
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbersAllDifferent(numbers)).isEqualTo(true);
        assertThat(numbersSorted(numbers)).isEqualTo(true);
    }

    private boolean numbersAllDifferent(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int tmp = numbers.get(i);
            if (Collections.frequency(numbers, tmp) > 1)
                return false;
        }
        return true;
    }

    private boolean numbersSorted(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1))
                return false;
        }
        return true;
    }
}