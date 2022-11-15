package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {
    Store store;
    Buyer buyer;

    @BeforeEach
    void beforeEach() {
        store = new Store();
        buyer = new Buyer(store);
    }

    @Test
    void 한장구매() {
        buyer.buyLotto(1000);
        List<Lotto> lottos = buyer.getMyLottos();
        assertThat(lottos.size()).isEqualTo(1);
    }

    @Test
    void 두장구매() {
        buyer.buyLotto(2000);
        List<Lotto> lottos = buyer.getMyLottos();
        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    void 다섯장구매() {
        buyer.buyLotto(5000);
        List<Lotto> lottos = buyer.getMyLottos();
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    void checkPrize() {

    }

    @Test
    void checkRate_10개사서_5등1개() {
        LottoResult result = new LottoResult();
        result.addPrize(Prize.PRIZE5);
        int total = (int) result.getTotalMoney();
        int seedMoney = 10000;

        float rate = buyer.checkRate(seedMoney, total);
        assertThat(rate).isEqualTo(50);
    }

    @Test
    void checkRate_100개사서_3등1개() {
        LottoResult result = new LottoResult();
        result.addPrize(Prize.PRIZE3);
        int total = (int) result.getTotalMoney();
        int seedMoney = 100000;

        float rate = buyer.checkRate(seedMoney, total);
        assertThat(rate).isEqualTo(1500);
    }

    @Test
    void checkRate() {
        LottoResult result = new LottoResult();
        result.addPrize(Prize.PRIZE5);
        result.addPrize(Prize.PRIZE4);
        result.addPrize(Prize.PRIZE3);
        int total = (int) result.getTotalMoney();
        int seedMoney = 15000;

        float rate = buyer.checkRate(seedMoney, total);
        assertThat(rate).isEqualTo(10366.67f);
    }
}