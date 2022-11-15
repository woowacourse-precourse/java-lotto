package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @Test
    void 메인넘버_예외_테스트() {
        List<Integer> rawNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(45, 50, 6));
        assertThatThrownBy(() -> new WinningNumber(rawNumbers, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid Input");
        ;
    }

    @Test
    void 보너스넘버_예외_테스트() {
        assertThatThrownBy(() -> new WinningNumber(Randoms.pickUniqueNumbersInRange(1, 44, 6), 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid Input");
        ;
    }

}