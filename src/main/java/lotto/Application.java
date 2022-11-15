package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static Integer lottoCount;
    private static Lotto winningLotto;
    private static Integer bonusBall;
    private static void getUserInput(){
        lottoCount = countLotto(Console.readLine());
    }
    public static Integer countLotto(String input){
        Integer money = Integer.parseInt(input);
        if(money%1000 != 0)
            throw new IllegalArgumentException(ErrorEnum.BADREQUEST_MONEY_NOT1000_EXCEPTION.getMessage());
        return money/1000;
    }

    public static void main(String[] args) {
        getUserInput();

    }
}
