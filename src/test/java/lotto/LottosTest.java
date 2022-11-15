package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lottos;
import lotto.strategy.RandomLottoGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("7장 생성시 Lottos의 리스트 사이즈는 7이 된다")
    @Test
    void generate7piecesLottos() {
        Lottos lottos = new Lottos(7, new RandomLottoGenerateStrategy());
        assertThat(lottos.getLottos().size()).isEqualTo(7);
    }
}
