package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosGeneratorTest {
    @Test
    void 입력받은_개수만큼_로또를_생성한다() {
        LottosGenerator generator = new LottosGenerator(new RandomNumbersGenerationStrategy());

        Lottos lottos = generator.lottos(3);

        assertThat(lottos.count()).isEqualTo(3);
    }
}
