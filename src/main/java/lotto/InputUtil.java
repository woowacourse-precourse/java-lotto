package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    public int inputPurchasePrice(){
        String input = Console.readLine();
        return Integer.valueOf(input);
    }

    public List<Integer> inputWinningNumber(){
        String input = Console.readLine();
        return stringArrToIntList(commaSeparation(input));
    }

    private String[] commaSeparation(String str){
        String[] arr = str.split(",");
        return arr;
    }

    private List<Integer> stringArrToIntList(String[] input){
        List<Integer> list = new ArrayList<>();
        for(String s:input){
            list.add(Integer.valueOf(s));
        }
        return list;
    }
}
