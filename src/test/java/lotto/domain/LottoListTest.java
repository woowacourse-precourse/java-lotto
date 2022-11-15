package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {

    @Test
    @DisplayName("구입 금액에 따라 로또생성")
    void createLotto() {
        PriceQuantity lottoQuantity = new PriceQuantity(8000);
        int quantity = lottoQuantity.getQuantity();
        LottoList LottoPaper = new LottoList();
        LottoPaper.createLotto(quantity);
        Assertions.assertThat(LottoPaper.getLottoList().size()).isEqualTo(8);
    }

}