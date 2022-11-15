package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputOutput {
    public int getLottoBuyAmount(){
        String input = Console.readLine();
        //ErrorHandler#getLottoBuyAmountError()
        int money = Integer.parseInt(input);
        return money/1000;
    }

    public List<Integer> getLottoNumbers(){
        String input = Console.readLine();
        //ErrorHandler#getLottoWinnerNumberError()
        List<Integer> numbers = new ArrayList<>();
        for(String number : input.split(",")) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    public int getLottoBonusNumbers(){
        String input = Console.readLine();
        //ErrorHandler#getLottoBonusNumberError()
        int number = Integer.parseInt(input);
        return number;
    }

}
