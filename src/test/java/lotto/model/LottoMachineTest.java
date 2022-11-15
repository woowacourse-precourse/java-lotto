package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static LottoMachine lottoMachine;

    @BeforeAll()
    static void init() {
        lottoMachine = new LottoMachine();
    }

    private static boolean isSortedByASC(List<Integer> ilist) {
        if (ilist == null && ilist.size() == 0) return true;
        int prev = -1;
        for (int num : ilist) {
            if (num < prev) return false;
            prev = num;
        }
        return true;
    }

    @DisplayName("주어진 가격으로 적절하게 로또를 발행하는 지 검증한다.")
    @ParameterizedTest(name = "로또 발행 테스트[{index}] -> 주어진 값이 {0}원이라면 로또를 {1}장 발행한다.")
    @CsvSource(value = {"20000:20", "10000:10", "1000:1", "2000:2", "12000:12", "12500:12"}, delimiter = ':')
    void lottoMachineProduceLottoProperly(int source, int expected) {
        int actual = lottoMachine.publish(source).size();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("로또 기계에서 생성된 각 번호들은 중복되지 않는 숫자이다.")
    @Test
    void lottoMachineReturningUnOverlapNumbers() {
        List<Lotto> lottos = lottoMachine.publish(10000);
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> set = new HashSet<>(numbers);
            int actual = set.size();
            assertThat(actual).isEqualTo(6);
        });
    }

    @DisplayName("로또 기계에서 생성된 로또는 6개의 숫자이다.")
    @Test
    void lottoMachineReturningExactlySixNumber() {
        List<Lotto> lottos = lottoMachine.publish(10000);
        lottos.forEach(lotto -> {
            int actual = lotto.getNumbers().size();
            assertThat(actual).isEqualTo(6);
        });
    }

    @DisplayName("로또 기계에서 생성된 로또의 각 숫자는 1이상이다.")
    @Test
    void eachNumberInTheLottoIsGreaterThanOne() {
        List<Lotto> lottos = lottoMachine.publish(10000);
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            numbers.forEach(actual -> {
                assertThat(actual).isGreaterThanOrEqualTo(1);
            });
        });
    }

    @DisplayName("로또 기계에서 생성된 로또의 각 숫자는 45이하이다.")
    @Test
    void eachNumberInTheLottoIsLessThanFortyFive() {
        List<Lotto> lottos = lottoMachine.publish(10000);
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            numbers.forEach(actual -> {
                assertThat(actual).isLessThanOrEqualTo(45);
            });
        });
    }

    @DisplayName("로또 기계에서 생성된 로또의 각 숫자는 오름차순으로 정렬되어 있다.")
    @Test
    void numbersInLottoAreSortedInAscendingOrder() {
        List<Lotto> lottos = lottoMachine.publish(10000);
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            boolean actual = isSortedByASC(numbers);
            assertThat(actual).isTrue();
        });
    }

    @DisplayName("당첨 번호가 6개의 숫자로 이루어지지 않는다면 예외를 발생한다.")
    @Test
    void notSixNumberThenReturningException() {
        assertThatThrownBy(() -> lottoMachine.setLuckyNumber(List.of(1, 2, 3, 4), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 6개의 숫자입니다.");
    }

    @DisplayName("보너스 번호가 1 미만이라면 예외를 발생한다.")
    @Test
    void bonusNumberIsLessThenOneReturningException() {
        assertThatThrownBy(() -> lottoMachine.setLuckyNumber(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호의 각 자리가 1 미만이라면 예외를 발생한다.")
    @Test
    void luckyNumberIsLessThenOneReturningException() {
        assertThatThrownBy(() -> lottoMachine.setLuckyNumber(List.of(1, 2, 3, -1, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 45 초과라면 예외를 발생한다.")
    @Test
    void bonusNumberIsGreaterThenFortyFiveReturningException() {
        assertThatThrownBy(() -> lottoMachine.setLuckyNumber(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호의 각 자리가 45 초과라면 예외를 발생한다.")
    @Test
    void luckyNumberIsGreaterThenFortyFiveReturningException() {
        assertThatThrownBy(() -> lottoMachine.setLuckyNumber(List.of(1, 2, 3, 46, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void containOverlapNumberBetweenBonusAndLuckyNumbersThenReturningException() {
        assertThatThrownBy(() -> lottoMachine.setLuckyNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 중복되지 않는 보너스 번호를 입력해주세요.");
    }

    @DisplayName("입력한 금액이 1000보다 작다면 로또를 발생할 수 없으므로 예외를 발생한다.")
    @Test
    void moneyLessThenOneThousandReturningException() {
        assertThatThrownBy(() -> lottoMachine.publish(-100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 금액으로는 복권을 구매할 수 없습니다.");
    }

    @DisplayName("입력한 당첨번호에 중복이 있다면 예외를 발생시킨다.")
    @Test
    void containOverlapNumberInLuckyNumbersThenReturningException() {
        assertThatThrownBy(() -> lottoMachine.setLuckyNumber(List.of(1, 1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또의 각 번호는 중복이 없어야 합니다.");
    }
}