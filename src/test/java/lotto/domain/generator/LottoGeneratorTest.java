package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

        assertAll(
                () -> assertThat(generatedLottos.size()).isEqualTo(8),
                () -> assertThat(generatedLottos.getLotto(0).size()).isEqualTo(6)
        );
    }

    @Test
    @DisplayName("넣은 돈이 형식에 맞는지 확인하는 테스트")
    void REQUEST_TYPE_VALIDATION_CHECK() {
        MoneyRequest moneyRequest1 = new MoneyRequest(1);
        MoneyRequest moneyRequest2 = new MoneyRequest(1200);

        assertAll(
                () -> assertThatThrownBy(() -> new LottoGenerator(moneyRequest1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("최소 구매금액은 1000원 입니다."),
                () -> assertThatThrownBy(() -> new LottoGenerator(moneyRequest2))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1000원 단위로 입력해주세요.")
        );
    }
}