package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class User {
    final static String PURCHASE_PATTERN = "^[0-9]*$";
    public int purchasePrice;

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
        boolean isNumeric = Pattern.matches(PURCHASE_PATTERN, readLine);
        boolean isThousand = (Integer.parseInt(readLine) % 1000 == 0);

        return (isNumeric && isThousand);
    }
}
