package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @DisplayName("구매 금액을 입력하면 구매 수량에 맞는 로또를 발행한다.")
    @ParameterizedTest(name = "{index} {displayName} priceInput : {0}")
    @ValueSource(ints = {5000, 50000, 100000, 909000, 1000, 2000, 3000})
    void 금액에_따라_로또_발행_수량_확인(int input) {
        assertThat(new Lottos(input).generateLottoNumbersByQuantity().size()).isEqualTo(input / 1000);
    }
}