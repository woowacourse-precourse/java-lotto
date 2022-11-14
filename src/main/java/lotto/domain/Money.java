package lotto.domain;

import lotto.exception.LottoException;
import lotto.setting.Setting;
import lotto.ui.Output;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Money {

    private String money;

    public Money(){
        this.money = inputMoney();
        validate();
    }

    public Long getLongMoney(){
        return Long.parseLong(money);
    }

    public int boughtLottoCount(){
        int bought = Math.toIntExact(Long.parseLong(money) / Setting.LOTTO_PRICE_PER_ONE);
        Output.printBoughtLotto(bought);
        return bought;
    }

    private String inputMoney(){
        Output.printInputMoney();
        String input = readLine();
        return input;
    }

    private void validate(){
        validateInputMoneyIsAllNumber();
        validateInputMoneyIsRightUnit();
    }

    private void validateInputMoneyIsAllNumber(){
        if(!this.money.matches("\\d+")){
            throw new LottoException("구입 금액은 2의 63승 이하의 숫자이어야합니다.");
        }
    }

    private void validateInputMoneyIsRightUnit(){
        if(Math.toIntExact(Long.parseLong(money) % Setting.LOTTO_PRICE_PER_ONE) != 0){
            throw new LottoException("구입 금액은 "+ Setting.LOTTO_PRICE_PER_ONE +"원 단위입니다.");
        }
    }
}
