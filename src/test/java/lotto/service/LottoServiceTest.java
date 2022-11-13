package lotto.service;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    int purchaseAmount = 50_000;

    @Test
    void pickWinningNumbers() {
        LottoService lottoService = new LottoService(purchaseAmount);

        lottoService.pickWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    void calculateRank() {
        LottoService lottoService = new LottoService(purchaseAmount);

        lottoService.pickWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        lottoService.calculateRank();
    }

    @Test
    void getLotteryInfo() {
        LottoService lottoService = new LottoService(purchaseAmount);
        System.out.println(lottoService.getLotteryInfo());
    }
}
