package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GeneratorTest {
    @DisplayName("로또가 10개 생성하는지 확인한다.")
    @Test
    void Generator_정상동작_10개_생성() {
        Generator generator = new Generator(10);
        assertThat(generator.createLotto().size()).isEqualTo(10);
    }

}