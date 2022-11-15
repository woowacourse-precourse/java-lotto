package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static Integer lottoCount;
    private static Lotto winningLotto;
    private static Integer bonusBall;
    private static void getUserInput(){
        winningLotto = getWinningLotto();
    }
    private static void checkIllegalNum(Integer num){
        if(num > 45 || num < 1)
            throw new IllegalArgumentException(ErrorEnum.BADREQUEST_NOT_VALID_NUM_EXCEPTION.getMessage());
    }

    private static Lotto getWinningLotto(){
        String winningNumsInput = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        for(String s : winningNumsInput.split(",")){
            Integer num = Integer.parseInt(s);
            checkIllegalNum(num);
        }
        return new Lotto(numbers);
    }

    public static void main(String[] args) {
        getUserInput();

    }
}
