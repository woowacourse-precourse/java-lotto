package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputDriverTest {

    @Test
    void inputBuyingAmount() {
        assertThatThrownBy(() -> new ExceptionCase()
                .checkIfAmountInputIsInteger("천 원"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ExceptionCase()
                .checkIf1000Unit("100100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputNumbers() {
        assertThatThrownBy(() -> new ExceptionCase()
                .checkIfNumberInRightFormat("다섯"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ExceptionCase()
                .checkIfNumberInRightFormat("1 "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputBonusNumber() {
        assertThatThrownBy(() -> new ExceptionCase()
                .validationForRange(46))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ExceptionCase()
                .validationOfInput("123F"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ExceptionCase()
                .validationForNumber(List.of(1,2,3,4,5,7),7))
                .isInstanceOf(IllegalArgumentException.class);
    }
}