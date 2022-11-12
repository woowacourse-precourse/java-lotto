package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {

    @DisplayName("로또 번호가 몇개 당첨됬는지 확인한다.")
    @Test
    void correctNumbers() {
        Judgement judgement = new Judgement();
        int result = judgement.correctNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6));
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("보너스번호가 당첨되는지 확인한다.")
    @Test
    void correctBonus() {
        Judgement judgement = new Judgement();
        int result = judgement.correctBonus(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(result).isEqualTo(0);
    }
}