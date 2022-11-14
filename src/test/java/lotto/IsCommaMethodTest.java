package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.isComma;
import static org.assertj.core.api.Assertions.assertThat;

class IsCommaMethodTest {
    @Test
    void isComma_메소드_정상_입력_테스트() {
        char character = ',';
        assertThat(isComma(character)).isEqualTo(true);
    }

    @Test
    void isComma_메소드_예외_테스트() {
        for(char asciicode = 0; asciicode < 256; asciicode++) {
            if(asciicode == ',') continue;
            assertThat(isComma(asciicode)).isEqualTo(false);
        }
    }
}