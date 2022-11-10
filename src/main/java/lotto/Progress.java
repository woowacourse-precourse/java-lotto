package lotto;

public class Progress {
    public static void run() {
        BuyAmount buyAmount = new BuyAmount(UserInput.inputMoney());
        WinningNumberToList winningNumberToList = new WinningNumberToList();

        winningNumberToList.setWinNumbers(UserInput.inputWinNumber());

        System.out.println(winningNumberToList.winNumbers);
        System.out.println(buyAmount.buyLotto);
    }
}
