package lotto.domain;

import lotto.domain.impl.JudgmentImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class JudgmentTest {

    private final Judgment judgment = new JudgmentImpl();

    @Test
    @DisplayName("사용자의 번호와 당첨 번호가 모두 일치하면 6이다.")
    void correctCount() {
        int count = judgment.correctCount(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(count).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 번호가 일치하면 참이다.")
    void hasBonusNumberTrue() {
        boolean hasBonusNumber = judgment.hasBonusNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 7);

        assertThat(hasBonusNumber).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 일치하지 않으면 거짓이다.")
    void hasBonusNumberFalse() {
        boolean hasBonusNumber = judgment.hasBonusNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        assertThat(hasBonusNumber).isFalse();
    }
}