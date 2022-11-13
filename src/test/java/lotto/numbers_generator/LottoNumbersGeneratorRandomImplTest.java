package lotto.numbers_generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGeneratorRandomImplTest {
    @Test
    void 중복없이1부터45까지의6개숫자생성() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGeneratorRandomImpl();
        List<Integer> numbers = lottoNumbersGenerator.generate();

        for(var number : numbers)
            assertThat(number).isGreaterThan(1).isLessThan(45);

        Set<Integer> set = new HashSet<>(numbers);
        assertThat(set.size()).isEqualTo(6);
    }
}