package lotto.view;

import lotto.utils.OutputNonEnumMessage;

import java.util.List;

public class InputView {

    public void printUserInputMoney(int money){
        System.out.println(OutputNonEnumMessage.INPUT_MONEY_MESSAGE);
        System.out.println(money);
    }

    public void printUserInputLottoNumber(List<Integer>number){
        System.out.println(OutputNonEnumMessage.INPUT_LOTTO_NUMBER_MESSAGE);
        System.out.println(number);
    }

    public void printUserInputBonusNumber(int bonusNumber){
        System.out.println(OutputNonEnumMessage.INPUT_BONUS_NUMBER_MESSAGE);
        System.out.println(bonusNumber);
    }
}
