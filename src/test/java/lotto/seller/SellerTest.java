package lotto.seller;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.seller.Seller;
import lotto.domain.seller.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SellerTest {

    @DisplayName("구입 금액을 통해서 로또를 몇 장 구매할 수 있는지 찾기")
    @Test
    void findLottoCountByMoney(){
        Seller seller = new Country();
        int money = 10000;
        int lottoCount = seller.findLottoCountByMoney(money);
        assertThat(lottoCount).isEqualTo(10);
    }
}
