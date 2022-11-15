package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    static List<Lotto> lotteries = new ArrayList<>();
    static List<Integer> winnings = new ArrayList<>();
    static int bonus;
    static double buyMoney;

    @BeforeEach
    void initLotteries() {
        lotteries.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lotteries.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lotteries.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lotteries.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lotteries.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lotteries.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lotteries.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lotteries.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        winnings = List.of(1, 2, 3, 4, 5, 6);
        bonus = 7;
        buyMoney = 8000;
    }

    @DisplayName("로또 수익률 출력 성공")
    @Test
    void getProfitRate() {
        LottoService lottoService = new LottoService(lotteries, winnings, bonus, buyMoney);
        String result = lottoService.getProfitRate();

        assertThat(result).isEqualTo("62.5");
    }
}
