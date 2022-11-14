package lotto;

import lotto.domain.Money;
import lotto.domain.Rank;
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
        Money cal=new Money("8000");
        cal.sumWinningMoney(Rank.THIRD);
        cal.sumWinningMoney(Rank.FIFTH);
        assertThat(cal.getWinningMoney()==1550000);
    }
    @DisplayName("반올림 테스트")
    @Test
    void profitRate_test(){
        Money cal=new Money("8000");
        int[] result=new int[6];
        result[3]=1;
        cal.sumWinningMoney(Rank.THIRD);
        result[5]=1;
        cal.sumWinningMoney(Rank.FIFTH);
       double profitrate= cal.profitRate();
       cal.printProfitRate();
       assertThat(profitrate==193.8);
    }

}