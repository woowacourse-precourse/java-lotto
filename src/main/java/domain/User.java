package domain;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public User() {

    }

    private int inputUserMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputUser = Console.readLine();
        int inputUserMoney = Integer.parseInt(inputUser);
        return inputUserMoney;
    }

}
