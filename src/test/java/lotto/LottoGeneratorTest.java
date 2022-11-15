package lotto;

import lotto.domian.lotto.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @DisplayName("매개변수 크기만큼의 로또를 생성하지 않았으면 예외가 발생한다.")
    @Test
    void getLottsCount() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();

        // when
        int lottosSize = lottoGenerator.generateLotto(3).size();

        // then
        assertThat(lottosSize).isEqualTo(3);
    }
}
