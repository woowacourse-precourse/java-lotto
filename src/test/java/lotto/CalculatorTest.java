package lotto;

import lotto.domain.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto
 * fileName : CalculatorTest
 * author : gim-yeong-geun
 * date : 2022/11/10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/10         gim-yeong-geun          최초 생성
 */
public class CalculatorTest {
    @DisplayName("총 수익이 2,031,555,000원이 나온다")
    @Test
    void revenueTest(){
        int result = Calculator.revenue(1,1,1,1,1);
        assertThat(result).isEqualTo(2031555000);
    }

    @DisplayName("수익률이 181.8이 나온다")
    @Test
    void yieldTest(){
        double result = Calculator.yield(20000, 11000);
        assertThat(result).isEqualTo(181.8);
    }

}
