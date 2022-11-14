package myTest;

import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void init(){
        calculator = new Calculator();
    }

    @DisplayName("Count 체크")
    @Test
    void checkCountTest(){
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoAnswer lottoAnswer = new LottoAnswer("1,4,6,9,11,10","22");
        calculator.checkCount(userLotto, lottoAnswer);
        assertThat(calculator.getAnswerCount()).isEqualTo(3);
        assertThat(calculator.isBonus()).isFalse();
    }
}
