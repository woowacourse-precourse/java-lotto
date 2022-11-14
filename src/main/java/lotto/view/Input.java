package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public int getMoney(){
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String unverifiedCharacters = Console.readLine();
            int money = Integer.parseInt(unverifiedCharacters);
            if(money < 1000) validationMoney();
            if(money % 1000 != 0) validationDivideMoney();
            return money;
        }catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getMoney();
        }
    }

    private void validationDivideMoney() {
        throw new IllegalArgumentException("1000으로 나누어 떨어지는 금액을 입력해주세요.");
    }

    private void validationMoney() {
        throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요.");
    }
}
