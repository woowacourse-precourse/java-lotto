package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int money;

    public User() {
    }

    public void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }

    }


}
