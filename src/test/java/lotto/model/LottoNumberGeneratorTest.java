package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberGeneratorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000"})
    void 로또는_구입_금액에_해당하는_만큼_발행된다(String inputMoney) {
        Money money = new Money(inputMoney);
        LottoCount lottoCount = new LottoCount(money);

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Lottos lottos = lottoNumberGenerator.generateLottos(money);

        assertThat(lottos.getLottos()).hasSize(lottoCount.getLottoCount());
    }
}