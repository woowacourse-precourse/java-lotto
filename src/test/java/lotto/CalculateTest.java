package lotto;

import controller.Calculate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("맞춘 당첨번호에 따라 등수를 출력한다.")
    @Test
    void 당첨등수_테스트(){
        assertThat(Calculate.calculateWinning(List.of(6,0))).isEqualTo("FIRST");
        assertThat(Calculate.calculateWinning(List.of(5,1))).isEqualTo("SECOND");
        assertThat(Calculate.calculateWinning(List.of(5,0))).isEqualTo("THIRD");
        assertThat(Calculate.calculateWinning(List.of(4,1))).isEqualTo("THIRD");
        assertThat(Calculate.calculateWinning(List.of(4,0))).isEqualTo("FOURTH");
        assertThat(Calculate.calculateWinning(List.of(3,1))).isEqualTo("FOURTH");
        assertThat(Calculate.calculateWinning(List.of(3,0))).isEqualTo("FIFTH");
        assertThat(Calculate.calculateWinning(List.of(2,1))).isEqualTo("FIFTH");
        assertThat(Calculate.calculateWinning(List.of(1,0))).isEqualTo("NOTHING");
        assertThat(Calculate.calculateWinning(List.of(0,1))).isEqualTo("NOTHING");
        assertThat(Calculate.calculateWinning(List.of(0,0))).isEqualTo("NOTHING");

    }
}
