package lotto;

import constant.ExceptionNumber;
import domain.BuyLottoList;
import view.InputBonusNumber;
import view.InputWinningLottoNumber;
import view.InputUserMoney;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        BuyLottoList buyLottoList = new BuyLottoList();
        System.out.println("구입 금액을 입력해주세요.");
        int money = InputUserMoney.inputMoney();
        if(money== ExceptionNumber.EXCEPTION_CODE.getCode()){
            return;
        }
        inputValues(buyLottoList, money);

    }

    private static void inputValues(BuyLottoList buyLottoList, int money) {
        buyLottoList.putLottoNumberList(money);
        InputWinningLottoNumber.inputLottoNumber();
        InputBonusNumber.inputBonusNumber();
    }


}
