package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDataTest {

    @DisplayName("12000으로 LottoData 객체를 생성하면 lottoAmount 에 12가 저장된다.")
    @Test
    void constructorTest() {
        LottoData lottoData = new LottoData(12000);
        assertThat(lottoData.lottoAmount).isEqualTo(12);
    }

}