package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DigitUtilTest {

    @DisplayName("주어진 문자열이 숫자일 시 True 를 리턴한다")
    @Test
    void returnTrueWhenTextIsNumber() {
        boolean result = DigitUtil.isDigit("12345");

        assertThat(result).isTrue();
    }

    @DisplayName("주어진 문자열이 숫자가 아닐 시 False 를 리턴한다")
    @Test
    void returnFalseWhenTextIsNotNumber() {
        boolean result = DigitUtil.isDigit("1234s5");

        assertThat(result).isFalse();
    }

}