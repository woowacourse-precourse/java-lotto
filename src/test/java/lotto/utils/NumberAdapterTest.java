package lotto.utils;

import static lotto.utils.NumberAdapter.getBonusNumber;
import static lotto.utils.NumberAdapter.getLotteryNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberAdapterTest {
    @Test
    @DisplayName("조건에 맞는 입력값을 입력헀을 때 문자열에서 정수 List 로 형을 변환하여 반환한다.")
    void checkGetLotteryNumbers() {
        //given
        String validInput = "1,2,3,4,5,6";

        //when
        List<Integer> result = getLotteryNumbers(validInput);

        //then
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("조건에 맞는 입력값을 입력했을 때 문자열에서 정수형으로 형을 변환하여 반환한다.")
    void checkGetBonusNumber(){
        //given
        String validInput = "3";

        //when
        int result = getBonusNumber(validInput);

        //then
        assertThat(result).isEqualTo(3);
    }
}
