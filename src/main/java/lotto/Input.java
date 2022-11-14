package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    int inputMoney() {
        String money = readLine();
        inputValidate(money);
        return Integer.parseInt(money);
    }

    void inputValidate(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int convertedMoney = Integer.parseInt(money);
        if (!divideByThousand(convertedMoney)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 단위여야 합니다.");
        }
    }

    boolean isNumeric(String money) {
        boolean answer = true;
        for(int idx = 0; idx < money.length(); idx++){
            if(!Character.isDigit(money.charAt(idx))){
                answer = false;
            }
        }
        return answer;
    }

    boolean divideByThousand(int money) {
        int rem = money % 1000;
        return rem == 0;
    }
}
