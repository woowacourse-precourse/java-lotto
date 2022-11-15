package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JudgementTest {
    private static final List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    private Judgement judgement;

    @BeforeEach
    void SetUp() {
        judgement = new Judgement();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,6", "1,7,8,9,10,11,1", "2,3,4,8,9,10,3", "3,4,5,6,10,11,4"})
    public void rankLotto(int num1, int num2, int num3, int num4, int num5, int num6, int expected) {
        int actual = judgement.rankLotto(Arrays.asList(num1, num2, num3, num4, num5, num6), winningNumber);
        assertThat(actual).isEqualTo(expected);
    }

}
