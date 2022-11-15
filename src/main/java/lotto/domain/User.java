package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public int inputOfAmount(){
        String userInput = Console.readLine();
        int moneyAmount = Integer.parseInt(userInput);
        return moneyAmount;
    }
}
