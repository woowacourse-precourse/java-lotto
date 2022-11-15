package lotto;

import lotto.model.Lotto;
import lotto.model.LottoStore;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoStoreTest {

    LottoStore lottoStore = new LottoStore();

    @DisplayName("1000원으로 나누어떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void buyLottoByInvalidMoney() {
        Assertions.assertThatThrownBy(() -> lottoStore.buyLottoNumber(7900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 부족하여 구매할 수 없을 경우 예외가 발생한다.")
    @Test
    void buyLottoByNoMoney() {
        Assertions.assertThatThrownBy(() -> lottoStore.buyLottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 금액을 입력하면, 정상적으로 동작한다.")
    @Test
    void buyLottoByValidMoney() {
        List<Lotto> lottoTickets = lottoStore.buyLottoNumber(3000);
        Assertions.assertThat(lottoTickets.size())
                .isEqualTo(3);
    }
}