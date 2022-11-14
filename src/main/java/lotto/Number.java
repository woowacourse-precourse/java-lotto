package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Number {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int THREE = 5000;
    public static final int FOUR = 50000;
    public static final int FIVE = 1500000;
    public static final int FIVE_BONUS = 30000000;
    public static final int SIX = 2000000000;
    public static final int ZERO = 0;
    int[] arr = {ZERO, ZERO, ZERO, THREE, FOUR, FIVE, SIX, FIVE_BONUS};

    String purchaseAmount;
    String winningNumber;
    String BonusNumber;
    List<Integer> randomNumbers;
    HashMap<Integer, Integer> Win = new HashMap<>();

    public void inputNumber(String check) {
        if (check.equals(Message.AMOUNT.getMessage())) {
            purchaseAmount = Console.readLine();
        }
        if (check.equals(Message.WINNING.getMessage())) {
            winningNumber = Console.readLine();
        }
        if (check.equals(Message.BONUSNUMBER.getMessage())) {
            BonusNumber = Console.readLine();
        }
    }

    public void getRandomNumber() {
        randomNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTO_SIZE);
    }

}
