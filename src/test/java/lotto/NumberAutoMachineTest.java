package lotto;

import lotto.domain.NumberAutoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberAutoMachineTest {

    NumberAutoMachine numberAutoMachine = new NumberAutoMachine();

    @DisplayName("중복되지 않는 6개의 숫자 오름차순으로 받기")
    @Test
    void pickNumbersTest(){
        int size = 6;
        List<Integer> numbers = numberAutoMachine.pickNumbers();
        assertThat(numbers.size()).isEqualTo(size);
    }
}