package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @DisplayName("LottoNumberGenerator가 1~45 범위의 중복되지 않은 숫자 6개를 생성하는지 검증한다.")
    @Test
    void generateNumbers() {
        List<Integer> result = LottoNumberGenerator.generate();

        for (int number : result) {
            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
        }
        assertThat(result).doesNotHaveDuplicates();
        assertThat(result).hasSize(6);
    }
}