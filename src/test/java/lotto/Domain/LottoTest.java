package lotto.Domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Nested
    @DisplayName("SetLottos 메소드 테스트")
    class TestSetLottos {

        @Test
        @DisplayName("구입 횟수가 1번일 때")
        void case1() {
            int lottoCount = 1;
            List<List<Integer>> result = lotto.setLottos(lottoCount);
            assertThat(result.size()).isEqualTo(1);
        }

        @Test
        @DisplayName("구입 횟수가 여러번일 때")
        void case2() {
            int lottoCount = 9;
            List<List<Integer>> result = lotto.setLottos(lottoCount);
            assertThat(result.size()).isEqualTo(9);
        }
    }
}