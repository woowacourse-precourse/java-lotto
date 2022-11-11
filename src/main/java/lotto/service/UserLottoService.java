package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Data.User;
import lotto.handler.UserInputMoneyHandler;
import lotto.view.OutputView;

public class UserLottoService {
    UserInputMoneyHandler userInputMoneyHandler = new UserInputMoneyHandler();
    OutputView outputView = new OutputView();
    public User InputMoney(){
        outputView.inputMoneyOrder();
        String inputMoney = Console.readLine();
        userInputMoneyHandler.checkException(inputMoney);
        User user = new User(stringToInteger(inputMoney));
        return user;
    }
    public int stringToInteger(String value){
        int number = Integer.parseInt(value);
        return number;
    }
}
