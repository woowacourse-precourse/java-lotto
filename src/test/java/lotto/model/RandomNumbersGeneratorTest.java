package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {
    @DisplayName("서로 다른 1~45사이의 숫자 6개 생성")
    @Test
    void creat_numbers() {
        assertThatCode(RandomNumbersGenerator::creatSixDifferentNumbers).doesNotThrowAnyException();
    }

}
