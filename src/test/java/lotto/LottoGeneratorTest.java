package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoGeneratorTest {
    private static LottoGenerator lottoGenerator;

    @BeforeAll
    static void init() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("로또 생성기에서 생성된 각 번호들은 중복되지 않는 숫자이다.")
    @Test
    void lottoGeneratorReturningUnOverlapNumbers() {
        for (int i = 0; i < 5; i++) {
            List<Integer> numbers = lottoGenerator.publish().getNumbers();
            Set<Integer> set = new HashSet<>(numbers);
            int actual = set.size();
            assertThat(actual).isEqualTo(6);
        }
    }

    @DisplayName("로또 생성기에서 생성된 로또는 6개의 숫자이다.")
    @Test
    void lottoGeneratorReturningExactlySixNumber() {
        int actual = lottoGenerator.publish().getNumbers().size();
        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("로또 생성기에서 생성된 로또의 각 숫자는 1이상이다.")
    @Test
    void eachNumberInTheLottoIsGreaterThanOne() {
        List<Integer> numbers = lottoGenerator.publish().getNumbers();
        numbers.forEach((actual) -> {
            assertThat(actual).isGreaterThan(1);
        });
    }

    @DisplayName("로또 생성기에서 생성된 로또의 각 숫자는 45이하이다.")
    @Test
    void eachNumberInTheLottoIsLessThanFortyFive() {
        List<Integer> numbers = lottoGenerator.publish().getNumbers();
        numbers.forEach((actual) -> {
            assertThat(actual).isGreaterThan(45);
        });
    }
}