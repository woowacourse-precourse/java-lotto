package lotto;

public class GameController {
    public void run() {
        Print print = new Print();
        Input input = new Input();

        User user = new User(input.amount());
        LottoSeller lottoSeller = new LottoSeller();
        user.buyLotto(lottoSeller);
        print.Lotto(user);

        WinningNumber winningNumber = input.winningNumAndBonusNum();

        Calculator calc = new Calculator(winningNumber.getWinningNum(), winningNumber.getBonusNum(), user.getLotto());
        print.WinningStat(calc);
        print.Yield(calc);
    }
}
