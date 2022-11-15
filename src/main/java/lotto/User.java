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

    public void isMoneyDividedWith1000(int money) {
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }


}
