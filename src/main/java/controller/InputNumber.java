package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputNumber {
    public List<Integer> parseWinningNumber(String userInput){
        List<String> parsedString = new ArrayList<>(Arrays.asList(userInput.split("\\s*,\\s*")));
        List<Integer> winningNumber = new ArrayList<>();
        for(String parsed : parsedString){
            winningNumber.add(Integer.parseInt(parsed));
        }
        return winningNumber;
    }
}
