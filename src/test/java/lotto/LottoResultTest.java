package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    void compareLotteryNumbersTest(){
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(4,8,10,19,28,40));
        List<Integer> ticketNumbers = new ArrayList<>(Arrays.asList(1,4,10,20,28,45));
        int result = LottoResult.compareLotteryNumbers(winningNumbers, ticketNumbers);

        assertThat(result).isEqualTo(3);
    }

}