package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    @ParameterizedTest(name = "{index}  money = {0} {1}")
    @CsvSource(value = {"1000:1", "20000:20", "345000:345"}, delimiter = ':')
    void 구입_금액에_해당하는_로또_개수를_계산한다(int money, int count) {
        model.Lottos lottos = new model.Lottos(new Money(money));
        assertEquals(lottos.getCount(), count);
    }
}