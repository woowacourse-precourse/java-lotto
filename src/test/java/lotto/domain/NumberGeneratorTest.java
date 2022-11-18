package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @DisplayName("createLottoNumbers의 범위를 검사한다.")
    @Test
    void createLottoNumbers_테스트1() {
        List<Integer> result = numberGenerator.createLottoNumbers();

        for(Integer item : result) {
            assertThat(item).isGreaterThan(0);
            assertThat(item).isLessThan(46);
        }
    }
}