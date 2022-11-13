package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static int getPurchaseAmount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] split = input.split(",");
        List<Integer> numbers =new ArrayList<>();
        for (String str: split){
             numbers.add(Integer.parseInt(str));
        }
        return numbers;
    }

    public static int getBonusNumber(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
