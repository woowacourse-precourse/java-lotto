package yieldMachine;

import User.User;
import YieldMachine.YieldMachine;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.WinningNumberLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class YieldMachineTest extends NsTest {

    @DisplayName("입력된 숫자가 1000 단위가 아닌 경우에는 false가 반환된다.")
    @Test
    void findCountOfSameNumberWithWinningNumber() {
        assertSimpleTest(() ->
                {
                    run("1,2,3,4,5,6", "1");
                }
        );
    }


    @Override
    public void runMain() {
        YieldMachine yieldMachine = new YieldMachine();
    }
}
