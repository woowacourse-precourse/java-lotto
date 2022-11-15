package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class NumberGeneratorTest {

    private final NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    @DisplayName("랜덤 로또 번호 생성 테스트")
    void createRandomLottoNumbersTest() {
        Assertions.assertThat(numberGenerator.createRandomLottoNumbers()).isInstanceOf(ArrayList.class);
        Assertions.assertThat(numberGenerator.createRandomLottoNumbers().get(0)).isInstanceOf(Integer.class);
    }
}