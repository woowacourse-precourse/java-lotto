package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryDrawMachineTest {

    private LotteryDrawMachine lotteryDrawMachine;

    @BeforeEach
    void initialize() {
        lotteryDrawMachine = new LotteryDrawMachine();
    }

    @Test
    void 로또_번호는_6개여야_합니다() {
        List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();

        assertThat(lotteryNumbers.size())
                .isEqualTo(6);
    }

    @Test
    void 로또_번호는_1부터_45까지_범위여야_합니다() {
        List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();

        assertThat(lotteryNumbers.stream().allMatch(number -> number >= 1 && number <= 45))
                .isTrue();
    }

    @Test
    void 로또_번호는_중복이_없어야_합니다() {
        List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();

        assertThat(lotteryNumbers)
                .doesNotHaveDuplicates();
    }

    @Test
    void 로또_번호는_오름차순이어야_합니다() {
        List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();

        assertThat(lotteryNumbers)
                .isSorted();
    }
}
