package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LotteryDrawMachineTest {

    @Test
    @DisplayName("금액에 맞게 로또를 샀는가")
    public void numOfLottoTest() {
        User user = new User("8000");
        LotteryDrawMachine ldm = new LotteryDrawMachine();
        ldm.setUser(user);
        List<Lotto> lottos = ldm.generateLotto();
        assertThat(lottos.size()).isEqualTo(8);
    }
}