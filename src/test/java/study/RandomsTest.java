package study;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConfig;
import lotto.message.ExceptionMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class RandomsTest {

    private static List<Integer> numbers;

    @BeforeAll
    static void setUp() {
        numbers = Randoms.pickUniqueNumbersInRange(
                LottoConfig.RANGE_MIN, LottoConfig.RANGE_MAX, LottoConfig.NUMBER_COUNT);
    }

    @DisplayName("LOTTO_NUMBER_COUNT개 만큼 번호를 생성한다.")
    @Test
    void pickUniqueNumbersInRange_크기_확인() {
        assertThat(numbers.size()).isEqualTo(LottoConfig.NUMBER_COUNT);
    }

    @DisplayName("MIN 이상 MAX 이하의 수를 뽑는지 확인한다.")
    @Test
    void pickUniqueNumbersInRange_범위_확인() {
        try {
            checkRange();
        } catch (IllegalArgumentException e) {
            fail("범위를 벗어남");
        }
    }

    private void checkRange() {
        for (int number : numbers) {
            if (number > LottoConfig.RANGE_MAX || number < LottoConfig.RANGE_MIN) {
                throw new IllegalArgumentException(ExceptionMessage.ERROR_RANGE);
            }
        }
    }
}
