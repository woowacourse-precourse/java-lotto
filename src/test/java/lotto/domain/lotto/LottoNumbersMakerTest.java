package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

class LottoNumbersMakerTest {
    @Test
    void 랜덤_수_리스트를_만든다() {
        List<Integer> randomNumbers = LottoNumbersMaker.makeLottoNumbers();

        for (int i = 0; i < randomNumbers.size() - 1; i++) {
            int number1 = randomNumbers.get(i);
            int number2 = randomNumbers.get(i + 1);

            assertThat(number1).isNotEqualTo(number2);
        }
    }
}