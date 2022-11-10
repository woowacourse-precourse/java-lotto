package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {
    @DisplayName("로또 당첨 번호와 보너스 번호가 같은 경우 예외가 발생한다.")
    @Test
    void winningNumberAndBonusNumberCannotBeSame(){
        Lotto lotto=new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        assertThatThrownBy(() -> new LotteryMachine(lotto,6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스번호는 6개의 로또 번호와 다른 숫자여야 합니다.");

    }
}