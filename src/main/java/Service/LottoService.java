package Service;

import domain.UserMoneyValidate;
import view.RequestUser;
import camp.nextstep.edu.missionutils.Console;

public class LottoService {

    UserMoneyValidate userMoneyValidate = new UserMoneyValidate();

    public void start_lotto(){

    }

    private int getUserMoney() throws IllegalArgumentException{
        RequestUser.requestMoney();
        String userInput = Console.readLine();
        return userMoneyValidate.validateGetMoney(userInput);
    }
}
