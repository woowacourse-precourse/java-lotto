package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void 랜덤한_숫자_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> numbers = lottoGenerator.generateRandomNumbers();

        assertThat(numbers)
                .hasSize(6)
                .filteredOn(num -> num >= 1 && num <= 45)
                .hasSize(6)
                .doesNotHaveDuplicates();
    }
}