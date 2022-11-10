package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("10000원이 주어졌을 때 살수있는 로또의 개수는 10개")
    @Test
    void canByLottoCount() {
        Player player = new Player();
        int count = player.canBuyLottoCount(10000);
        Assertions.assertThat(count).isEqualTo(10);
    }
}
