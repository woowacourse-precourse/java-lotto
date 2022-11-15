package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static int intInput(){
        String input = Console.readLine();
        int inputNumber = 0;
        try{
            inputNumber = Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
        }
        return inputNumber;
    }

    public static List<Integer> integerListInput(){
        List<String> input = List.of(Console.readLine().split(","));
        List<Integer> inputNumbers = new ArrayList<>();
        try{
            for (String s : input){
                inputNumbers.add(Integer.parseInt(s));
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
        }
        return inputNumbers;
    }
}
