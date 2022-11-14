package lotto.domain;

import static lotto.constant.LottoRule.AMOUNT_OF_ONE_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @DisplayName("생성한 객체가 로또가 맞는지 확인한다.")
    @Test
    void publishLotto() {
        // given
        int inputMoney = 1000;
        // when
        List<Lotto> lottos = LottoMachine.publish(inputMoney);
        // then
        assertThat(lottos.get(0)).isInstanceOf(Lotto.class);
    }

    @DisplayName("입력 금액에 해당하는 개수만큼 로또를 구매했는지 확인한다.")
    @Test
    void publishLottosByAmount() {
        // given
        int inputMoney = AMOUNT_OF_ONE_LOTTO * 5;
        // when
        List<Lotto> lottos = LottoMachine.publish(inputMoney);
        int countLottosByAmount = inputMoney / AMOUNT_OF_ONE_LOTTO;
        // then
        assertThat(lottos.size()).isEqualTo(countLottosByAmount);
    }

    @DisplayName("입력 금액이 1,000의 배수가 아님 -> 예외님발생")
    @Test
    void isNotMultipleOf1000() {
        assertThatThrownBy(() -> LottoMachine.publish(7001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}