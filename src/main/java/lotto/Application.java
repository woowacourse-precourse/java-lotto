package lotto;

import domain.BuyLottoTickets;
import domain.LottoGame;
import view.InputBonusNumber;
import view.InputWinningLottoNumber;
import view.InputUserMoney;
import view.OutputView;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        final int EXCEPTION_CODE=-1;
        BuyLottoTickets buyLottoTickets = new BuyLottoTickets();
        OutputView.printButMoney();
        int money = InputUserMoney.inputMoney();
        if(money== EXCEPTION_CODE){
            return;
        }
        inputValues(buyLottoTickets, money);
        LottoGame game = new LottoGame();
        game.Game();

    }

    private static void inputValues(BuyLottoTickets buyLottoTickets, int money) {
        buyLottoTickets.putLottoNumberTickets(money);
        InputWinningLottoNumber.inputWinningLottoNumber();
        InputBonusNumber.inputBonusNumber();
    }


}
