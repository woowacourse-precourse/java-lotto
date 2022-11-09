package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ShopTest {

    @Test
    @DisplayName("구입금액에 문자가 있을 경우 예외가 발생한다.")
    void createInputByString() {
        String testMoney = "1000a";
        System.setIn(new ByteArrayInputStream(testMoney.getBytes()));
        Shop shop = new Shop();

        assertThatThrownBy(shop::inputMoney)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    void createInputByCannotDivideNumber() {
        String testMoney = "12345";
        System.setIn(new ByteArrayInputStream(testMoney.getBytes()));
        Shop shop = new Shop();

        assertThatThrownBy(shop::inputMoney)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 금액만큼 로또를 생성해서 로또 리스트로 반환한다.")
    void sellLotto() {
        String testMoney = "8000";
        System.setIn(new ByteArrayInputStream(testMoney.getBytes()));
        Shop shop = new Shop();
        shop.inputMoney();
        List<Lotto> lotto = shop.sellLotto();
        Assertions.assertThat(lotto.size()).isEqualTo(8);
    }
}