package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryMachineTest {


    @DisplayName("당첨 번호 저장 테스트")
    @Test
    void WinningLottoNum() {
        String inputWinningNum = "1,2,3,4,5,6";
        LotteryMachine lotteryMachine = new LotteryMachine();
        String[] splitWinningNum = inputWinningNum.split(",");
        lotteryMachine.makeWinningLottoNum(splitWinningNum);
        Assertions.assertThat(lotteryMachine.getLotto().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));

    }

}