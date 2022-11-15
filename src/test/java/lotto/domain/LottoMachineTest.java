package lotto.domain;

import static lotto.constant.LottoRule.PRICE_OF_ONE_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @DisplayName("생성한 객체가 로또가 맞는지 확인한다.")
    @Test
    void should_HaveLotto_When_Publish() {
        // given
        String moneyRaw = "1000";
        // when
        List<Lotto> lottos = LottoMachine.publish(moneyRaw);
        // then
        assertThat(lottos.get(0)).isInstanceOf(Lotto.class);
    }

    @DisplayName("입력 금액에 해당하는 개수만큼 로또를 구매했는지 확인한다.")
    @Test
    void should_HaveLottosOfCorrectCount_When_Purchase() {
        // given
        int money = PRICE_OF_ONE_LOTTO * 5;
        String moneyRaw = Integer.toString(PRICE_OF_ONE_LOTTO * 5);
        // when
        List<Lotto> lottos = LottoMachine.publish(moneyRaw);
        int countLottosByPrice = money / PRICE_OF_ONE_LOTTO;
        // then
        assertThat(lottos.size()).isEqualTo(countLottosByPrice);
    }

    @DisplayName("입력 금액이 로또 가격의 배수가 아니면 예외가 발생한다.")
    @Test
    void should_ThrowIllegalArgumentException_When_IsNotMultipleOfPrice() {
        assertThatThrownBy(() -> LottoMachine.publish("7001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}