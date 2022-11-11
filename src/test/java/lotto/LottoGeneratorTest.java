package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private static LottoGenerator lottoGenerator;

    @BeforeAll
    static void init() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("로또의 각 번호들은 중복되지 않는 숫자이다.")
    @Test
    void lottoGeneratorReturningUnOverlapNumbers() {
    }

    @DisplayName("로또는 6자리의 숫자이다.")
    @Test
    void lottoGeneratorReturningExactlySixNumber() {
    }

    @DisplayName("로또의 각 숫자의 범위는 1보다 크다.")
    @Test
    void eachNumberInTheLottoIsGreaterThanOne() {
    }

    @DisplayName("로또의 각 숫자의 범위는 45보다 작다.")
    @Test
    void eachNumberInTheLottoIsLessThanFortyFive() {
    }
}