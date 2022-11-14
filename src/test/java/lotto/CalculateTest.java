package lotto;

import controller.Calculate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입금액_1000원단위_예외테스트(){
        assertThatIllegalArgumentException().isThrownBy(() -> { Calculate.calculatePurchaseQuantity(1400);})
                .withMessage("[ERROR] 구입금액이 1000원 단위가 아닙니다.");
    }

    @DisplayName("구입 금액에 따른 로또 수량을 출력한다.")
    @Test
    void 로또수량_테스트(){
        assertThat(Calculate.calculatePurchaseQuantity(15000)).isEqualTo(15);
    }

    @DisplayName("구입 금액에 따른 수익률을 출력한다.")
    @Test
    void 수익률_계산_테스트(){
        assertThat(Calculate.calculateYield(10000,5000)).isEqualTo("50.0%");
        assertThat(Calculate.calculateYield(1000,0)).isEqualTo("0.0%");
        assertThat(Calculate.calculateYield(7000,5000)).isEqualTo("71.4%");
    }
}
