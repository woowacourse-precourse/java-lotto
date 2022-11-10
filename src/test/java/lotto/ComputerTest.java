package lotto;

import computer.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private final Computer computer;

    public ComputerTest() {
        this.computer = new Computer();
    }

    @DisplayName("범위내의 중복없는 6개의 숫자를 발급하는데 성공한다.")
    @Test
    void 범위내의_중복없는_6개의_숫자를_발급한다() {
        // given

        // when
        computer.generateLotteryNumbers();

        // then
        List<Integer> lotteryNumbers = computer.getLotteryNumbers();

        assertThat(lotteryNumbers).hasSize(6);
        assertThat(lotteryNumbers.stream().collect(Collectors.toSet())).hasSize(6);
    }

}