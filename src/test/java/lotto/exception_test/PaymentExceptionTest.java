package lotto.exception_test;

import lotto.exception.PaymentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class PaymentExceptionTest {

    PaymentException paymentException;

    @BeforeEach
    void initializeClass(){
        paymentException = new PaymentException();
    }

    @DisplayName("입력값이 1000으로 나눈 몫이 0이면 예외처리")
    @Test
    void dividingResultZeroException(){
        assertThatThrownBy(() -> paymentException.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나눈 나머지가 0이 아니면 예외처리")
    @Test
    void leftAfterDividingNotZeroException(){
        assertThatThrownBy(() -> paymentException.validate("2900"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
