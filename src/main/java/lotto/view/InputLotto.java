package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GameSet;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputLotto {
    public static List<Integer> getInput(){
        List<Integer> inputNumber = new ArrayList<>();
        char[] input = Console.readLine().replaceAll("[^0-9]","").toCharArray();
        for(char inputNum :input){
            inputNumber.add(inputNum-'0');
        }
        return inputNumber;
    }
}
