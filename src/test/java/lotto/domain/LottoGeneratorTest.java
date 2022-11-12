package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();
    @DisplayName("1 ~ 45 로또 번호를 생성한다.")
    @Test
    void 로또_번호_생성() {
        List<Integer> numbers = lottoGenerator.createLotto();
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLotto()).isEqualTo(numbers);
    }
}
