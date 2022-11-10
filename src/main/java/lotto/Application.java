package lotto;

import constant.ExceptionNumber;
import domain.BuyLottoList;
import view.InputLottoNumber;
import view.InputUserMoney;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        BuyLottoList buyLottoList = new BuyLottoList();
        int money = InputUserMoney.inputMoney();
        if(money== ExceptionNumber.EXCEPTION_CODE.getCode()){
            return;
        }
        buyLottoList.putLottoNumberList(money);
        InputLottoNumber.inputLottoNumber();


    }


}
