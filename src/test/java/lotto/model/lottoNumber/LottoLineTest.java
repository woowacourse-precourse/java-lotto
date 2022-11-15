package lotto.model.lottoNumber;

import java.util.List;
import lotto.model.computer.lottonumber.LottoLine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoLineTest {

    LottoLine lottoLine;

    @Test
    void 로또_리스트_넣고_잘_들어갔는지_확인() {
        lottoLine = new LottoLine(List.of(1, 2, 3, 4, 5, 6));
        String result = "[1, 2, 3, 4, 5, 6]";
        Assertions.assertThat(lottoLine.toString()).isEqualTo(result);
    }
}