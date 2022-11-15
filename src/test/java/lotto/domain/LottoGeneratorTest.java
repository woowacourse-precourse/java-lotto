package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 중복되지_않은_랜덤한_숫자_생성() {
        List<Integer> numbers = lottoGenerator.generateRandomNumbers();

        assertThat(numbers)
                .hasSize(6)
                .filteredOn(num -> num >= 1 && num <= 45)
                .hasSize(6)
                .doesNotHaveDuplicates();
    }

    @Test
    void 로또_리스트_생성() {
        List<Lotto> lottos = lottoGenerator.generateLottos(5);

        assertThat(lottos)
                .hasSize(5)
                .hasOnlyElementsOfType(Lotto.class);
    }
}