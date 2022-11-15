package lotto;

public class PurchaseException {

    private static int MIN_NUMBER = 0;
    private static int MAX_NUMBER = 9;
    private static int MIN_AMOUNT = 1000;

    public static void validatePurchaseAmount(String amount) {
        if (isNumberOnly(amount)) {
            System.out.println("hi");
            throw new IllegalArgumentException("[ERROR]");
        }

        if (isDivide(amount)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private static boolean isNumberOnly(String amount) {
        for (char money : amount.toCharArray()) {
            if (!(MIN_NUMBER <= money - '0' && money - '0' <= MAX_NUMBER)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDivide(String amount) {
        if (Integer.parseInt(amount) % MIN_AMOUNT != 0) {
            return true;
        }
        return false;
    }
}
