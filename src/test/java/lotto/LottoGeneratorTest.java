package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.strategy.RandomLottoGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("multipleLotto의 사이즈가 countOfLotto와 같아야한다.")
    @Test
    void createMultipleLottoByRandomLottoGenerator() {
        LottoGenerator lottoGenerator = LottoGenerator.from(new RandomLottoGenerateStrategy());
        int countOfLotto = 5;
        List<Lotto> multipleLotto = lottoGenerator.generateMultipleLotto(countOfLotto);
        assertThat(multipleLotto.size()).isEqualTo(countOfLotto);
    }
}
