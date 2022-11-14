package lotto.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void 로또_구매_테스트() {
        long initialMoney = 1000;
        long finalMoney = 0;
        Player player = new Player(initialMoney);

        player.buyLotto();

        assertThat(player).isEqualTo(
                new Player(finalMoney, player.getLotteries())
        );
    }
}