package service;

import domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultServiceTest {
    ResultServiceImpl resultService;

    @BeforeEach
    void beforeEach() {
        resultService = new ResultServiceImpl();
    }

    @DisplayName("등수가 맞게 나오는지 확인한다.")
    @Test
    void getResultTest() {
        List<Integer> listOfUserNum = List.of(1,2,3,4,5,6);
        List<List<Integer>> lottoList =
                List.of(
                        List.of(1,2,3,4,5,6), // 1등
                        List.of(6,5,4,3,2,1),  // 1등
                        List.of(12, 13, 14, 15, 16, 17), // 없음
                        List.of(1, 3, 4, 5, 6, 17), // 3등
                        List.of(1, 3, 4, 5, 16, 17), // 4등
                        List.of(1,4,7,9,3,11),  // 5등
                        List.of(1,2,3,4,5,7) // 2등
                );
        int bonus = 7;

        Map<Rank, Integer> testOfCompare = resultService.getResult(listOfUserNum, lottoList, bonus);
        Map<Rank, Integer> resultOfCompare = new EnumMap<Rank, Integer>(Rank.class);
        resultOfCompare.put(Rank.FIRST, 2);
        resultOfCompare.put(Rank.SECOND, 1);
        resultOfCompare.put(Rank.THIRD, 1);
        resultOfCompare.put(Rank.FOURTH, 1);
        resultOfCompare.put(Rank.FIFTH, 1);
        assertThat(testOfCompare).isEqualTo(resultOfCompare);
    }

    @DisplayName("일치하는 번호의 개수가 잘 나오는지 확인한다.")
    @Test
    void getCntOfMatchedNumTest() {
        List<Integer> listOfUserNum = List.of(1,2,3,4,5,6);
        List<Integer> newLotto = List.of(4,2,3,7,5,6);
        int resultCntOfMatchedNum = 5;

        int testCntOfMatchedNum = resultService.getCntOfMatchedNum(listOfUserNum, newLotto);

        assertThat(testCntOfMatchedNum).isEqualTo(resultCntOfMatchedNum);

    }

    @DisplayName("보너스 일치 여부가 잘 나오는지 확인한다.")
    @Test
    void isBonusMatchedTest() {
        List<Integer> newLotto = List.of(4,2,3,7,5,6);
        List<Integer> newLotto2 = List.of(4,2,3,1,5,6);
        int bonus = 7;

        boolean testIsBonusMatched = resultService.isBonusMatched(newLotto, bonus);
        boolean testIsBonusMatched2 = resultService.isBonusMatched(newLotto2, bonus);

        assertThat(testIsBonusMatched).isEqualTo(true);
        assertThat(testIsBonusMatched2).isEqualTo(false);
    }

    @DisplayName("보너스 일치 여부가 잘 나오는지 확인한다.")
    @Test
    void getYieldTest() {
        int userPayment = 6000;
        Map<Rank, Integer> resultOfGetYield = new EnumMap<Rank, Integer>(Rank.class);
        resultOfGetYield.put(Rank.FIRST, 0);
        resultOfGetYield.put(Rank.SECOND, 0);
        resultOfGetYield.put(Rank.THIRD, 0);
        resultOfGetYield.put(Rank.FOURTH, 1);
        resultOfGetYield.put(Rank.FIFTH, 1);

        double resultOfYield = 916.7;
        double testOfYield = resultService.getYield(resultOfGetYield, userPayment);

        assertThat(testOfYield).isEqualTo(resultOfYield);
    }


}
