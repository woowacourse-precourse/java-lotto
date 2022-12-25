package lotto;

import static Utils.Exceptions.EXCEPTIONS;

public class Cash {
    public static int countPurchaseQuantity(String readLine) {
        EXCEPTIONS.ExcludeUnderThousand(readLine);
        return Integer.parseInt(readLine) / 1000;
    }

}
