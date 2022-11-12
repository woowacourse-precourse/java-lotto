package lotto;

public class Application {
    public static void main(String[] args) {

        User user = new User();

        Print.printInsertMoney();

        user.payMoney();
        user.buyLotto();

        Print.printLotto(user.getUserLottos());

        Print.printWinningNumber();

        WinningNumbers winningNumbers = new WinningNumbers();
        winningNumbers.pickWinningNumbers();

    }
}
