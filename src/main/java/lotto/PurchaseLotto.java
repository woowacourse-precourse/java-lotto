package lotto;

public class PurchaseLotto {
    public static final String ErrorMessage_NotThousand = "[ERROR] 1000원 단위로 입력해 주세요.";

    private static boolean checkThousand(int cash) {
        try {
            return cash%1000 == 0;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ErrorMessage_NotThousand);
        }
    }

    public static int countTry(int cash) {
        return cash/1000;
    }
}
