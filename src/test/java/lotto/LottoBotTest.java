package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoBotTest {
    LottoBot lottoBot = new LottoBot();

    @Test
    @DisplayName("랜덤한 수의 범위가 1 ~ 45 인지 확인")
    void checkRandomNumbersRangeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> randomNumbers = getRandomNumbers();
        Assertions.assertThat(isValidRange(randomNumbers)).isEqualTo(true);
    }

    private boolean isValidRange(List<Integer> randomNumbers) {
        for (int number : randomNumbers) {
            if (number < Lotto.MIN_LOTTO_NUMBER || Lotto.MAX_LOTTO_NUMBER < number) {
                return false;
            }
        }
        return true;
    }

    @Test
    @DisplayName("랜덤한 수 중 중복이 있는지 확인")
    void duplicateRandomNumbersTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> randomNumbers = getRandomNumbers();
        Assertions.assertThat(isDuplicated(randomNumbers)).isEqualTo(true);
    }

    private List<Integer> getRandomNumbers() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getRandomNumbersMethod = lottoBot.getClass().getDeclaredMethod("createRandomNumbers");
        getRandomNumbersMethod.setAccessible(true);
        return (List<Integer>) getRandomNumbersMethod.invoke(lottoBot);
    }

    private static boolean isDuplicated(List<Integer> randomNumbers) {
        Set<Integer> storedNumbers = new HashSet<>();
        for (int number : randomNumbers) {
            if (storedNumbers.contains(number)) {
                return false;
            }
            storedNumbers.add(number);
        }

        return true;
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateYieldTest() {
        lottoBot.saveInitialMoney(1000);
        List<Integer> ranks = new ArrayList<>(List.of(0, 0, 0, 0, 1));
        Assertions.assertThat(lottoBot.calculateYield(ranks)).isEqualTo(500f);
    }

    @Test
    @DisplayName("보너스 숫자가 당첨번호와 안 겹치는지 확인하는 테스트")
    void checkNotDuplicatedBonusNumber() {
        lottoBot.saveWinningNumbers(new ArrayList<>(List.of("1","2","3","4","5","6")));
        Assertions.assertThat(lottoBot.isValidBonusNumber("7")).isEqualTo(true);
    }

    @Test
    @DisplayName("보너스 숫자가 당첨번호와 겹치는지 확인하는 테스트")
    void checkDuplicatedBonusNumber() {
        lottoBot.saveWinningNumbers(new ArrayList<>(List.of("1","2","3","4","5","6")));
        Assertions.assertThat(lottoBot.isValidBonusNumber("1")).isEqualTo(false);
    }
}