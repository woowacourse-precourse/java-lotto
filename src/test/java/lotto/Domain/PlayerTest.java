package lotto.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    Player player = new Player();

    @Nested
    @DisplayName("getLottoCount 메소드 테스트")
    class TestGetLottoCount {

        @Test
        @DisplayName("로또 수량을 구합니다.")
        void case1() {
            int money = 14000;
            int result = player.getLottoCount(money);
            int expect = 14;

            assertThat(result).isEqualTo(expect);
        }

        @Test
        void case2() {
            int money = 2000000;
            int result = player.getLottoCount(money);
            int expect = 2000;

            assertThat(result).isEqualTo(expect);
        }
    }
}