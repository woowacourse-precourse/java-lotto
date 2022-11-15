package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {
    @DisplayName("로또 번호가 제대로 생성되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByLottoGenerator() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto;

        // when
        List<Integer> numbers = lottoGenerator.createLotto();
        lotto = new Lotto(numbers);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }
}
