package lotto.domain.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.exceptions.WinNumInputException.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinNumInputExceptionTest {

    @DisplayName("당첨 번호 입력 값에 쉼표가 포함되지 않을 경우 예외가 발생한다.")
    @Test
    void winNumFormatError_예외처리_테스트() {
        assertThatThrownBy(() -> winNumFormatError("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 값에 숫자가 아닌 값이 포함되었을 경우 예외가 발생한다.")
    @Test
    void winNumTypeError_예외처리_테스트() {
        assertThatThrownBy(() -> winNumTypeError("17,32,14,a,34,16"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 값이 1~45의 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void winNumRangeError_예외처리_테스트() {
        assertThatThrownBy(() -> winNumRangeError(53))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 값에 중복이 존재할 경우 예외가 발생한다.")
    @Test
    void winNumDuplicate_예외처리_테스트() {
        assertThatThrownBy(() -> winNumDuplicate(new String[]{"19", "2", "22", "34", "14", "2"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 값이 6개의 숫자가 아닐 경우 발생한다.")
    @Test
    void winNumSizeError_예외처리_테스트_5개_입력() {
        assertThatThrownBy(() -> winNumSizeError(new String[]{"19", "2", "22", "34", "14"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 값이 6개의 숫자가 아닐 경우 발생한다.")
    @Test
    void winNumSizeError_예외처리_테스트_7개_입력() {
        assertThatThrownBy(() -> winNumSizeError(new String[]{"19", "2", "22", "34", "14", "3", "27"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

}