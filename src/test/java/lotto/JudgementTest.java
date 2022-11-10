package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class JudgementTest {
    @Test
    void 같은_숫자_세기_테스트() {
        Judgement judgement = new Judgement();
        int input = judgement.correctCount(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(7, 2, 3, 4, 5, 6));

        assertThat(input).isEqualTo(5);
    }
}