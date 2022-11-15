package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    @DisplayName("로또 번호 생성")
    void createLottoRandomNumbersTest() {
        assertThat(6).isEqualTo(LottoFactory.createLottoRandomNumbers().size());
    }

    @Test
    @DisplayName("금액만큼 로또 생성")
    void createLottoByMoneyTest() {
        assertThat(3).isEqualTo(LottoFactory.createLottoByMoney(new UserAmount("3000")).size());
    }

}