package lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.Constants.LOTTO_SIZE;
import static lotto.utils.Constants.LOTTO_TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    int purchaseMoney;
    LottoMachine lottoMachine;

    @BeforeEach
    void setup() {
        purchaseMoney = 2000;
        lottoMachine = new LottoMachine(purchaseMoney);
    }

    @Test
    @DisplayName("발급된 로또의 수는 구입 수량과 같다.")
    void 로또의_수는_구입_수량과_동일() {
        assertThat(lottoMachine)
                .extracting("lottos", InstanceOfAssertFactories.LIST)
                .hasSize(purchaseMoney / LOTTO_TICKET_PRICE);
    }

    @Test
    @DisplayName("발급된 로또는 6개의 수로 이루어진다.")
    void 로또는_6개의_숫자() {
        assertThat(lottoMachine)
                .extracting("lottos", InstanceOfAssertFactories.LIST)
                .first(new InstanceOfAssertFactory<>(Lotto.class, Assertions::assertThat))
                .extracting("lottoNumbers", InstanceOfAssertFactories.LIST)
                .hasSize(LOTTO_SIZE);
    }
}