package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("예외 처리 테스트")
class ExceptionServiceTest {

    @Test
    @DisplayName("입력받은 금액이 숫자인지 확인한다.")
    void exceptionHandlingOfPurchaseAmountTest() {
        ExceptionService exceptionService = new ExceptionService();
        String amount = "팔천원";
        assertThatThrownBy(() -> exceptionService.exceptionHandlingOfPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}