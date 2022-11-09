package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Computer {
    public int inputMoneyMsg() {
        System.out.println("구입금액을 입력해 주세요.");
        String answer = Console.readLine();
        isValid(answer);
        int amount = Integer.parseInt(answer);
        return amount;
    }

    public void isValid(String answer) {
        for(char c : answer.toCharArray()){
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
    }

    public List generateLotto(int amount) {
        printAmount(amount);

    }

    public void printAmount(int amount) {
        System.out.println(amount+ "개를 구매했습니다.");
    }

}