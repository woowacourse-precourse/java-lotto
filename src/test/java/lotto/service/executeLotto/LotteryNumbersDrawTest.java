package lotto.service.executeLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryNumbersDrawTest {
    @DisplayName("string input 값을 ,로 쪼개어 배열로 만듬")
    @Test
    void getDraw() {
        String USER_INPUT = "3,  5,   7,   19,   8,     36";
        ArrayList<Integer> EXPECTED_RESULT = new ArrayList<>(Arrays.asList(3, 5, 7, 8, 19, 36));

        LotteryNumbersDraw draw = new LotteryNumbersDraw(USER_INPUT);
        List<Integer> result =  draw.drawNumbers();

        System.out.println(result);
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("string input 값을 ,로 쪼개어 배열로 만듬")
    @Test
    void getBonusNumber() {
        String USER_INPUT = "3,  5,   7,   19,   8,     36";
        int BONUS_NUMBER = 4;
        int EXPECTED_RESULT = 4;
        LotteryNumbersDraw draw = new LotteryNumbersDraw(USER_INPUT);
        Integer result =  draw.getBonusNumber(BONUS_NUMBER);

        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

}
