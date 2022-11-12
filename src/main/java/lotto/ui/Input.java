package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private String input;
    //구입 금액 입력받기
    public int money(){
        input = Console.readLine();
        return Integer.parseInt(input);
    }
    //당첨번호 입력 받기
    public String winningNum(){
        input = Console.readLine();
        return input;
    }
    //보너스 번호 입력 받기
    public int bounsNum(){
        input = Console.readLine();
        return Integer.parseInt(input);
    }
}
