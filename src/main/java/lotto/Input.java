package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Input {
    private int money;
    private List<Integer> numbers;

    public Input() {
        enterMoney();
        enterNumbers();
    }

    private void enterMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String userInput = Console.readLine();

        if(validate(userInput)) {
            this.money = parseInt(userInput);
        }
    }

    private void enterNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        parseInputToInt(userInput);
    }

    private void parseInputToInt(String userInput) {
        String[] tempString = userInput.split(",", 6);

        /*
            당첨 번호가 성공적으로 분리되어 배열에 저장되면, 그 배열의 크기는
            항상 6이 된다. 그렇지 않으면 당첨 번호가 쉼표로 구별되지
            않은 것이므로 예외를 발생시킨다.
         */
        if(tempString.length != 6) {
            throw new IllegalArgumentException("[Error] 당첨 번호가 구별되지 않습니다.");
        }

        for(String s : tempString) {
            this.numbers.add(Integer.parseInt(s));
        }
    }

    private boolean validate(String userInput) {
        if(userInput.charAt(0) == '0')
            throw new IllegalArgumentException("[Error] 구매 금액을 잘못 입력 하셨습니다.");

        for(char c :userInput.toCharArray()){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException("[Error] 구매 금액을 잘못 입력 하셨습니다.");
        }

        int tempMoney = Integer.parseInt(userInput);

        if((tempMoney % 1000) != 0)
            throw new IllegalArgumentException("[Error] 구매 금액이 천 원으로 나누어 떨어지지 않는 금액입니다.");

        return true;
    }
}
