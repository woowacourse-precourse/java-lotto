package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {
    final static String PRICE_PATTERN = "^[0-9]*$";
    final static int WINNING_NUMBER_SIZE = 6;
    final static int BONUS_NUMBER_SIZE = 1;

    public int purchasePrice;
    public List<Integer> winningNumbers;

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

    public boolean isValidPurchasePrice(String readLine) {
        boolean isNumeric = Pattern.matches(PRICE_PATTERN, readLine);
        boolean isThousand = (Integer.parseInt(readLine) % 1000 == 0);

        return (isNumeric && isThousand);
    }

    public void setWinningNumbers() {
        String winningNumbers = Console.readLine();
        winningNumbers = winningNumbers.replace(",", "");
        if (isValidWinningNumbers(winningNumbers)) {
            List<String> list =  Arrays.asList(winningNumbers.split(""));
            this.winningNumbers = list.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isValidWinningNumbers(String winningNumbers) {
        boolean isNumeric = Pattern.matches(PRICE_PATTERN, winningNumbers);
        boolean isWinningNumberSize = (winningNumbers.length() == WINNING_NUMBER_SIZE);

        return (isNumeric && isWinningNumberSize);
    }
}
