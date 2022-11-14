package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.Const.*;
import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    @Test
    void 입력된_수량_만큼의_로또를_생성한다1() {
        // given
        long money = 10_000;
        long quantity = money / LOTTO_PRICE_UNIT;

        // when
        List<Lotto> lottos = LottoMachine.order(quantity);

        // then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @Test
    void 입력된_수량_만큼의_로또를_생성한다2() {
        // given
        long money = 2_500_000_000L;
        long quantity = money / LOTTO_PRICE_UNIT;

        // when
        List<Lotto> lottos = LottoMachine.order(quantity);

        // then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @Test
    void 로또를_생성했을때_오름차순_정렬된_로또를_반환한다() {
        // given
        long money = 10_000;
        long quantity = money / LOTTO_PRICE_UNIT;

        // when
        List<Lotto> lottos = LottoMachine.order(quantity);
        long sortedLottoQuantity = lottos.stream()
                .filter(lotto -> isAscendingOrder(lotto.getNumbers()))
                .count();
        // then
        assertThat(sortedLottoQuantity).isEqualTo(quantity);
    }

    private boolean isAscendingOrder(List<Integer> numbers) {
        int prev = 0;
        for (Integer number : numbers) {
            if (number < prev) {
                return false;
            }
            prev = number;
        }
        return true;
    }
}