package yieldMachine;

import YieldMachine.YieldMachine;
import lotto.BoughtLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> MatchingNumber = (List<Integer>) findCountMethod.invoke(yieldMachine, lotto);
        assertThat(MatchingNumber).isEqualTo(List.of(6, 0));
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
        List<Integer> MatchingNumber = (List<Integer>) findCountMethod.invoke(yieldMachine, lotto);
        assertThat(MatchingNumber).isEqualTo(List.of(5, 1));
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
        List<Integer> MatchingNumber = (List<Integer>) findCountMethod.invoke(yieldMachine, lotto);
        assertThat(MatchingNumber).isEqualTo(List.of(2, 0));
    }

    @DisplayName("로또 등수에 따른 리스트 값 확인 - 4등")
    @Test
    void calculateOneLottoReward_Fourth()
            throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        YieldMachine yieldMachine = new YieldMachine(List.of(1, 2, 3, 4, 7, 8), 11);
        BoughtLotto lotto = new BoughtLotto(List.of(1, 2, 3, 4, 5, 11));
        Method calculateOneLottoRewardMethod
                = YieldMachine.class.getDeclaredMethod("calculateOneLottoReward", BoughtLotto.class);
        calculateOneLottoRewardMethod.setAccessible(true);
        calculateOneLottoRewardMethod.invoke(yieldMachine, lotto);
        List<Integer> countOfReward = yieldMachine.getCountOfRewards();
        assertThat(countOfReward).isEqualTo(List.of(0, 1, 0, 0, 0));
    }

    @DisplayName("로또 등수에 따른 리스트 값 확인 - 0등")
    @Test
    void calculateOneLottoReward_noPrize()
            throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        YieldMachine yieldMachine = new YieldMachine(List.of(1, 2, 3, 4, 7, 8), 11);
        BoughtLotto lotto = new BoughtLotto(List.of(1, 2, 9, 10, 11, 13));
        Method calculateOneLottoRewardMethod
                = YieldMachine.class.getDeclaredMethod("calculateOneLottoReward", BoughtLotto.class);
        calculateOneLottoRewardMethod.setAccessible(true);
        calculateOneLottoRewardMethod.invoke(yieldMachine, lotto);
        List<Integer> countOfReward = yieldMachine.getCountOfRewards();
        assertThat(countOfReward).isEqualTo(List.of(0, 0, 0, 0, 0));
    }

    @DisplayName("로또 등수에 따른 리스트 값 확인 - 2등")
    @Test
    void calculateOneLottoReward_second()
            throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        YieldMachine yieldMachine = new YieldMachine(List.of(1, 2, 3, 4, 7, 8), 11);
        BoughtLotto lotto = new BoughtLotto(List.of(1, 2, 3, 4, 7, 11));
        Method calculateOneLottoRewardMethod
                = YieldMachine.class.getDeclaredMethod("calculateOneLottoReward", BoughtLotto.class);
        calculateOneLottoRewardMethod.setAccessible(true);
        calculateOneLottoRewardMethod.invoke(yieldMachine, lotto);
        List<Integer> countOfReward = yieldMachine.getCountOfRewards();
        assertThat(countOfReward).isEqualTo(List.of(0, 0, 0, 1, 0));
    }

    @DisplayName("여러 로또의 맞은 개수 확인")
    @Test
    void calculateAllLottoReward()
            throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        YieldMachine yieldMachine = new YieldMachine(List.of(1, 2, 3, 4, 7, 8), 11);
        Method calculateAllLottoRewardMethod
                = YieldMachine.class.getDeclaredMethod("calculateAllLottoReward", List.class);
        calculateAllLottoRewardMethod.setAccessible(true);

        List<BoughtLotto> lottos = new ArrayList<>();
        lottos.add(new BoughtLotto(List.of(1, 2, 3, 4, 7, 11)));
        lottos.add(new BoughtLotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new BoughtLotto(List.of(7, 8, 9, 10, 11, 12)));
        lottos.add(new BoughtLotto(List.of(1, 3, 7, 11, 20, 35)));

        calculateAllLottoRewardMethod.invoke(yieldMachine, lottos);
        List<Integer> countOfReward = yieldMachine.getCountOfRewards();
        assertThat(countOfReward).isEqualTo(List.of(1, 1, 0, 1, 0));
    }
}
