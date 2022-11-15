package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @DisplayName("컴퓨터가 랜덤으로 6자리 수를 발생하는지 테스트")
    @Test
    void createLottoNumbers() {
        List<Integer> result = computer.createLottoNumbers();
        assertThat(result.size()).isEqualTo(6);
    }

    @DisplayName("money를 1000으로 나눈 몫 만큼 lotto를 생성하는지 테스트")
    @Test
    void createLottos() {
        List<List<Integer>> result = computer.createLottos(5000);
        assertThat(result.size()).isEqualTo(5);
    }

    @DisplayName("money를 1000으로 나눈 몫 만큼 반환하는지 테스트")
    @Test
    void countTimes() {
        int result = computer.countTimes(8000);
        assertThat(result).isEqualTo(8);
    }
}