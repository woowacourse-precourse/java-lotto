package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.isNumber;
import static org.assertj.core.api.Assertions.assertThat;

class IsNumberMethodTest {
    @DisplayName("0이상 9이하의 문자에 대해 true를 반환한다.")
    @Test
    void isNumberMethodTest1() {
        for (char number = '0'; number <= '9'; number++)
            assertThat(isNumber(number)).isEqualTo(true);
    }

    @DisplayName("그 외 모든 문자에 대해 false를 반환한다.")
    @Test
    void isNumberMethodTest2() {
        for (char asciicode = 0; asciicode < 256; asciicode++) {
            if(asciicode >= '0' && asciicode <= '9') continue;
            assertThat(isNumber(asciicode)).isEqualTo(false);
        }
    }
}