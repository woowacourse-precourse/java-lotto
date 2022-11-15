package lotto.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import lotto.domain.lotto.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @DisplayName("로또 구매 테스트")
    @Test
    void buyingLotto() {
        long initialMoney = 1000;
        long finalMoney = 0;
        Player player = new Player(initialMoney);

        player.buyLotto();

        assertThat(player).isEqualTo(
                new Player(finalMoney, player.getLotteries())
        );
    }

    @DisplayName("로또 결과를 저장하면 플레이어의 수익률이 저장된다.")
    @Test
    void saveResult() {
        long initialMoney = 8000;
        Player player = new Player(initialMoney);
        HashMap<LottoPrize, Long> lottoResults = new HashMap<>();
        lottoResults.put(LottoPrize.FIFTH, 1L);

        player.buyLotto();
        player.saveResult(lottoResults);

        double earningRate = player.getEarningRate();
        assertThat(earningRate).isEqualTo(62.5);
    }
}