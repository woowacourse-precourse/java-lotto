package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberGeneratorTest {

    @DisplayName("6개의 숫자를 생성하는지 검증한다.")
    @Test
    void checkLottoNumberCount() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        // when
        List<Integer> numbers = lottoNumberGenerator.generate();

        // then
        assertThat(numbers).hasSize(6);
    }
}
