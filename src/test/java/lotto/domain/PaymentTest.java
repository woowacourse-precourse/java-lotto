package lotto.domain;

import lotto.constants.ErrorMessageConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class PaymentTest {
    private Payment payment;
    
    @BeforeEach
    void setUp() {
        payment = new Payment(8000);
    }
    
    @Test
    @DisplayName("구입 금액에 따른 로또 발행수 구하기")
    void countOfPurchasedLotto() {
        assertThat(payment.countOfPurchasedLotto()).isEqualTo(8);
    }
    
    @Test
    @DisplayName("예외 처리 : 1000 단위가 아닌 경우")
    void erroneousPaymentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Payment(14500))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 0인 경우")
    void paymentZeroException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Payment(0))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("수익률 구하기")
    void yield() {
        assertAll(
                () -> assertThat(payment.calculateYield(List.of(LottoRank.MISS))).isEqualTo(0.0),
                () -> assertThat(payment.calculateYield(List.of(LottoRank.FIFTH))).isEqualTo(62.5),
                () -> assertThat(new Payment(7000).calculateYield(List.of(LottoRank.FIFTH))).isEqualTo(71.4)
        );
    }
}
