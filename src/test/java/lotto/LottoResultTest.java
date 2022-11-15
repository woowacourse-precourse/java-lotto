package lotto;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    void compareLotteryNumbersTest() {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(4, 8, 10, 19, 28, 40));
        List<Integer> ticketNumbers = new ArrayList<>(Arrays.asList(1, 4, 10, 20, 28, 45));
        int result = LottoResult.compareLotteryNumbers(winningNumbers, ticketNumbers);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void compareResultTest() {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(4, 8, 10, 19, 28, 40));
        List<List<Integer>> ticketNumbers = new ArrayList<>(Arrays.asList(Arrays.asList(1, 4, 8, 10, 19, 45),//4
                Arrays.asList(4, 8, 10, 19, 28, 40), Arrays.asList(4, 8, 9, 10, 19, 31)));
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        result = LottoResult.compareResult(winningNumbers, ticketNumbers,1);
        System.out.println(result);
        assert(result.get(4)).equals(2);
    }


}