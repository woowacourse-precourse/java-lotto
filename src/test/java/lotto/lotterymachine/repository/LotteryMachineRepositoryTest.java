package lotto.lotterymachine.repository;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.lotterymachine.domain.LotteryMachine;
import org.junit.jupiter.api.Test;

class LotteryMachineRepositoryTest {

    @Test
    void 당첨_번호들_입력_확인() {

        LotteryMachineRepository lotteryMachineRepository = new LotteryMachineRepository();

        String userInput  = "1,2,3,4,5,76" ;
        boolean target = lotteryMachineRepository.checkInputOnlyNumbers(userInput);

        assertThat(target).isEqualTo(false);
    }

    @Test
    void 보너스_번호_입력_범위오류() {

        LotteryMachineRepository lotteryMachineRepository = new LotteryMachineRepository();

        String userInput  = "76" ;
        boolean target = lotteryMachineRepository.checkInputOnlyNumber(userInput);

        assertThat(target).isEqualTo(false);
    }

    // add case of input bonus number is duplicate
    // add case of input numbers is duplicate
}