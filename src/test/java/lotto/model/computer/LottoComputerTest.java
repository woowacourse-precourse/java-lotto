package lotto.model.computer;

import lotto.model.computer.LottoComputer;
import lotto.model.resources.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoComputerTest {

    LottoComputer lottoComputer;

    @BeforeEach
    void setLottoComputer() {
        lottoComputer = new LottoComputer();
    }

    @Test
    void LottoComputer_클래스의_getMoney_테스트() {
        lottoComputer.buyLotto(new Money("10000"));
        Assertions.assertThat(lottoComputer.getMoney()).isEqualTo(10000);
    }

    @Test
    void 돈을_입력한_만큼_LottoComputer에서_lottoRepository의_크기를_잘_가져오는지() {
        lottoComputer.buyLotto(new Money("10000"));
        Assertions.assertThat(lottoComputer.howManyLotto()).isEqualTo(10);
    }
}