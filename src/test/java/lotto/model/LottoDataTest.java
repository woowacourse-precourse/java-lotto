package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDataTest {
    static LottoData lottoData;

    @BeforeAll
    static void initAll() {
        lottoData = new LottoData(12000);
    }

    @DisplayName("12000으로 LottoData 객체를 생성하면 lottoAmount 에 12가 저장된다.")
    @Test
    void constructorTest() {
        assertThat(lottoData.lottoAmount).isEqualTo(12);
    }

    @DisplayName("12000으로 LottoData 객체 생성 후 makeLotto 호출하면 allLotto 에 12개의 Lotto 객체가 담긴다.")
    @Test
    void makeLottoTest() {
        lottoData.makeLotto();
        assertThat(lottoData.allLotto.size()).isEqualTo(12);
    }
}