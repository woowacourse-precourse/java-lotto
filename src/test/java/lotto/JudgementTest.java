package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JudgementTest {
    @Test
    void 같은_숫자_세기_테스트() {
        Judgement judgement = new Judgement();
        int input = judgement.correctCount(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(7, 2, 3, 4, 5, 6));

        assertThat(input).isEqualTo(5);
    }

    @Test
    void 보너스_숫자_포함_테스트() {
        Judgement judgement = new Judgement();
        boolean falseInput = judgement.hasBonusNumbers(13, Arrays.asList(1, 14, 15, 22, 33, 34));
        boolean trueInput = judgement.hasBonusNumbers(14, Arrays.asList(1, 14, 15, 22, 33, 34));

        assertThat(falseInput).isEqualTo(false);
        assertThat(trueInput).isEqualTo(true);
    }
}