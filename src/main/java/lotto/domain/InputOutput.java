package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputOutput {
    public int getLottoBuyAmount(){
        String input = Console.readLine();
        //ErrorHandler#getLottoBuyAmountError()
        int money = Integer.parseInt(input);
        return money/1000;
    }

}
