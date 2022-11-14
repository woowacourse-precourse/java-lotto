package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
class ResultCalculateTest {
    @DisplayName("2가지의 일련 번호들 사이에 같은 번호의 수 찾기")
    @Test
    void 모든번호가_같음() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        assertThat(1).isEqualTo(ResultCalculate.compareTwoNumbers(lotto,numbers));
    }
    @Test
    void 일부만_같음(){
        assertThat(3)
                .isEqualTo(ResultCalculate.
                        compareTwoNumbers(new Lotto(Arrays.asList(1,2,3,4,5,10)),List.of(1,2,3,4,5,6,7))
                );
        assertThat(4)
                .isEqualTo(ResultCalculate.
                        compareTwoNumbers(new Lotto(Arrays.asList(1,2,3,4,11,10)),List.of(1,2,3,4,5,6,7))
                );
    }
    @Test
    void 다_다름(){
        assertThat(7)
                .isEqualTo(ResultCalculate.
                        compareTwoNumbers(new Lotto(Arrays.asList(1,2,3,4,5,6)),List.of(7,8,9,10,11,12,13))
                );
    }

}