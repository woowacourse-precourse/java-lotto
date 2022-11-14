package yieldMachine;

import User.User;
import YieldMachine.YieldMachine;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.BoughtLotto;
import lotto.WinningNumberLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class YieldMachineTest {

    @DisplayName("당첨번호 로또와 내가 구매한 로또 번호를 비교해 일치된 횟수를 반환한다. 1등")
    @Test
    void findCountOfSameNumberWithWinningNumber_1등()
            throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        YieldMachine yieldMachine = new YieldMachine(List.of(1, 2, 3, 4, 5, 6), 7);
        BoughtLotto lotto = new BoughtLotto(List.of(1, 2, 3, 4, 5, 6));
        Method findCountMethod
                = YieldMachine.class.getDeclaredMethod("findCountOfSameNumberWithWinningNumber", BoughtLotto.class);
        findCountMethod.setAccessible(true);
        List<Integer> isValidate = (List<Integer>) findCountMethod.invoke(yieldMachine, lotto);
        assertThat(isValidate).isEqualTo(List.of(6, 0));
    }

    @DisplayName("당첨번호 로또와 내가 구매한 로또 번호를 비교해 일치된 횟수를 반환한다. 2등")
    @Test
    void findCountOfSameNumberWithWinningNumber_2등()
            throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        YieldMachine yieldMachine = new YieldMachine(List.of(1, 2, 3, 4, 5, 6), 7);
        BoughtLotto lotto = new BoughtLotto(List.of(1, 2, 3, 4, 5, 7));
        Method findCountMethod
                = YieldMachine.class.getDeclaredMethod("findCountOfSameNumberWithWinningNumber", BoughtLotto.class);
        findCountMethod.setAccessible(true);
        List<Integer> isValidate = (List<Integer>) findCountMethod.invoke(yieldMachine, lotto);
        assertThat(isValidate).isEqualTo(List.of(5, 1));
    }

    @DisplayName("당첨번호 로또와 내가 구매한 로또 번호를 비교해 일치된 횟수를 반환한다. 2개 일치")
    @Test
    void findCountOfSameNumberWithWinningNumber_noPrize()
            throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        YieldMachine yieldMachine = new YieldMachine(List.of(4, 5, 6, 7, 8, 9), 11);
        BoughtLotto lotto = new BoughtLotto(List.of(1, 2, 3, 4, 5, 11));
        Method findCountMethod
                = YieldMachine.class.getDeclaredMethod("findCountOfSameNumberWithWinningNumber", BoughtLotto.class);
        findCountMethod.setAccessible(true);
        List<Integer> isValidate = (List<Integer>) findCountMethod.invoke(yieldMachine, lotto);
        assertThat(isValidate).isEqualTo(List.of(2, 1));
    }
}
