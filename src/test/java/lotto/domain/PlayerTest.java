package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    void setSystemInput(String command) {
        System.setIn(new ByteArrayInputStream(command.getBytes()));
    }

    @Test
    @DisplayName("로또 10장 금액으로 구매 시 10장이 구입되어야 한다.")
    void purchaseLottos() {
        // given
        setSystemInput(String.valueOf(10 * LOTTO_PRICE));
        // when
        Player player = Player.purchase();
        // then
        assertThat(player.getPurchaseLottos()).hasSize(10);
    }

    @Test
    @DisplayName("로또 구매 시 로또 금액 단위로 나누어 떨어지지 않을 때 예외가 발생한다.")
    void purchaseLottosDoNotDivide() {
        // given
        setSystemInput(String.valueOf(LOTTO_PRICE + 1));
        // when
        // then
        assertThatThrownBy(Player::purchase)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 입력한 대로 로또 구매 금액을 반환해야 한다.")
    void inputPurchasePrice() {
        // given
        setSystemInput(String.valueOf(LOTTO_PRICE));
        // when
        int purchasePrice = Player.inputPurchasePrice();
        // then
        assertThat(purchasePrice).isEqualTo(LOTTO_PRICE);
    }

    @Test
    @DisplayName("로또 구매 금액은 숫자여야 한다.")
    void inputPurchasePrice_NotNumeric() {
        // given
        setSystemInput("ABC");
        // when
        // then
        assertThatThrownBy(Player::inputPurchasePrice)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또를 생성해서 반환해준다.")
    void generateLotto() {
        // given
        // when
        Lotto lotto = Player.generateLotto();
        // then
        assertThat(lotto).isNotNull();
    }

}