package controller;

import camp.nextstep.edu.missionutils.Console;

public class UserService {
    public int inputUserMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputUser = Console.readLine();
        return Integer.parseInt(inputUser);
    }

}
