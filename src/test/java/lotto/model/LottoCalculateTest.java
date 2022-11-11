package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculateTest {
    static LottoCalculate lottoCalculate;

    @BeforeAll
    static void initAll() {
        lottoCalculate = new LottoCalculate();
    }

    @DisplayName("두 리스트 l1, l2를 비교해 일치하는 것의 개수를 리턴한다.")
    @Test
    void checkMatchesTest() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));

        int result = lottoCalculate.checkMatches(l1, l2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName(("리스트 l1에 보너스 넘버가 있으면 true를 리턴한다."))
    @Test
    void checkBonusNumberTest() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int bonusNumber = 1;

        assertThat(lottoCalculate.checkBonusNumber(l1, bonusNumber)).isEqualTo(true);
    }

    @DisplayName(("로또번호(l1)가 당첨 숫자(l2)와5개가 일치하고, 보너스넘버가 불일치하면 3을 리턴한다"))
    @Test
    void calculatePrizeTest1() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        int bonusNumber = 8;
        int matchCount = lottoCalculate.checkMatches(l1, l2);
        boolean checkBonusNumber = lottoCalculate.checkBonusNumber(l1, bonusNumber);

        assertThat(lottoCalculate.calculatePrize(matchCount, checkBonusNumber)).isEqualTo(3);
    }

    @DisplayName(("로또번호(l1)가 당첨 숫자(l2)와5개가 일치하고, 보너스넘버가 일치하면 2을 리턴한다"))
    @Test
    void calculatePrizeTest2() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        int bonusNumber = 1;
        int matchCount = lottoCalculate.checkMatches(l1, l2);
        boolean checkBonusNumber = lottoCalculate.checkBonusNumber(l1, bonusNumber);

        assertThat(lottoCalculate.calculatePrize(matchCount, checkBonusNumber)).isEqualTo(2);
    }

}