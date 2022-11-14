package model;

import java.util.*;

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
    public HashMap<Integer, Integer> Win = new HashMap<>();
    public List<Integer> winningLottoNumber = new ArrayList<>();

    public double yield;

    public int numberOfLotto;

    public int revenue[] = {ZERO,ZERO,ZERO,THREE,FOUR,FIVE,FIVE_BONUS,SIX};

    public int checkLottoNumber(List<Integer> userLotto) {
        int count = 0;
        for (int i = 0; i < winningLottoNumber.size(); i++) {
            if (userLotto.contains(winningLottoNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public void getNumberOfLotto() {
        numberOfLotto = Integer.parseInt(purchaseAmount);
        numberOfLotto = numberOfLotto / 1000;
    }

    public void initializeMap() {
        for (int i = 3; i <= 7; i++) {
            Win.put(i, 0);
        }
    }

    public void map(List<Integer> userLotto, int count) {
        if (count < 3) {
            return;
        }
        if (count == 5) {
            if (userLotto.contains(BonusNumber)) {
                count = 7;
            }
        }
        Win.put(count, Win.get(count) + 1);
    }

    public void getYield() {
        int sum = 0;
        for (int i = 3; i <= 7; i++) {
            if (Win.get(i) > 0) {
                sum += Win.get(i) * revenue[i];
            }
        }
        yield = ((double) sum / (double) Integer.parseInt(purchaseAmount)) * 100;
    }

}
