package lotto;

import java.util.ArrayList;
import java.util.List;

public class CreateUerNumber {
    public List<Integer> makeWinningNumber(String userInput){
        Exception checkInput = new Exception();
        List<Integer> winningNumber= new ArrayList<>();
        if(checkInput.isProperComma(userInput) && checkInput.isContainOthers(userInput)) {
            List<String> inputArray = List.of(userInput.split(","));
            for(String number : inputArray){
                winningNumber.add(Integer.parseInt(number));
            }
        }
        return winningNumber;
    }
}
