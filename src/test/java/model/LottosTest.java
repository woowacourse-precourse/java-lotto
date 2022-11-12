package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    @ParameterizedTest(name = "{index}  {0}원 입력 시 {1}개 생성")
    @CsvSource(value = {"1000:1", "20000:20", "345000:345"}, delimiter = ':')
    void 구입_금액에_해당하는_로또_번호_생성(int money, int count) {
        Lottos lottos = new Lottos(new Money(money));
        assertEquals(lottos.getLottos().size(), count);
    }
}