package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {

    @Test
    @DisplayName("금액에 대한 로또 생성하기 테스트")
    void createLottoForMoney() {
        // given
        Money money = new Money("8000");
        int expectedLottoCount = 8;

        // when
        LottoShop lottoShop = new LottoShop();
        List<Lotto> result = lottoShop.createLottoForMoney(money);

        // then
        assertThat(expectedLottoCount).isEqualTo(result.size());
    }

}