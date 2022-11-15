package lotto;

import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.util.Statistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTest {

    @DisplayName("1등 당첨 통계를 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsByFirst() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 7);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(7,8,9,30,31,32));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);

        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);
        Map<Rank, Integer> winningStatistics = statistics.getWinningStatistics();
        Map<Rank, Integer> correctAnswer = new HashMap<>();
        for (Rank rank : Rank.values()) {
            correctAnswer.put(rank, 0);
        }
        correctAnswer.put(Rank.FIRST, 1);

        assertEquals(winningStatistics, correctAnswer);
    }

    @DisplayName("2등 당첨 통계를 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsBySecond() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,45));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 7);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(1,2,3,4,5,7));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(7,8,9,30,31,32));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);

        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);
        Map<Rank, Integer> winningStatistics = statistics.getWinningStatistics();
        Map<Rank, Integer> correctAnswer = new HashMap<>();
        for (Rank rank : Rank.values()) {
            correctAnswer.put(rank, 0);
        }
        correctAnswer.put(Rank.SECOND, 1);

        assertEquals(winningStatistics, correctAnswer);
    }

    @DisplayName("3등 당첨 통계를 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsByThird() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 40);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(1,2,3,4,5,9));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(7,8,9,30,31,32));
        List<Integer> buyLottoNumber3 = new ArrayList<>(List.of(2,3,4,5,6,7));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);
        lottoNumbers.add(buyLottoNumber3);

        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);
        Map<Rank, Integer> winningStatistics = statistics.getWinningStatistics();
        Map<Rank, Integer> correctAnswer = new HashMap<>();
        for (Rank rank : Rank.values()) {
            correctAnswer.put(rank, 0);
        }
        correctAnswer.put(Rank.THIRD, 2);

        assertEquals(winningStatistics, correctAnswer);
    }

    @DisplayName("4등 당첨 통계를 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsByFourth() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(25,26,27,11,10,9));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 40);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(26,27,11,10,1,2));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(25,26,27,9,3,5));
        List<Integer> buyLottoNumber3 = new ArrayList<>(List.of(2,3,4,5,6,7));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);
        lottoNumbers.add(buyLottoNumber3);

        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);
        Map<Rank, Integer> winningStatistics = statistics.getWinningStatistics();
        Map<Rank, Integer> correctAnswer = new HashMap<>();
        for (Rank rank : Rank.values()) {
            correctAnswer.put(rank, 0);
        }
        correctAnswer.put(Rank.FOURTH, 2);

        assertEquals(winningStatistics, correctAnswer);
    }

    @DisplayName("5등 당첨 통계를 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsByFifth() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 40);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(1,2,3,10,11,12));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(7,8,9,30,31,32));
        List<Integer> buyLottoNumber3 = new ArrayList<>(List.of(3,4,8,5,9,10));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);
        lottoNumbers.add(buyLottoNumber3);

        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);
        Map<Rank, Integer> winningStatistics = statistics.getWinningStatistics();
        Map<Rank, Integer> correctAnswer = new HashMap<>();
        for (Rank rank : Rank.values()) {
            correctAnswer.put(rank, 0);
        }
        correctAnswer.put(Rank.FIFTH, 2);

        assertEquals(winningStatistics, correctAnswer);
    }

    @DisplayName("2등과 4등 당첨 통계를 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsByMultiWinning() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 40);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(2,3,4,5,6,40));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(1,3,4,5,8,9));
        List<Integer> buyLottoNumber3 = new ArrayList<>(List.of(40,41,42,43,44,45));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);
        lottoNumbers.add(buyLottoNumber3);

        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);
        Map<Rank, Integer> winningStatistics = statistics.getWinningStatistics();
        Map<Rank, Integer> correctAnswer = new HashMap<>();
        for (Rank rank : Rank.values()) {
            correctAnswer.put(rank, 0);
        }
        correctAnswer.put(Rank.SECOND, 1);
        correctAnswer.put(Rank.FOURTH, 1);

        assertEquals(winningStatistics, correctAnswer);
    }
    @DisplayName("5등 2개 당첨 수익률을 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsPrizeFifth() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 40);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(2,3,4,40,41,42));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(1,2,4,7,8,9));
        List<Integer> buyLottoNumber3 = new ArrayList<>(List.of(40,41,42,43,44,45));
        List<Integer> buyLottoNumber4 = new ArrayList<>(List.of(1,24,23,24,25,29));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);
        lottoNumbers.add(buyLottoNumber3);
        lottoNumbers.add(buyLottoNumber4);
        System.out.println(lottoNumbers);
        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);

        double revenueRatio = statistics.calculatorRevenueRatio(4000);
        System.out.println(revenueRatio);
        assertEquals(revenueRatio, 250.0);
    }

    @DisplayName("1등 1개 2등 1개 당첨 수익률을 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsPrizeFirstAndSecond() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 40);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(1,2,4,5,6,40));
        List<Integer> buyLottoNumber3 = new ArrayList<>(List.of(40,3,8,9,10,11));
        List<Integer> buyLottoNumber4 = new ArrayList<>(List.of(1,24,23,24,25,29));
        List<Integer> buyLottoNumber5 = new ArrayList<>(List.of(30,31,32,33,34,35));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);
        lottoNumbers.add(buyLottoNumber3);
        lottoNumbers.add(buyLottoNumber4);
        lottoNumbers.add(buyLottoNumber5);

        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);

        double revenueRatio = statistics.calculatorRevenueRatio(5000);
        assertEquals(revenueRatio, 40600000.0);
    }


    @DisplayName("3등 1개 4등 2개 당첨 수익률을 반환하는지 확인한다.")
    @Test
    void createLottoStatisticsPrizeThirdAndFourth() {
        Statistics statistics = new Statistics();
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumber, 40);

        List<Integer> buyLottoNumber1 = new ArrayList<>(List.of(1,2,3,4,5,10));
        List<Integer> buyLottoNumber2 = new ArrayList<>(List.of(1,2,4,5,26,40));
        List<Integer> buyLottoNumber3 = new ArrayList<>(List.of(1,3,5,6,10,41));
        List<Integer> buyLottoNumber4 = new ArrayList<>(List.of(1,24,23,24,25,29));
        List<Integer> buyLottoNumber5 = new ArrayList<>(List.of(30,31,32,33,34,35));
        List<Integer> buyLottoNumber6 = new ArrayList<>(List.of(30,31,32,33,34,35));
        List<Integer> buyLottoNumber7 = new ArrayList<>(List.of(30,31,32,33,34,35));
        List<Integer> buyLottoNumber8 = new ArrayList<>(List.of(30,31,32,33,34,35));
        List<Integer> buyLottoNumber9 = new ArrayList<>(List.of(30,31,32,33,34,35));
        List<Integer> buyLottoNumber10 = new ArrayList<>(List.of(30,31,32,33,34,35));

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(buyLottoNumber1);
        lottoNumbers.add(buyLottoNumber2);
        lottoNumbers.add(buyLottoNumber3);
        lottoNumbers.add(buyLottoNumber4);
        lottoNumbers.add(buyLottoNumber5);
        lottoNumbers.add(buyLottoNumber6);
        lottoNumbers.add(buyLottoNumber7);
        lottoNumbers.add(buyLottoNumber8);
        lottoNumbers.add(buyLottoNumber9);
        lottoNumbers.add(buyLottoNumber10);


        statistics.makeWinningStatistics(winningNumbers, lottoNumbers);
        System.out.println(statistics.getWinningStatistics());
        double revenueRatio = statistics.calculatorRevenueRatio(10000);
        assertEquals(revenueRatio, 16000.0);
    }
}