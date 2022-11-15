package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    final static String PRICE_PATTERN = "^[0-9]*$";
    final static int WINNING_NUMBER_SIZE = 6;
    final static int BONUS_NUMBER_SIZE = 1;

    public int purchasePrice;
    public List<Integer> winningNumbers = new ArrayList<>();
    public int bonusNumber;
    public float profitRatio;

    public User() {
    }

    public void setPurchasePrice() {
        String purchasePrice = Console.readLine();
        if (isValidPurchasePrice(purchasePrice)) {
            this.purchasePrice = Integer.parseInt(purchasePrice);
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isValidPurchasePrice(String purchasePrice) {
        boolean isNumeric = Pattern.matches(PRICE_PATTERN, purchasePrice);
        boolean isThousand = (Integer.parseInt(purchasePrice) % 1000 == 0);

        return (isNumeric && isThousand);
    }

    public void setWinningNumbers() {
        List<String> list =  Arrays.asList(Console.readLine().split(","));
        if (!isWinningNumberSize(list)) {
            throw new IllegalArgumentException();
        }
        for (String winningNumber : list) {
            if (isWinningNumberNumeric(winningNumber)) {
                this.winningNumbers.add(Integer.parseInt(winningNumber));
            }
            if (!isWinningNumberNumeric(winningNumber)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isWinningNumberNumeric(String winningNumbers) {
        boolean isNumeric = Pattern.matches(PRICE_PATTERN, winningNumbers);

        return isNumeric;
    }

    private boolean isWinningNumberSize(List<String> winningNumbers) {
        boolean isSize = winningNumbers.size() == WINNING_NUMBER_SIZE;

        return isSize;
    }

    public void setBonusNumber() {
        String bonusNumber = Console.readLine();
        if (isValidBonusNumber(bonusNumber)) {
            this.bonusNumber = Integer.parseInt(bonusNumber);
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isValidBonusNumber(String bonusNumber) {
        boolean isNumeric = Pattern.matches(PRICE_PATTERN, bonusNumber);

        return isNumeric;
    }

    public float getProfitRatio(int winningPrice) {
        if (winningPrice == 0) {
            return 0f;
        }
        return (float)winningPrice/purchasePrice*100;
    }

    public int getPurchaseNumber() {
        return purchasePrice/1000;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
