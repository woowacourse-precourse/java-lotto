package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final int MONEY_UNIT = 1000;
    private final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";


    public int getMoney() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();

        if(!isValidMoney(input)){
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    //Validator 클래스
    public boolean isNumber(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public boolean isValidMoney(String input) {
        if (!isNumber(input)) {
            return false;
        }

        int money = Integer.parseInt(input);
        return money%MONEY_UNIT ==0;
    }

}
