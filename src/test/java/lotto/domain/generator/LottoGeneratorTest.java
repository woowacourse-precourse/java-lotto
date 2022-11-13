package lotto.domain.generator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.model.Lottos;
import lotto.domain.model.request.MoneyRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성이 조건대로 잘 이루어지는지 확인")
    void GENERATED_ROTTOS_CHECK() {
        MoneyRequest moneyRequest = new MoneyRequest(8000);
        LottoGenerator lottoGenerator = new LottoGenerator(moneyRequest);
        Lottos generatedLottos = lottoGenerator.getLottos();

        assertThat(generatedLottos.size()).isEqualTo(8);
    }
}