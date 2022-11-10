package lotto;

public class Progress {
    public static void run() {
        BuyAmount buyAmount = new BuyAmount(UserInput.inputMoney());

        System.out.println(buyAmount.buyLotto);
    }
}
