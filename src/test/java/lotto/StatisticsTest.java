package lotto;

import lotto.domian.lotto.Lotto;
import lotto.domian.statistics.Statistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StatisticsTest {
    @DisplayName("발행한 로또에서 당첨 번호의 수를 센 후 개수를 출력한다.")
    @Test
    void countCorrectNumbers() {
        // given
        Statistics statistics = new Statistics();

        // when
        int count = statistics.countCorrectNumbers(List.of(1, 2, 3, 10, 22, 12), List.of(1, 2, 3, 4, 5, 6));

        // then
        assertThat(count).isEqualTo(3);
    }
}
