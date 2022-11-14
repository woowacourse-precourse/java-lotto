package lotto.domain.seller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.seller.Country;
import lotto.domain.seller.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SellerTest {

    @DisplayName("[성공] 구입 금액을 통해서 로또를 몇 장 구매할 수 있는지 찾기")
    @Test
    void findLottoCountByMoney() {
        Seller seller = new Country();
        int money = 10000;
        int lottoCount = seller.findLottoCountByMoney(money);
        assertThat(lottoCount).isEqualTo(10);
    }

    @DisplayName("[예외 발생] 로또 금액이 1000원으로 나누어 떨어지지 않는다면 IllegalException 발생")
    @Test
    void findLottoCountByMoney_() {
        Seller seller = new Country();
        int money = 10001;
        assertThatThrownBy(() -> seller.findLottoCountByMoney(money))
            .isInstanceOf(IllegalArgumentException.class);
    }


}
