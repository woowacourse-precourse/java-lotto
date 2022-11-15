package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

class LottoStatisticsTest {

    private final LottoStatistics lottoStatistics =
            new LottoStatistics();

    @Test
    @DisplayName("순위별 카운트 확인")
    void rankCountTest() {
        List<List<Integer>> testNumbers = new ArrayList<>();
        Integer bonusNumber = 4;
        lottoStatistics.setBonusNumber(bonusNumber);

        testNumbers.add(List.of(1, 2, 3));            //5등
        testNumbers.add(List.of(1, 2));              //4등
        testNumbers.add(List.of(1));            //3등
        testNumbers.add(List.of(1, bonusNumber));   //2등
        testNumbers.add(List.of());                 //1등

        Iterator testNumberIter = testNumbers.iterator();
        while (testNumberIter.hasNext()) {
            List<Integer> tmp = (List<Integer>) testNumberIter.next();
            lottoStatistics.rankCount(tmp);
        }

        for (Rank rank : Rank.values()) {
            assertThat(rank.getCount() == 1);
        }
    }

    @Test
    @DisplayName("총 상금 확인 테스트")
    void getTotalPrizeTest() {
        List<List<Integer>> testNumbers = new ArrayList<>();
        Integer bonusNumber = 4;
        lottoStatistics.setBonusNumber(bonusNumber);

        testNumbers.add(List.of(1, 2, 3));            //5등
        testNumbers.add(List.of(1, 2));              //4등
        testNumbers.add(List.of(1));            //3등
        testNumbers.add(List.of(1, bonusNumber));   //2등
        testNumbers.add(List.of());                 //1등

        Iterator testNumberIter = testNumbers.iterator();
        while (testNumberIter.hasNext()) {
            List<Integer> tmp = (List<Integer>) testNumberIter.next();
            lottoStatistics.rankCount(tmp);
        }
        BigInteger totalPrize = lottoStatistics.getTotalPrize();

        assertThat(totalPrize.toString() == "2031555000");
    }

    @Test
    @DisplayName("총 수익률 계산 확인")
    void getRateOfReturnTest() {
        List<List<Integer>> testNumbers = new ArrayList<>();
        Integer bonusNumber = 4;
        lottoStatistics.setBonusNumber(bonusNumber);

        testNumbers.add(List.of(1, 2, 3));          //5등
        testNumbers.add(List.of(1, 2));             //4등
        testNumbers.add(List.of(1));            //3등
        testNumbers.add(List.of(1, bonusNumber));   //2등
        testNumbers.add(List.of());                 //1등

        Iterator testNumberIter = testNumbers.iterator();
        while (testNumberIter.hasNext()) {
            List<Integer> tmp = (List<Integer>) testNumberIter.next();
            lottoStatistics.rankCount(tmp);
        }
        BigInteger totalPrize =
                lottoStatistics.getTotalPrize();
        lottoStatistics.setMoney(BigInteger.valueOf(5000));
        BigDecimal rateReturn =
                lottoStatistics.getRateOfReturn();

        assertThat(rateReturn.toString() == "40631100");
    }
}