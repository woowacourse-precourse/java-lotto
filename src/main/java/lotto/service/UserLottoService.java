package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Data.User;

public class UserLottoService {
    public User InputMoney(){
        String inputMoney = Console.readLine();
        User user = new User(stringToInteger(inputMoney));
        return user;
    }
    public int stringToInteger(String value){
        int number = Integer.parseInt(value);
        return number;
    }
}
