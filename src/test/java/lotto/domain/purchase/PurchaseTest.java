package lotto.domain.purchase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {

    @DisplayName("구입 금액에 숫자 외의 다른 문자가 포함되어 있는 경우 예외가 발생한다.")
    @Test
    void containAnyString() {
        assertThatThrownBy(() -> new Purchase("wooteco1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자가 하나도 없는 경우 예외가 발생한다.")
    @Test
    void notContainNumber() {
        assertThatThrownBy(() -> new Purchase("Backend"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void divideBy1000() {
        assertThatThrownBy(() -> new Purchase("5555"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따른 로또 개수를 올바르게 반환한다.")
    @Test
    void numOfLottoTest() {
        Purchase purchase = new Purchase("12000");

        assertThat(purchase.numOfLotto()).isEqualTo(12);
    }
}