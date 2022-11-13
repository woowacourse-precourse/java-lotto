package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class calculatorMoneyTest {
    @DisplayName("당첨금액합산 테스트")
    @Test
    void sumWinning_test(){
        int[] result=new int[6];
        result[3]=1;
        result[5]=1;
        CalculatorMoney cal=new CalculatorMoney("8000");
        cal.sumWinningMoney(result);
        assertThat(cal.getWinningMoney()==1550000);
    }
    @DisplayName("반올림 테스트")
    @Test
    void profitRate_test(){
        int[] result=new int[6];
        result[3]=1;
        result[5]=1;
        CalculatorMoney cal=new CalculatorMoney("8000");
        cal.sumWinningMoney(result);
       double profitrate= cal.profitRate();
       cal.printProfitRate();
       assertThat(profitrate==193.8);
    }

}