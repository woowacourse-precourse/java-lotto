package lotto.domain.exceptions;

import lotto.domain.StartLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static lotto.domain.exceptions.PaymentInputException.paymentTypeError;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PaymentInputExceptionTest {

    @DisplayName("로또 구매금액 입력 값에 숫자가 아닌 값이 포함되었을 경우 예외가 발생한다.")
    @Test
    void paymentTypeError_예외처리_테스트() {
        assertThatThrownBy(() -> paymentTypeError("31000원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액 입력 값이 1000 단위로 나누어지지 않을 경우 예외가 발생한다.")
    @Test
    void paymentChangeError_예외처리_테스트() {
        StartLotto.payment = 3500;
        assertThatThrownBy(PaymentInputException::paymentChangeError)
                .isInstanceOf(IllegalArgumentException.class);
    }
}