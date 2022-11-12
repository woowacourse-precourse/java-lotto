package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.LottoCalculate.LottoPrizeMoney;
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

    @DisplayName(("로또번호(l1)가 당첨 숫자(l2)와5개가 일치하고, 보너스넘버가 불일치하면 LottoPrizeMoney.THIRD 을 리턴한다"))
    @Test
    void calculatePrizeTest1() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        int bonusNumber = 8;
        int matchCount = lottoCalculate.checkMatches(l1, l2);
        boolean checkBonusNumber = lottoCalculate.checkBonusNumber(l1, bonusNumber);

        assertThat(lottoCalculate.calculatePrize(matchCount, checkBonusNumber)).isEqualTo(LottoPrizeMoney.THIRD);
    }

    @DisplayName(("로또번호(l1)가 당첨 숫자(l2)와5개가 일치하고, 보너스넘버가 일치하면 LottoPrizeMoney.SECOND 을 리턴한다"))
    @Test
    void calculatePrizeTest2() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        int bonusNumber = 1;
        int matchCount = lottoCalculate.checkMatches(l1, l2);
        boolean checkBonusNumber = lottoCalculate.checkBonusNumber(l1, bonusNumber);

        assertThat(lottoCalculate.calculatePrize(matchCount, checkBonusNumber)).isEqualTo(LottoPrizeMoney.SECOND);
    }

    @DisplayName("2등인 경우 상금 3천만 을 리턴한다.")
    @Test
    void checkWinMoneyTest() {
        LottoPrizeMoney lottoPrizeMoney = lottoCalculate.calculatePrize(5, true);
        assertThat(lottoCalculate.calculateWinMoney(lottoPrizeMoney)).isEqualTo(30000000);
    }

    @DisplayName("로또 번호가 2등 당첨인 상황에서 Lotto 객체에 prize, prizeMoney 정보가 등수에 맞게 업데이트 된다.")
    @Test
    void totalCalculateTest1() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        Lotto lotto = new Lotto(lottoNumbers);
        lottoCalculate.totalCalculate(lotto, winNumbers, bonusNumber);
        assertThat(lotto.getPrize()).isEqualTo(2);
        assertThat(lotto.getPrizeMoney()).isEqualTo(30000000);
    }

    @DisplayName("로또 번호가 4등 당첨인 상황에서 Lotto 객체에 prize, prizeMoney 정보가 등수에 맞게 업데이트 된다.")
    @Test
    void totalCalculateTest2() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 10));
        Lotto lotto = new Lotto(lottoNumbers);
        lottoCalculate.totalCalculate(lotto, winNumbers, bonusNumber);
        assertThat(lotto.getPrize()).isEqualTo(4);
        assertThat(lotto.getPrizeMoney()).isEqualTo(50000);
    }

    @DisplayName("로또 번호가 3등 당첨인 상황에서 Lotto 객체에 prize, prizeMoney 정보가 등수에 맞게 업데이트 된다.")
    @Test
    void totalCalculateTest3() {
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10));
        Lotto lotto = new Lotto(lottoNumbers);
        lottoCalculate.totalCalculate(lotto, winNumbers, bonusNumber);
        assertThat(lotto.getPrize()).isEqualTo(3);
        assertThat(lotto.getPrizeMoney()).isEqualTo(1500000);
    }

    @DisplayName("구입금액: 10000, 상금: 12345 일 때 수익률은 123.5 이다.")
    @Test
    void calculatePercentageOfReturnTest() {
        assertThat(lottoCalculate.calculatePercentageOfReturn(10000, 12345)).isEqualTo(123.5);
    }
}