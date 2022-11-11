package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {
    @ParameterizedTest
    @ValueSource(ints = {1010, 1001, 1030, 2111})
    void 예외_올바르지_않은_단위(int money) {
        assertThatThrownBy(() -> new User(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성_올바른_로또() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lotto lotto = Lotto.generate();
                    List<Integer> numbers = lotto.getNumbers();
                    assertThat(numbers).isEqualTo(List.of(8, 21, 23, 41, 42, 43));
                },
                List.of(43, 42, 41, 23, 21, 8)
        );
    }
}
