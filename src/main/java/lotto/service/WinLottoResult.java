package lotto.service;

import lotto.Data.PrizeRanking;
import lotto.Data.UserMoney;
import lotto.view.Output;

import java.util.List;

public class WinLottoResult {
    private final int BONUS_POINT = 10;
    public static int yield;

    public void checkWinLottoResult(List<Integer> winningNumbers, List<List<Integer>> randomLottoLists) {
        Output output = new Output();
        int[] checkLottoPoint = new int[randomLottoLists.size()];

        output.winStatistics();
        for(int i = 0; i < randomLottoLists.size(); i++){
            checkLottoPoint[i] = countWinPoints(winningNumbers, randomLottoLists.get(i));
        }
        printWinResult(checkWinResult(checkLottoPoint));
    }

    private int[] checkWinResult(int[] checkLottoPoint) {
        int[] checkWinResult = new int[PrizeRanking.values().length];

        for (int countWinPoints : checkLottoPoint) {
            if (countWinPoints % BONUS_POINT == 3) { checkWinResult[0] += 1;}
            if (countWinPoints % BONUS_POINT == 4) { checkWinResult[1] += 1;}
            if (countWinPoints == 5) { checkWinResult[2] += 1;}
            if (countWinPoints == 15) { checkWinResult[3] += 1;}
            if (countWinPoints % BONUS_POINT == 6) { checkWinResult[4] += 1;}
        }

        return checkWinResult;
    }

    private int countWinPoints(List<Integer> winningNumbers, List<Integer> randomLottoLists ) {
        int count = 0;
        int winningPoint= 1;

        for (Integer randomLottoList : randomLottoLists) {
            if (randomLottoList == Integer.parseInt(InputBonusNumber.inputBonusNumber)) { count += BONUS_POINT;}

            if (winningNumbers.contains(randomLottoList)) count += winningPoint;
        }

        return count;
    }

    private void printWinResult(int[] winResult) {
        Output output = new Output();

        output.fifthPlace(winResult[0]);
        output.fourthPlace(winResult[1]);
        output.thirdPlace(winResult[2]);
        output.secondPlace(winResult[3]);
        output.firstPlace(winResult[4]);
    }

    public void calculateYield(int profitMoney, UserMoney userMoney) {
        Output output = new Output();

        double userInputMoney = userMoney.getMoney();
        double answer = (profitMoney) / userInputMoney;
        double yield = Math.round(answer*1000)/10.0;

        output.totalYield(yield);
    }
}