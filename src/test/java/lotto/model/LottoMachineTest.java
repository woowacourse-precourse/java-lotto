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
    @CsvSource(value = {"20000:20", "10000:10", "1000:1", "2000:2", "500:0", "0:0", "12000:12", "12500:12"}, delimiter = ':')
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
}
