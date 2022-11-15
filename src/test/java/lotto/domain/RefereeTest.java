package lotto.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class RefereeTest {
    @DisplayName("당첨 번호, 보너스 번호와 비교하여 등수를 올바르게 판별한다.")
    @Test
    void calculateGrades() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,6,8)),
                new Lotto(List.of(1,2,3,4,5,8))
        );
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,8,12));
        Referee referee = new Referee(lottos, winningNumbers, 6);
        assertThat(referee.calculateGrades()).containsExactly(Grade.SECOND,Grade.THIRD);
    }
}
