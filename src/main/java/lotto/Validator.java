package lotto;

public class Validator {
    public static void checkPurchaseMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 수를 입력하세요.");
        }
    }
}
