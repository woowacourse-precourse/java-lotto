package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {
    @Test
    void 숫자_서로_다른_6개_생성() {
        assertThatCode(RandomNumbersGenerator::creatSixDifferentNumbers).doesNotThrowAnyException();
    }

}
