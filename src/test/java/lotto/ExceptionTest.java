package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class ExceptionTest {

    @DisplayName("로또 구입 금액이 0으로 시작하면 예외가 발생한다.")
    @Test
    void createExceptionTest1() {
        assertThatThrownBy(() -> new Exception().checkPurchaseAmount("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000으로 나눠지지 않으면 예외가 발생한다.")
    @Test
    void createExceptionTest2() {
        assertThatThrownBy(() -> new Exception().checkPurchaseAmount("3500"))
                .isInstanceOf(IllegalArgumentException.class);
    }




}
