package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
class calculatorMoneyTest {
    @DisplayName("당첨금액합산 테스트")
    @Test
    void sumWinning_test(){
        int[] result=new int[6];
        result[3]=1;
        result[5]=1;
        calculatorMoney cal=new calculatorMoney("8000",result);
        cal.sumWinningMoney();
        assertThat(cal.getWinningMoney()==1550000);
    }
    @DisplayName("반올림 테스트")
    @Test
    void profitRate_test(){
        int[] result=new int[6];
        result[3]=1;
        result[5]=1;
        calculatorMoney cal=new calculatorMoney("8000",result);
        cal.sumWinningMoney();
       double profitrate= cal.profitRate();
       cal.printProfitRate();
       assertThat(profitrate==193.8);
    }

}