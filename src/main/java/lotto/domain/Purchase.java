package lotto.domain;

public class Purchase {
    private static int amount;

    public static void buyLotto() {
        inputPurchaseAmount();
    }

    public static void inputPurchaseAmount() {
        Print.purchaseAmount();
        amount = Input.purchaseAmount();
    }
}
