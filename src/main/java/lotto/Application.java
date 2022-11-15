package lotto;

import domain.BuyLottoTickets;
import domain.LottoGame;
import view.InputBonusNumber;
import view.InputWinningLottoNumber;
import view.InputUserMoney;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            BuyLottoTickets buyLottoTickets = new BuyLottoTickets();
            OutputView.printButMoney();
            int money = InputUserMoney.inputMoney();
            inputValues(buyLottoTickets, money);
            LottoGame game = new LottoGame();
            game.Game();
        }
        catch (IllegalArgumentException e){
            OutputView.printException(e);
        }

    }

    private static void inputValues(BuyLottoTickets buyLottoTickets, int money) {
        buyLottoTickets.putLottoNumberTickets(money);
        InputWinningLottoNumber.inputWinningLottoNumber();
        InputBonusNumber.inputBonusNumber();
    }


}
