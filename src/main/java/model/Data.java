package model;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Data {

    public static final int THREE = 5000;
    public static final int FOUR = 50000;
    public static final int FIVE = 1500000;
    public static final int FIVE_BONUS = 30000000;
    public static final int SIX = 2000000000;
    public static final int ZERO = 0;
    public String purchaseAmount;
    public String winningNumber;
    public String BonusNumber;
    public HashMap<Integer, Integer> winningStatistics = new HashMap<>();
    public List<Integer> winningLottoNumber = new ArrayList<>();
    public List<Integer>[] userLotto;

    public double yield;

    public int numberOfLotto;

    public int revenue[] = {ZERO, ZERO, ZERO, THREE, FOUR, FIVE, FIVE_BONUS, SIX};

    public int checkLottoNumber(List<Integer> userLotto) {
        int count = 0;
        for (int i = 0; i < winningLottoNumber.size(); i++) {
            if (userLotto.contains(winningLottoNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public void makeNumberOfLotto() {
        numberOfLotto = Integer.parseInt(purchaseAmount);
        numberOfLotto = numberOfLotto / 1000;
    }

    public void makeWinningLottoNumber(){
        String[] winningNumberSplit = winningNumber.split(",");
        for (int i = 0; i < winningNumberSplit.length; i++) {
            winningLottoNumber.add(Integer.valueOf(winningNumberSplit[i]));
        }
    }

    public void initializeWinningStatistics() {
        for (int i = 3; i <= 7; i++) {
            winningStatistics.put(i, 0);
        }
    }

    public void makeWinningStatistics(List<Integer> userLotto, int winningLottoCount) {
        if (winningLottoCount < 3) {
            return;
        }
        if (winningLottoCount == 5) {
            if (userLotto.contains(BonusNumber)) {
                winningLottoCount = 7;
            }
        }
        winningStatistics.put(winningLottoCount, winningStatistics.get(winningLottoCount) + 1);
    }

    public void makeYield() {
        int sum = 0;
        for (int i = 3; i <= 7; i++) {
            if (winningStatistics.get(i) > 0) {
                sum += winningStatistics.get(i) * revenue[i];
            }
        }
        yield = ((double) sum / (double) Integer.parseInt(purchaseAmount)) * 100;
    }

    public void initializeUserLotto(){
        userLotto = new ArrayList[numberOfLotto];
        for (int i = 0; i < numberOfLotto; i++) {
            userLotto[i] = new ArrayList<Integer>();
        }
    }

}
