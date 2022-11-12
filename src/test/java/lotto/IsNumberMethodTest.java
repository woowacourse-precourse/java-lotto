package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.isNumber;
import static org.assertj.core.api.Assertions.assertThat;

class IsNumberMethodTest {
    @Test
    void isNumber_메소드_정상_입력_테스트() {
        for(char number = '0'; number <= '9'; number++)
            assertThat(isNumber(number)).isEqualTo(true);
    }

    @Test
    void isNumber_메소드_예외_테스트1() {
        for(char asciicode = 0; asciicode < 256; asciicode++) {
            if(asciicode >= '0' && asciicode <= '9') continue;
            assertThat(isNumber(asciicode)).isEqualTo(false);
        }
    }
}