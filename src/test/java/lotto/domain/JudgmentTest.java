package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgmentTest {
    Judgment judgment;
    Lotto lotto;

    @BeforeEach
    void setting() {
        judgment = new Judgment(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 10));
    }

    @Test
    @DisplayName("당첨숫자의 개수의 정확성을 테스트한다.")
    void 당첨숫자_카운트_정확성_테스트() {
        assertThat(judgment.countCorrect(lotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 숫자의 일치 여부의 정확성을 테스트한다.")
    void 보너스_숫자_일치_체크_정확성_테스트() {
        assertThat(judgment.checkBonus(lotto)).isEqualTo(true);
    }
}
