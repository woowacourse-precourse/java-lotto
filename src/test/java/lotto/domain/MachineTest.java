package lotto.domain;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MachineTest {

    @Test
    @DisplayName("user가 넣은 금액에 대해 구매 가능한 로또의 개수를 반환한다.")
    void countNumberOfLottos() {
        // Given
        BigInteger money = new BigInteger("999999999123123123000");

        // When
        BigInteger numberOfLottos = Machine.countNumberOfLottos(money);

        // Then
        assertThat(numberOfLottos).isEqualTo(new BigInteger("999999999123123123"));
    }

    @Test
    @DisplayName("구매 가능한 로또의 개수만큼 로또를 생성한다.")
    void generateLottos() {
        // Given
        BigInteger purchaseNumberOfLottos = new BigInteger("10000");

        // When
        List<Lotto> lottos = Machine.generateLottos(purchaseNumberOfLottos);
        BigInteger countOfPurchasedLottos = new BigInteger(String.valueOf(lottos.size()));

        // Then
        assertThat(countOfPurchasedLottos).isEqualTo(purchaseNumberOfLottos);
    }

}