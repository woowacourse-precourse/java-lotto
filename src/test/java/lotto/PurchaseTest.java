package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {

    @DisplayName("구입 금액에 숫자 이외의 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void inputMoneyByCharacter() {
        assertThatThrownBy(() -> new Purchase("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void inputMoneyIncludeCoin() {
        assertThatThrownBy(() -> new Purchase("14500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따른 로또 개수를 확인한다.")
    @Test
    void checkLottoAccordingToPurchase() {
        Purchase money = new Purchase("14000");
        assertThat(money.getLottoNumber()).isEqualTo(14);
    }
}
