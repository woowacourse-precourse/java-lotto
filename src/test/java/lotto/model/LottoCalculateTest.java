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

    @DisplayName(("로또번호(l1)가 당첨 숫자(l2)와5개가 일치하고, 보너스넘버가 불일치하면 3 을 리턴한다"))
    @Test
    void calculatePrizeTest1() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        int bonusNumber = 8;
        int matchCount = lottoCalculate.checkMatches(l1, l2);
        boolean checkBonusNumber = lottoCalculate.checkBonusNumber(l1, bonusNumber);

        assertThat(lottoCalculate.calculatePrize(matchCount, checkBonusNumber)).isEqualTo(3);
    }

    @DisplayName(("로또번호(l1)가 당첨 숫자(l2)와5개가 일치하고, 보너스넘버가 일치하면 2를 리턴한다"))
    @Test
    void calculatePrizeTest2() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        int bonusNumber = 1;
        int matchCount = lottoCalculate.checkMatches(l1, l2);
        boolean checkBonusNumber = lottoCalculate.checkBonusNumber(l1, bonusNumber);

        assertThat(lottoCalculate.calculatePrize(matchCount, checkBonusNumber)).isEqualTo(2);
    }
//    Test 함수 삭제로 인한 Test 삭제
//    @DisplayName("2등인 경우 상금 3천만 을 리턴한다.")
//    @Test
//    void checkWinMoneyTest() {
//        LottoPrizeMoneyMatchCount lottoPrizeMoneyMatchCount = lottoCalculate.calculatePrize(5, true);
//        assertThat(lottoCalculate.calculateWinMoney(lottoPrizeMoneyMatchCount)).isEqualTo(30000000);
//    }

    @DisplayName("로또 번호가 2등 당첨인 상황이면 lottoData 의 prize, prizeMoneySum 에 정보가 등수에 맞게 추가 된다.")
    @Test
    void totalCalculateTest1() {
        LottoData lottoData = new LottoData(1000);
        lottoData.winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoData.bonusNumber = 7;
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        Lotto lotto = new Lotto(lottoNumbers);
        lottoData.allLotto.add(lotto);
        lottoData.calculateAllLotto();
        assertThat(lottoData.prizeCount.getPrizeCount().get(2)).isEqualTo(1);
        assertThat(lottoData.prizeMoneySum).isEqualTo(30000000);
    }

    @DisplayName("로또 번호가 4등 당첨인 상황이 lottoData 의 prize, prizeMoneySum 에 정보가 등수에 맞게 추가 된다.")
    @Test
    void totalCalculateTest2() {
        LottoData lottoData = new LottoData(1000);
        lottoData.winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoData.bonusNumber = 7;
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 10));
        Lotto lotto = new Lotto(lottoNumbers);
        lottoData.allLotto.add(lotto);
        lottoData.calculateAllLotto();
        assertThat(lottoData.prizeCount.getPrizeCount().get(4)).isEqualTo(1);
        assertThat(lottoData.prizeMoneySum).isEqualTo(50000);
    }

    @DisplayName("로또 번호가 3등 당첨인 상황이면 lottoData 의 prize, prizeMoneySum 에 정보가 등수에 맞게 추가 된다.")
    @Test
    void totalCalculateTest3() {
        LottoData lottoData = new LottoData(1000);
        lottoData.winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoData.bonusNumber = 7;
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10));
        Lotto lotto = new Lotto(lottoNumbers);
        lottoData.allLotto.add(lotto);
        lottoData.calculateAllLotto();
        assertThat(lottoData.prizeCount.getPrizeCount().get(3)).isEqualTo(1);
        assertThat(lottoData.prizeMoneySum).isEqualTo(1500000);
    }

    @DisplayName("구입금액: 10000, 상금: 12345 일 때 수익률은 123.5 이다.")
    @Test
    void calculatePercentageOfReturnTest() {
        LottoData lottoData = new LottoData(10000);
        lottoData.prizeMoneySum = 12345;
        lottoCalculate.calculatePercentageOfReturn(lottoData);
        assertThat(lottoData.percentageOfReturn).isEqualTo(123.5f);
    }
}