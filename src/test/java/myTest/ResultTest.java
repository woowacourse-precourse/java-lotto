package myTest;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

public class ResultTest {
    private Calculator calculator;
    private Result result;
    @BeforeEach
    void init(){
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoAnswer lottoAnswer = new LottoAnswer("1,4,6,9,11,10","22");
        calculator = new Calculator();
        calculator.checkCount(userLotto, lottoAnswer);
        result = new Result(1000);
        result.checkRanks(calculator);
        result.calcResultMoney();
        result.calcEarningRate();
    }

    @DisplayName("결과 테스트")
    @Test
    void resultTest() {
        assertThat(result.getFifth()).isEqualTo(1);
    }

    @DisplayName("결과값 테스트")
    @Test
    void resultMoneyTest(){
        assertThat(result.getResultMoney()).isEqualTo(5000);
    }

    @DisplayName("수익률 테스트")
    @Test
    void earningRateTest() {
        assertThat(result.getEarningsRate()).isEqualTo(500.0);
    }
}
