package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCountTest {
    @ParameterizedTest
    @DisplayName("구입 금액에 따른 로또의 갯수를 확인하는 테스트")
    @ValueSource(strings = {"1000","2000","14000","8000","42000"})
    void 로또_갯수_Count_테스트(String input){
        LottoMoney lottoMoney = new LottoMoney(input);
        Assertions.assertThat(lottoMoney.changeToLottoCount()).isEqualTo(Integer.parseInt(input)/LottoMoney.LOTTO_PRICE);
    }
}
