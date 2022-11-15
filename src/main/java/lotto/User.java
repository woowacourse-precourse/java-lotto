package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private final static String PRICE_PATTERN = "^[0-9]*$";
    private final static int WINNING_NUMBER_SIZE = 6;
    private final static int BONUS_NUMBER_SIZE = 1;
    private final static String PURCHASE_PRICE_NUMERIC_ERROR = "[ERROR] 로또 구입 금액은 숫자여야 합니다.";
    private final static String PURCHASE_PRICE_THOUSAND_ERROR = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.";
    private final static String WINNING_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private final static String WINNING_NUMBER_NUMERIC_ERROR = "[ERROR] 당첨 번호는 숫자여야 합니다.";
    private final static String BONUS_NUMBER_NUMERIC_ERROR = "[ERROR] 보너스 번호는 숫자여야 합니다.";

    public int purchasePrice;
    public List<Integer> winningNumbers = new ArrayList<>();
    public int bonusNumber;

    public User() {
    }

    public void setPurchasePrice() {
        String purchasePrice = Console.readLine();
        if (!isValidPurchasePriceNumeric(purchasePrice)) {
            return;
        }
        if (!isValidPurchasePriceThousand(purchasePrice)) {
            return;
        }
        this.purchasePrice = Integer.parseInt(purchasePrice);
    }

    private boolean isValidPurchasePriceNumeric(String purchasePrice) {
        boolean isNumeric = Pattern.matches(PRICE_PATTERN, purchasePrice);
        if (!isNumeric) {
            System.out.println(PURCHASE_PRICE_NUMERIC_ERROR);
        }
        Error error = new Error(!isNumeric);

        return isNumeric;
    }

    private boolean isValidPurchasePriceThousand(String purchasePrice) {
        boolean isThousand = (Integer.parseInt(purchasePrice) % 1000 == 0);
        if (!isThousand) {
            System.out.println(PURCHASE_PRICE_THOUSAND_ERROR);
        }
        Error error = new Error(!isThousand);

        return isThousand;
    }

    public void setWinningNumbers() {
        List<String> list = Arrays.asList(Console.readLine().split(","));
        if (!isWinningNumberSize(list)) {
            return;
        }
        for (String winningNumber : list) {
            if (isWinningNumberNumeric(winningNumber)) {
                this.winningNumbers.add(Integer.parseInt(winningNumber));
            }
            if (!isWinningNumberNumeric(winningNumber)) {
                return;
            }
        }
    }

    private boolean isWinningNumberNumeric(String winningNumbers) {
        boolean isNumeric = Pattern.matches(PRICE_PATTERN, winningNumbers);
        if (!isNumeric) {
            System.out.println(WINNING_NUMBER_NUMERIC_ERROR);
        }
        Error error = new Error(!isNumeric);

        return isNumeric;
    }

    private boolean isWinningNumberSize(List<String> winningNumbers) {
        boolean isSize = winningNumbers.size() == WINNING_NUMBER_SIZE;
        if (!isSize) {
            System.out.println(WINNING_NUMBER_SIZE_ERROR);
        }
        Error error = new Error(!isSize);

        return isSize;
    }

    public void setBonusNumber() {
        String bonusNumber = Console.readLine();
        if (!isValidBonusNumber(bonusNumber)) {
            return;
        }
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private boolean isValidBonusNumber(String bonusNumber) {
        boolean isNumeric = Pattern.matches(PRICE_PATTERN, bonusNumber);
        if (!isNumeric) {
            System.out.println(BONUS_NUMBER_NUMERIC_ERROR);
        }
        Error error = new Error(!isNumeric);

        return isNumeric;
    }

    public float getProfitRatio(int winningPrice) {
        if (winningPrice == 0) {
            return 0f;
        }
        return (float) winningPrice / purchasePrice * 100;
    }

    public int getPurchaseNumber() {
        return purchasePrice / 1000;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
