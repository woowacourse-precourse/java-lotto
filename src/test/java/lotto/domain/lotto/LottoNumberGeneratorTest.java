package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @DisplayName("랜덤으로 생성된 로또의 번호는 항상 45보다 작거나 1보다 크다.")
    @Test
    void 랜덤_숫자_생성_범위_검증_테스트() {
        List<Integer> numbers = LottoNumberGenerator.generate();
        for (Integer number : numbers) {
            assertThat(number)
                .isLessThanOrEqualTo(45)
                .isGreaterThanOrEqualTo(1);
        }
    }

    @DisplayName("랜덤으로 생성된 로또의 번호 갯수는 항상 6이다.")
    @Test
    void 랜덤_숫자_생성_크기_검증_테스트(){
        List<Integer> numbers = LottoNumberGenerator.generate();
        assertThat(numbers.size()).isEqualTo(6);
    }

}
