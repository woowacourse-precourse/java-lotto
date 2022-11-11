package lotto.domain_test;

import lotto.domain.Profit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProfitTest {

    Profit profit;

    @BeforeEach
    void initializeClass(){
        profit = new Profit();
    }

    @Test
    @DisplayName("로또 구매비용과 당첨금을 입력하면 수익률을 퍼센트로 출력한다. ")
    void getProfit(){
        profit.checkPayment(10000);
        profit.addPrice(5000);
        assertThat(profit.getProfit()).isEqualTo("50.0");
    }
}
