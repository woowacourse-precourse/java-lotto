package lotto.infra.lotto;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomsLottoGeneratorTest {


    @ParameterizedTest(name = "[{index}] 입력받은 수({argumentsWithNames}) 만큼의 로또를 생성한다.")
    @ValueSource(ints = {4, 10, 20, 1, 0})
    void createLottos(final int count) {
        // given
        RandomsLottoGenerator generator = new RandomsLottoGenerator();

        // when
        List<Lotto> lottos = generator.generateByCount(count);

        // then
        assertThat(lottos.size()).isEqualTo(count);
    }
}