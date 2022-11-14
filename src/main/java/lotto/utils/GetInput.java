package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GetInput {
    public static List<Integer> getInput(){
        List<Integer> inputNumber = new ArrayList<>();
        char[] input = Console.readLine().replaceAll("[^0-9]","").toCharArray();
        for(char inputNum :input){
            inputNumber.add(inputNum-'0');
        }
        return inputNumber;
    }
}
