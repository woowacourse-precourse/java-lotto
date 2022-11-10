package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    private static List<Integer> numbers;

    @BeforeAll
    static void beforeAll() {
        numbers = NumberGenerator.createRandomNumber();
    }

    @Test
    void 생성된_숫자의_개수는_6개여야_합니다() {
        int size = numbers.size();

        assertThat(size).isEqualTo(6);
    }

    @Test
    void 생성된_숫자는_오름차순이어야_합니다() {
        boolean isSorted = true;
        for (int index = 1; index < numbers.size(); index++) {
            if (numbers.get(index) < numbers.get(index - 1)) {
                isSorted = false;
                break;
            }
        }

        assertThat(isSorted).isTrue();
    }
}
