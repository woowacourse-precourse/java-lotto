package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.LottoMachine;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest extends NsTest {

    @DisplayName("중복되지 않은 1~45 범위의 숫자 6개 생성")
    @Test
    void case1_pick_random_unique_numbers() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
            LottoMachine lottoMachine = LottoMachine.getInstance();
            assertThat(lottoMachine.extractRandomNumbers()).isEqualTo(result);
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Override
    protected void runMain() {
    }
}
