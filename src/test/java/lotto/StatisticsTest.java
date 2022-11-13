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

    @DisplayName("발행한 로또에 보너스 번호 존재 유무를 확인한다.")
    @Test
    void checkLottoNumbersContainBonusNumber() {
        // given
        Statistics statistics = new Statistics();

        // when
        String grade = statistics.checkLottoNumbersContainBonusNumber(List.of(1, 2, 3, 10, 22, 12), 3);

        // then
        assertThat(grade).isEqualTo("SECOND");
    }

    @DisplayName("발행한 로또의 등수를 확인한다.")
    @Test
    void checkLottoGrade() {
        // given
        Statistics statistics = new Statistics();

        // when
        String grade = statistics.checkLottoGrade(6);

        // then
        assertThat(grade).isEqualTo("FIRST");
    }
}
