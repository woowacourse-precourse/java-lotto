package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    @DisplayName("로또 발행")
    void issueLotto() {
        int count = 5;
        int money = 5000;
        LottoService lottoService = new LottoService();

        List<Lotto> lotteries = lottoService.issueLotto(money);

        assertEquals(count, lotteries.size());
    }
}