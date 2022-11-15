package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.Const.*;
import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    @DisplayName("입력된_금액_만큼의_로또를_생성한다1")
    @Test
    void createLottoByInputMoney() {
        // given
        long money = 10_000;
        long quantity = money / LOTTO_PRICE_UNIT;

        // when
        List<Lotto> lottos = LottoMachine.order(money);

        // then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @DisplayName("입력된_금액_만큼의_로또를_생성한다2")
    @Test
    void createLottoByLongTypeRangeInputMoney() {
        // given
        long money = 2_500_000_000L;
        long quantity = money / LOTTO_PRICE_UNIT;

        // when
        List<Lotto> lottos = LottoMachine.order(money);

        // then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @DisplayName("로또를 생성했을때 오름차순 정렬된 로또를 반환한다")
    @Test
    void createAscendingOrderedLotto() {
        // given
        long money = 10_000;
        long quantity = money / LOTTO_PRICE_UNIT;

        // when
        List<Lotto> lottos = LottoMachine.order(money);
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