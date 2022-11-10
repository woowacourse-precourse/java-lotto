package lotto.lottoNumber;

import java.util.List;
import lotto.computer.lottoNumber.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    LottoNumber lottoNumber;

    @Test
    void 로또_리스트_넣고_잘_들어갔는지_확인() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        lottoNumber = new LottoNumber(list);
        Assertions.assertThat(lottoNumber.getLotto()).isEqualTo(list);
    }
}