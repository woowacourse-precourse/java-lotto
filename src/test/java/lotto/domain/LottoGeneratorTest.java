package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void generateNumbers_success() {
        List<Integer> numbers = lottoGenerator.generateNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void generataNumbers_sort() {
        List<Integer> numbers = lottoGenerator.generateNumbers();

        assertThat(numbers).isEqualTo(numbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }

}