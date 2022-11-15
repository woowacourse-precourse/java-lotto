
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
        winningLotto = getWinningLotto(Console.readLine());
    }
    private static void checkIllegalNum(Integer num){
        if(num > 45 || num < 1)
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_NOT_VALID_NUM_EXCEPTION.getMessage());
    }

    public static Lotto getWinningLotto(String input){
        List<Integer> numbers = new ArrayList<>();
        for(String s : input.split(",")){
            Integer num = Integer.parseInt(s);
            checkIllegalNum(num);
        }
        return new Lotto(numbers);
    }

    public static Integer countLotto(String input){
        Integer money = Integer.parseInt(input);
        if(money%1000 != 0)
            throw new IllegalArgumentException(ErrorEnum.BAD_REQUEST_MONEY_NOT1000_EXCEPTION.getMessage());
        return money/1000;
    }

    public static void main(String[] args) {
        getUserInput();
    }
}

