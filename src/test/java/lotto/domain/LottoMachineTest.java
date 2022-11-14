package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("6000으로 6개의 로또 객체 리스트를 생성한다")
    @Test
    void createLottoFor6000() {
        // given
        int money = 6000;
        int quantity = 6;

        // when
        List<Lotto> lottos = LottoMachine.buyLottos(money);

        // then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @DisplayName("1000으로 떨어지지 않는 정수에는 예외를 던진다")
    @Test
    void createLottosWithInvalidMoney() {
        // given
        int money = 6123;

        // then
        assertThatThrownBy(() -> LottoMachine.buyLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

}