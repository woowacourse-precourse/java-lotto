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

    @DisplayName("보너스 번호의 길이가 1이나 2가 아니면 예외가 발생한다")
    @Test
    void createExceptionTest3() {
        assertThatThrownBy(() -> new Exception().checkBonusNumber("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 범위를 초과하면 예외가 발생한다")
    @Test
    void createExceptionTest4() {
        assertThatThrownBy(() -> new Exception().checkBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 범위를 초과하면 예외가 발생한다")
    @Test
    void createExceptionTest5() {
        assertThatThrownBy(() -> new Exception().checkBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 첫 숫자가 0으로 시작하면 예외가 발생한다")
    @Test
    void createExceptionTest6() {
        assertThatThrownBy(() -> new Exception().checkBonusNumber("05"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다")
    @Test
    void createExceptionTest7() {
        assertThatThrownBy(() -> new Exception().checkBonusNumberOverLap("7","1,2,3,4,5,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니라면 예외가 발생한다")
    @Test
    void createExceptionTest8() {
        assertThatThrownBy(() -> new Exception().checkBonusNumberOverLap("7","a,2,3,4,5,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
