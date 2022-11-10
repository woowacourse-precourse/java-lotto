package lotto.computer;

import lotto.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoComputerTest {

    LottoComputer lottoComputer;
    Money money;

    @BeforeEach
    public void setComputer() {
        money = new Money("10000");
        lottoComputer = new LottoComputer(money);
    }

    @Test
    void 컴퓨터에서_생성한_로또_수10() {
        lottoComputer.buyLotto();
        Assertions.assertThat(lottoComputer.howManyLotto()).isEqualTo(10);
    }
}