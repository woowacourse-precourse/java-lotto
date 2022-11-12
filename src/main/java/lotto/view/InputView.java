package lotto.view;

import lotto.utils.OutputNonEnumMessage;
import lotto.service.UserService;

public class InputView {
    UserService userService = new UserService();

    public void printUserInputMoney(String money){
        System.out.println(OutputNonEnumMessage.INPUT_MONEY_MESSAGE);
        System.out.println(userService.getUserMoney());
    }

    public void printUserInputLottoNumber(String number){
        System.out.println(OutputNonEnumMessage.INPUT_LOTTO_NUMBER_MESSAGE);
        System.out.println(userService.getLottoNumber());
    }

    public void printUserInputBonusNumber(String number){
        System.out.println(OutputNonEnumMessage.INPUT_BONUS_NUMBER_MESSAGE);
        System.out.println(userService.getBonusNumber());
    }
}
