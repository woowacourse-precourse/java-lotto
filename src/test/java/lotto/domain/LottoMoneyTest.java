package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoMoneyTest {

    @Test
    void inputMoney() {
        LottoMoney lottoMoney = new LottoMoney();
        Assertions.assertThat(1000).isEqualTo(lottoMoney.inputMoney("1000"));
    }
}