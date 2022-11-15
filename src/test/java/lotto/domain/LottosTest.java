package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @DisplayName("구매 금액을 입력하면 구매 수량에 맞는 로또를 발행한다.")
    @ParameterizedTest(name = "{index} {displayName} priceInput : {0}")
    @ValueSource(ints = {5000, 50000, 100000, 909000, 1000, 2000, 3000})
    void 금액에_따라_로또_발행_수량_확인(int input) {
        assertThat(new Lottos(input).generateLottoNumbersByQuantity().size()).isEqualTo(input / 1000);
    }

    @DisplayName("당첨숫자와 보너스숫자를 이용해 사용자 입력 로또와 비교하여 올바른 순위 리스트를 만든다.")
    @Test
    void 올바른_순위_리스트() {
        Lotto winningLotto = new Lotto(List.of(9, 13, 25, 31, 36, 45));

        Lotto userLotto1 = new Lotto(List.of(9, 11, 13, 31, 37, 40));
        Lotto userLotto2 = new Lotto(List.of(1, 13, 25, 31, 36, 45));
        Lotto userLotto3 = new Lotto(List.of(9, 13, 25, 31, 36, 45));

        Lottos lottos = new Lottos(List.of(userLotto1, userLotto2, userLotto3));

        List<Ranking> result = List.of(Ranking.FIFTH, Ranking.THIRD, Ranking.FIRST);
        assertThat(lottos.compareLotto(winningLotto, 24)).isEqualTo(result);
    }
}
