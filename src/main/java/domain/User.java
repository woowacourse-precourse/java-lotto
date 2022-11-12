package domain;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public User() {

    }

    private int inputUserMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputUser = Console.readLine();
        return Integer.parseInt(inputUser);
    }

    private void validateInputUserMoney(int inputUserMoney){
        try {
            if (inputUserMoney % 1000 != 0)
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 금액 입력값은 1000원 단위여야 합니다");
            System.exit(0);
        }
    }

}
