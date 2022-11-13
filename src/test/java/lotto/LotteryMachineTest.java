package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("당첨 번호가 유의미한 숫자(1~45)가 아닐시 에러 발생")
    @Test
    void createWinningLottoNumByNotCorrectNum() {
        String inputWinningNum = "1,2,3,4,5,0";
        LotteryMachine lotteryMachine = new LotteryMachine();
        String[] splitWinningNum = inputWinningNum.split(",");
        assertThatThrownBy(() -> lotteryMachine.makeWinningLottoNum(splitWinningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복 숫자가 있을 때 에러 발생")
    @Test
    void createWinningLottoNumByDuplicatedNum() {
        String inputWinningNum = "1,2,3,4,5,5";
        LotteryMachine lotteryMachine = new LotteryMachine();
        String[] splitWinningNum = inputWinningNum.split(",");
        assertThatThrownBy(() -> lotteryMachine.makeWinningLottoNum(splitWinningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복 있을 때 에러 발생")
    @Test
    void createBonusNumByDuplicatedNum() {
        String inputWinningNum = "1,2,3,4,5,6";
        LotteryMachine lotteryMachine = new LotteryMachine();
        String[] splitWinningNum = inputWinningNum.split(",");
        lotteryMachine.makeWinningLottoNum(splitWinningNum);


        assertThatThrownBy(() -> lotteryMachine.makeBonusNum(lotteryMachine.getLotto().getNumbers(),"6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 유의미한 숫자(1~45)가 아닐시 에러 발생")
    @Test
    void createBonusNumByNotCorrectNum() {
        String inputWinningNum = "1,2,3,4,5,6";
        LotteryMachine lotteryMachine = new LotteryMachine();
        String[] splitWinningNum = inputWinningNum.split(",");
        lotteryMachine.makeWinningLottoNum(splitWinningNum);


        assertThatThrownBy(() -> lotteryMachine.makeBonusNum(lotteryMachine.getLotto().getNumbers(),"0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}