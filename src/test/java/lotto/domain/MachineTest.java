package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

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

}