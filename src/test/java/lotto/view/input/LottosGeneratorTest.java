package lotto.view.input;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosGeneratorTest {

    @Nested
    @DisplayName("로또 그룹 생성 검증")
    class GenerateLottosTest{
        LottosGenerator generator = new LottosGenerator();

        @Test
        @DisplayName("지정 개수의 lotto 그룹을 만들어내는지 검증")
        void 지정_개수의_로또_그룹(){
            // given
            int size = 10;
            // when
            List<Lotto> lottos = generator.generateLottos(size);
            // then
            Assertions.assertThat(lottos.size()).isEqualTo(10);
        }

    }

}