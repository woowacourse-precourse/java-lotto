package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GeneratorTest {
    @DisplayName("중복되지 않는 숫자 리스트 생성 테스트")
    @Test
    void 여섯_개의_숫자리스트_생성_테스트() {
        assertThat(Generator.pickLottoNumbers().size())
                .isEqualTo(6);
    }

    @DisplayName("숫자 정렬 테스트")
    @Test
    void 숫자_정렬_테스트() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        assertThat(Generator.orderNumbers(numbers))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 10));
    }
}
