package lotto.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

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
            player.setLottoCount(money);
            int result = player.getLottoCount();
            int expect = 14;

            assertThat(result).isEqualTo(expect);
        }

        @Test
        void case2() {
            int money = 2000000;
            player.setLottoCount(money);
            int result = player.getLottoCount();
            int expect = 2000;

            assertThat(result).isEqualTo(expect);
        }
    }


    @Nested
    @DisplayName("SetLottos 메소드 테스트")
    class TestSetLottos {

        @Test
        @DisplayName("구입 횟수가 1번일 때")
        void case1() {
            int lottoCount = 1;
            player.setLottos(lottoCount);
            assertThat(player.getLottos().size()).isEqualTo(1);
        }

        @Test
        @DisplayName("구입 횟수가 여러번일 때")
        void case2() {
            int lottoCount = 9;
            player.setLottos(lottoCount);
            assertThat(player.getLottos().size()).isEqualTo(9);
        }
    }
}