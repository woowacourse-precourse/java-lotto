package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("한글을 입력하는 경우 예외가 발생한다.")
    @Test
    void inputKorean() {
        assertThatThrownBy(() -> Validator.isOneNumber("안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("영어를 입력하는 경우 예외가 발생한다.")
    @Test
    void inputEnglish() {
        assertThatThrownBy(() -> Validator.isOneNumber("hello"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특수문자(쉽표 등)를 입력하는 경우 예외가 발생한다.")
    @Test
    void inputEtc() {
        assertThatThrownBy(() -> Validator.isOneNumber(","))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자와 쉼표 조합 외에 입력하는 경우 예외가 발생한다.")
    @Test
    void onlyNumberComma() {
        assertThatThrownBy(() -> Validator.isNumbers("1,안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
