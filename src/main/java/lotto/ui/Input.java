package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private String input;

    public int money(){
        input = Console.readLine();
        return Integer.parseInt(input);
    }

    public String winningNum(){
        input = Console.readLine();
        return input;
    }

    public int bonusNum(){
        input = Console.readLine();
        return Integer.parseInt(input);
    }
}
