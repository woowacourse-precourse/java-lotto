package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoCalculatorTest {
    private static final List<Integer> WINNINGNUMBER = Arrays.asList(1,2,3,4,5,6);
    private static final int BONUSNUMBER = 7;
    private LottoCalculator lottoCalculator;

    @BeforeEach
    void setUp() {
        lottoCalculator = new LottoCalculator();
    }

    @ParameterizedTest
    @CsvSource({"1,2,13,14,15,7,-1", "1,2,3,14,15,7,0", "1,2,3,4,15,7,1", "1,2,3,4,5,16,2", "1,2,3,4,5,7,3", "1,2,3,4,5,6,4"})
    void 로또번호_당첨번호_비교_테스트(int number1, int number2, int number3, int number4, int number5, int number6, int expected) {
        int result = lottoCalculator.compare(Arrays.asList(number1, number2, number3, number4, number5, number6),
                WINNINGNUMBER, BONUSNUMBER);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void addRankCount() {
        int input = 1;
        int input2 = 4;
        lottoCalculator.addRankCount(input);
        lottoCalculator.addRankCount(input2);
        lottoCalculator.addRankCount(input2);

        assertThat(lottoCalculator.getRankCount()).isEqualTo(Arrays.asList(0, 1, 0, 0, 2));
    }

    @Test
    void sumOfPrizeMoney() {
        lottoCalculator.addRankCount(0);
        lottoCalculator.addRankCount(1);
        lottoCalculator.addRankCount(2);
        lottoCalculator.addRankCount(3);
        lottoCalculator.addRankCount(4);

        double expected = 2031555000;

        assertThat(lottoCalculator.sumOfPrizeMoney()).isEqualTo(expected);
    }
}