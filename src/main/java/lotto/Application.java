package lotto;

import constant.ExceptionNumber;
import domain.BuyLottoList;
import domain.LottoGame;
import view.InputBonusNumber;
import view.InputWinningLottoNumber;
import view.InputUserMoney;
import view.OutputView;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        BuyLottoList buyLottoList = new BuyLottoList();
        OutputView.printButMoney();
        int money = InputUserMoney.inputMoney();
        if(money== ExceptionNumber.EXCEPTION_CODE.getCode()){
            return;
        }
        inputValues(buyLottoList, money);
        LottoGame game = new LottoGame();
        game.Game();

    }

    private static void inputValues(BuyLottoList buyLottoList, int money) {
        buyLottoList.putLottoNumberList(money);
        InputWinningLottoNumber.inputWinningLottoNumber();
        InputBonusNumber.inputBonusNumber();
    }


}
