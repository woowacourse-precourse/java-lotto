package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {
    @Test
    @DisplayName("1~45사이의 숫자가 서로 다른 6개 생성")
    void creat_numbers() {
        assertThatCode(RandomNumbersGenerator::creatSixDifferentNumbers).doesNotThrowAnyException();
    }

}
