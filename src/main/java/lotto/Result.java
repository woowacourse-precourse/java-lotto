package lotto;

import java.util.HashMap;
import java.util.Map;

import static lotto.Const.*;

public class Result {
    private Map<Float, Integer> winBoard;
    private Rank[] ranks;

    public Result() {
        initWinBoard();
        ranks = Rank.values();
    }

    public void compare(Customer customer, Lotto lotto) {
        float matchingNumber = numberOfMatchingNumbers(customer.getWinningNumber(), lotto); // lotto 번호만 넘김

        if (matchingNumber == 5f) {
            if (match(lotto, customer.getBonusNumber())) {
                matchingNumber += 0.5;
            }
        }

        updateWinBoard(matchingNumber);
    }

    public long getTotalReward() {
        long totalReward = 0;

        for (int i = 0; i < ranks.length; i++) {
            totalReward += getReward(ranks[i].getMatching());
        }

        return totalReward;
    }

    public void printStatistic() {
        for (int i = 0; i < ranks.length; i++) {
            int winSheetCount = winBoard.get(ranks[i].getMatching());
            long reward = getReward(ranks[i].getMatching());

            System.out.println(getOutOfMatching(ranks[i].getMatching()) + " (" + getOutOfPrize(ranks[i].getPrize()) + "원) - " + winSheetCount + "개");
        }
    }

    public long getReward(float matchingNumber) {
        long winSheetCount = winBoard.get(matchingNumber);
        long reward = 0;

        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i].getMatching() == matchingNumber) {
                reward = winSheetCount * ranks[i].getPrize();
            }
        }

        return reward;
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

    private String getOutOfPrize(long prize) { // 3 자리씩 끊어서 출력, Decimal.formater
        String longToString = Long.toString(prize);
        String outOfPrize = "";
        int index = 0;

        for (int i = longToString.length() - 1; i != -1; i--) {
            if (index != 0 && index % 3 == 0) {
                outOfPrize = "," + outOfPrize;
            }

            outOfPrize = longToString.charAt(i) + outOfPrize;
            index++;
        }

        return outOfPrize;
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

        for (float i = 3; i <= 6; i++) {
            winBoard.put(i, 0);
        }

        winBoard.put(5.5f, 0);
    }

    public Map<Float, Integer> getWinBoard() {
        return this.winBoard;
    }
}
