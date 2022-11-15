package lotto.feature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    void test_createRandomNumbers() {
        List<Integer> randNum = new ArrayList<>(numberGenerator.createRandomNumbers());
        assertThat(randNum)
                .isNotEmpty()
                .hasSize(6);
        for (int index = 0; index < randNum.size(); index++) {
            assertThat(randNum).containsOnlyOnce(randNum.get(index));
        }
    }

    @Test
    void test_sortAscendingOrder() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1, 6));
        assertThat(numberGenerator.sortAscendingOrder(list))
                .isNotEmpty()
                .isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
