package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @Test
    void 랜덤_숫자_생성_기능_검증_테스트() {
        List<Integer> numbers = LottoNumberGenerator.generate();
        for (Integer number : numbers) {
            assertThat(number)
                .isLessThanOrEqualTo(45)
                .isGreaterThanOrEqualTo(1);
        }
    }

    @Test
    void 랜덤_숫자_생성_크기_검증_테스트(){
        List<Integer> numbers = LottoNumberGenerator.generate();
        assertThat(numbers.size()).isEqualTo(6);
    }


}
