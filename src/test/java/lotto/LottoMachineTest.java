package lotto;

import lotto.store.Lotto;
import lotto.store.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    LottoMachine lottoMachine = LottoMachine.getInstance();

    @DisplayName("중복되지 않은 1~45 범위의 숫자 6개 생성")
    @Test
    void pickRandomUniqueNumbers() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
            Method method = LottoMachine.class.getDeclaredMethod("extractRandomNumbers");
            method.setAccessible(true);

            assertThat(method.invoke(lottoMachine)).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("랜덤 숫자 6개 로또 객체로 바꾸기")
    @Test
    void convertNumbersToLotto() {
        try {
            Class<Lotto> result = Lotto.class;
            Method method = LottoMachine.class.getDeclaredMethod("convertLotto", List.class);
            method.setAccessible(true);

            assertThat(method.invoke(lottoMachine, List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(result);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("구입 금액이 천원 단위인 경우 금액에 맞게 로또 번호 뽑기")
    @Test
    void pickLotteries() {
        List<Lotto> input = lottoMachine.pickLotteries(5000);
        int result = 5;
        assertThat(input.size()).isEqualTo(result);
    }

    @DisplayName("구입 금액이 천원 단위가 아닌 경우 예외 발생")
    @Test
    void validateUnitException() {
        assertThatThrownBy(() -> lottoMachine.pickLotteries(5005))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
