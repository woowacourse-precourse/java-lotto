package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMakerTest {

    @DisplayName("올바른 개수의 로또를 발행하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7, 8})
    void getLotto(int input) {
        LottoMaker lottoMaker = new LottoMaker();
        List<Lotto> lottos = lottoMaker.getLottos(input);

        assertThat(lottos.size()).isEqualTo(input);
    }
}
