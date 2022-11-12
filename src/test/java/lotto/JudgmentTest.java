package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

class JudgmentTest {
    private Judgment judgment;

    @BeforeEach
    void setUp() {
        judgment = new Judgment();
    }

    @Test
    void 같은_숫자_개수_찾기1() {
        int result = judgment.correctCount(Arrays.asList(1,2,3,4,5,6), Arrays.asList(7,8,9,10,11,12));
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 같은_숫자_개수_찾기2() {
        int result = judgment.correctCount(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1, 3, 5, 14, 22, 45));
        assertThat(result).isEqualTo(3);
    }

}