
package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Model.Money;
import lotto.io.Output;
import lotto.io.OutputScreen;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest2 extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력된 돈이 조건에 맞는지 확인 - 숫자인가.")
    @Test
    void checkMoneyException1() {
        assertSimpleTest(() -> {
            runException("12a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("120$");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력된 돈이 조건에 맞는지 확인 - 숫자인데 유효한가.")
    @Test
    void checkMoneyException2() {
        assertSimpleTest(() -> {
            runException("-12000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력된 돈이 조건에 맞는지 확인 - 앞뒤 공백에도 정상 수행되는가.")
    @Test
    void checkMoneyException3() {
        Output output = new OutputScreen();
        Money money1 = new Money("   12000");
        Assertions.assertThat(money1.getLottoCntForCalculate()).isEqualTo(12L);
        Money money2 = new Money("3000   ");
        Assertions.assertThat(money2.getLottoCntForCalculate()).isEqualTo(3L);
        Money money3 = new Money("    3000   ");
        Assertions.assertThat(money3.getLottoCntForCalculate()).isEqualTo(3L);
    }

    @DisplayName("입력된 돈이 조건에 맞는지 확인 - 0원 또는 매우 큰 금액에도 잘 수행하는가.")
    @Test
    void checkMoneyException4() {
        Money money1 = new Money("0");
        Money money2 = new Money("3000000000000000000");
    }

    @DisplayName("입력된 돈이 조건에 맞는지 확인 - 널이 들어올.")
    @Test
    void checkMoneyException5() {
        runException(null, "1,2,3,4,5,6");
        assertThat(output()).contains("[ERROR]");
//        Money money1 = new Money(null);
//        Money money2 = new Money("3000000000000000000");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
