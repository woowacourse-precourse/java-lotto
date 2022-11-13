package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String MESSAGE_TO_GET_MONEY = "구입금액을 입력해 주세요.";

    public int getMoney() {
        System.out.println(MESSAGE_TO_GET_MONEY);
        String input = Console.readLine().trim(); // 띄어쓰기 고려

        if(!isNumber(input)){
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    //InputValidator 클래스?
    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return true;
    }

}
