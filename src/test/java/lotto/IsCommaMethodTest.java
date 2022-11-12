package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.isComma;
import static org.assertj.core.api.Assertions.assertThat;

class IsCommaMethodTest {
    @Test
    void isComma_메소드_예외_테스트1() {
        char charAtIndex = '!';
        assertThat(isComma(charAtIndex)).isEqualTo(false);
    }

    @Test
    void isComma_메소드_예외_테스트2() {
        char charAtIndex = ' ';
        assertThat(isComma(charAtIndex)).isEqualTo(false);
    }

    @Test
    void isComma_메소드_정상_입력_테스트3() {
        char charAtIndex = ',';
        assertThat(isComma(charAtIndex)).isEqualTo(true);
    }
}