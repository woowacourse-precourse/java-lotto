package lotto;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    void 랜덤한_로또번호_생성() {
        // given
        int numberOfLottos = 10;
        int money = numberOfLottos * LottoMachine.UNIT;
        // when
        List<Lotto> randomLottos = LottoMachine.getRandomLottos(money);
        // then
        assertThat(randomLottos.size()).isEqualTo(numberOfLottos);
        for (Lotto lotto : randomLottos) {
            assertThat(getMin(lotto)).isGreaterThanOrEqualTo(LottoMachine.NUMBER_RANGE_BOT);
            assertThat(getMax(lotto)).isLessThanOrEqualTo(LottoMachine.NUMBER_RANGE_TOP);
        }
    }

    private Integer getMax(Lotto lotto) {
        Integer max = LottoMachine.NUMBER_RANGE_BOT - 1;
        List<Integer> numbers = lotto.getNumbers();

        for (Integer number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    private Integer getMin(Lotto lotto) {
        Integer min = LottoMachine.NUMBER_RANGE_TOP + 1;
        List<Integer> numbers = lotto.getNumbers();

        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }
}