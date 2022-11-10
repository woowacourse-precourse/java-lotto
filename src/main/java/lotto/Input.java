package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Input {
    private int money;
    private List<Integer> numbers;

    public Input() {
        enterMoney();
    }

    private void enterMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String userInput = Console.readLine();

        if(validate(userInput)) {
            this.money = parseInt(userInput);
        }
    }

    private boolean validate(String userInput) {
        if(userInput.charAt(0) == '0')
            throw new IllegalArgumentException("[Error] 구매 금액을 잘못 입력 하셨습니다.");

        for(char c :userInput.toCharArray()){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException("[Error] 구매 금액을 잘못 입력 하셨습니다.");
        }

        return true;
    }
}
