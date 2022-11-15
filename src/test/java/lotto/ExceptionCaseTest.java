package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionCaseTest {
    @DisplayName("입력받은 금액의 형식이 정수인지 확인")
    @Test
    void testCheckIfInteger() {
        assertThatThrownBy(() -> new ExceptionCase()
                .checkIfAmountInputIsInteger("1000.0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 금액이 1000 으로 나누어 떨어지는지 확인")
    @Test
    void testCheckIf1000Unit() {
        assertThatThrownBy(() -> new ExceptionCase()
                .checkIf1000Unit("1005"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또 번호가 형식에 맞게 입력되었는지 확인")
    @Test
    void testCheckIfRightFormat() {
        assertThatThrownBy(() -> new ExceptionCase()
                .checkIfNumberInRightFormat("T "))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("입력받은 로또 번호가 정확히 6개인지 확인")
    @Test
    void testCheckNumbersSize() {
        assertThatThrownBy(() -> new ExceptionCase()
                .checkNumbersSize(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또 번호가 중복이 없는는지 확인")
    @Test
    void testCheckNumbersOverLap() {
        assertThatThrownBy(() -> new ExceptionCase()
                .checkNumbersOverLap(List.of(1, 2, 3, 4, 5, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또 번호들의 범위가 1-45인지 확인")
    @Test
    void testCheckNumbersRange() {
        assertThatThrownBy(() -> new ExceptionCase()
                .checkNumbersRange(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 보너스 번호가 로또 번호들과 안 겹치는지 확인")
    @Test
    void testValidationForNumber() {
        assertThatThrownBy(() -> new ExceptionCase()
                .validationForNumber(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("압력받은 보너스 번호가 딱 하나의 정수로만 이루어져 있는지 확인")
    @Test
    void testValidationOfInput() {
        assertThatThrownBy(() -> new ExceptionCase()
                .validationOfInput("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}