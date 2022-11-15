package lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.Const.*;

public class Result {
    private Map<Float, Integer> winBoard;

    public Result() {
        initWinBoard();
    }

    public void compare(Customer customer, Lotto lotto) {
        float matchingNumber = numberOfMatchingNumbers(customer.getWinningNumber(), lotto);

        if (matchingNumber == 5f) {
            if (match(lotto, customer.getBonusNumber())) {
                matchingNumber += 0.5;
            }
        }

        updateWinBoard(matchingNumber);
    }

    public long getTotalReward() {
        List<Float> numbersOfMatching = Rank.getNumbersOfMatching();
        long totalReward = 0;
        for (float matching : numbersOfMatching) {
            totalReward += getReward(matching);
        }

        return totalReward;
    }

    public void printStatistic() {
        List<Float> numbersOfMatching = Rank.getNumbersOfMatching();

        for (float matching : numbersOfMatching) {
            int winSheetCount = winBoard.get(matching);
            long reward = Rank.getPrize(matching);
            System.out.println(getOutOfMatching(matching) + " ("
                    + getOutOfPrize(reward) + "원) - " + winSheetCount + "개");
        }
    }

    private long getReward(float matchingNumber) {
        long winSheetCount = winBoard.get(matchingNumber);
        return winSheetCount * Rank.getPrize(matchingNumber);
    }

    private String getOutOfMatching(float matchingNumber) {
        String outOfMatching = "";

        if (matchingNumber == 5.5f) {
            outOfMatching = "5개 일치, 보너스 볼 일치";
        }

        if (matchingNumber != 5.5f) {
            outOfMatching = (int) matchingNumber + "개 일치";
        }

        return outOfMatching;
    }

    private String getOutOfPrize(long prize) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(prize);
    }

    private void updateWinBoard(float matchingNumber) {
        if (winBoard.containsKey(matchingNumber)) {
            winBoard.put(matchingNumber, winBoard.get(matchingNumber) + 1);
        }
    }

    private int numberOfMatchingNumbers(Lotto winningNumber, Lotto lotto) {
        int matchingCount = 0;

        for (int i = 0; i < SIZE; i++) {
            if (match(winningNumber, lotto.getNumbers().get(i))) {
                matchingCount++;
            }
        }

        return matchingCount;
    }

    private boolean match(Lotto lotto, int findNumber) {
        return lotto.getNumbers().contains(findNumber);
    }

    private void initWinBoard() {
        winBoard = new HashMap<>();
        List<Float> numbersOfMatching = Rank.getNumbersOfMatching();
        numbersOfMatching.forEach(number -> winBoard.put(number, 0));
    }

    public Map<Float, Integer> getWinBoard() {
        return this.winBoard;
    }
}
