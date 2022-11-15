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
    void 등수_더하기_테스트() {
        int input = 1;
        int input2 = 4;
        lottoCalculator.addRankCount(input);
        lottoCalculator.addRankCount(input2);
        lottoCalculator.addRankCount(input2);
        List<Integer> expected = lottoCalculator.getRankCount();

        assertThat(expected).isEqualTo(Arrays.asList(0, 1, 0, 0, 2));
    }

    @ParameterizedTest
    @CsvSource({"0,5000", "1,50000", "2,1500000", "3,30000000", "4,2000000000"})
    void 상금_합산_테스트(int rank, double money) {
        lottoCalculator.addRankCount(rank);

        assertThat(lottoCalculator.sumOfPrizeMoney()).isEqualTo(money);
    }
}