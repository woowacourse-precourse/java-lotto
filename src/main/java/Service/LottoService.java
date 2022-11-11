package Service;

import domain.UserMoneyValidate;
import view.RequestUser;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
