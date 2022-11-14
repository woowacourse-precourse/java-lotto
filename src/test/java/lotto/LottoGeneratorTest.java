package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utils.LottoGenerator.generateLotto;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    @DisplayName("3개의 로또를 구입한다. 각각의 로또는 중복없이 6개의 숫자로 이루어져있다.")
    void generateLotto3() {
        // given
        int lottoCount = 3;

        // when
        List<Lotto> lottos = generateLotto(lottoCount);

        // then
        assertThat(lottos.size()).isEqualTo(lottoCount);
        lottos.forEach(lotto -> assertThat(lotto.getNumbers().stream().distinct().count()).isEqualTo(6));
    }
}