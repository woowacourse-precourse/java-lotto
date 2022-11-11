package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryDrawMachineTest {

    private LotteryDrawMachine lotteryDrawMachine;

    @BeforeEach
    void initialize() {
        lotteryDrawMachine = new LotteryDrawMachine();
    }

    @Test
    @DisplayName("로또 번호는 6개여야 합니다")
    void drawLotteryNumbers_size() {
        List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();

        assertThat(lotteryNumbers.size())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호는 1부터 45까지 범위여야 합니다")
    void drawLotteryNumbers_range() {
        List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();

        assertThat(lotteryNumbers.stream().allMatch(number -> number >= 1 && number <= 45))
                .isTrue();
    }

    @Test
    @DisplayName("로또 번호는 중복이 없어야 합니다")
    void drawLotteryNumbers_conflict() {
        List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();

        assertThat(lotteryNumbers)
                .doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("로또 번호는 오름차순이어야 합니다")
    void drawLotteryNumbers_sorted() {
        List<Integer> lotteryNumbers = lotteryDrawMachine.drawLotteryNumbers();

        assertThat(lotteryNumbers)
                .isSorted();
    }
}
