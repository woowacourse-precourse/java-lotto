package lotto;

public class Cash {
    public static int countPurchaseQuantity(String readLine) {
        Exceptions.excludeUnderThousand(readLine);
        return Integer.parseInt(readLine) / 1000;
    }

}
















