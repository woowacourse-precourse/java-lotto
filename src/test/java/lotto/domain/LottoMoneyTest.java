package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoMoneyTest {
    @Test
    void 정상적인_금액_입력() {
        LottoMoney lottoMoney = new LottoMoney();
        lottoMoney.inputMoney("8000");
        assertThat(8).isEqualTo(lottoMoney.getLottoQuantity());
    }

    @Test
    void 금액이_숫자가_아님() {
        LottoMoney lottoMoney = new LottoMoney();
        assertThatThrownBy(() -> lottoMoney.inputMoney("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void _1000원으로_안_나눠짐1() {
        LottoMoney lottoMoney = new LottoMoney();
        assertThatThrownBy(() -> lottoMoney.inputMoney("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void _1000원으로_안_나눠짐2() {
        LottoMoney lottoMoney = new LottoMoney();
        assertThatThrownBy(() -> lottoMoney.inputMoney("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈문자열_입력() {
        LottoMoney lottoMoney = new LottoMoney();
        assertThatThrownBy(() -> lottoMoney.inputMoney(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}