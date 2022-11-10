package lotto;

public class Progress {
    public static void run() {
        BuyAmount buyAmount = new BuyAmount(UserInput.inputMoney());
        System.out.println(buyAmount.buyLotto);
        WinningNumberToList winningNumberToList = new WinningNumberToList();

        winningNumberToList.setWinNumbers(UserInput.inputWinNumber());

        int bonusNum = UserInput.inputBonusNumber();

        System.out.println(winningNumberToList.winNumbers);
    }
}
