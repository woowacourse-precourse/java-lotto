package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculateTest {
    @DisplayName("두 리스트 l1, l2를 비교해 일치하는 것의 개수를 리턴한다.")
    @Test
    void checkMatchesTest(){
        LottoCalculate lottoCalculate = new LottoCalculate();
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2,3,4,5));

        int result = lottoCalculate.checkMatches(l1,l2);
        assertThat(result).isEqualTo(3);
    }

}