package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersGeneratorTest {

    private final NumbersGenerator numbersGenerator = new NumbersGenerator();

    @Test
    void 숫자_갯수_테스트() {
        List<Integer> result = numbersGenerator.generatorNumbers();

        System.out.println("result = " + result);
        assertThat(result).hasSize(6);
    }

    @Test
    void 숫자_범위_테스트() {
        List<Integer> result = numbersGenerator.generatorNumbers();

        assertThat(result).filteredOn(number -> number > 1 && number < 45);
    }
}