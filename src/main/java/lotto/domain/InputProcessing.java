package lotto.domain;

import lotto.view.ConsoleInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputProcessing {

    public List<Integer> inputConverter(String input){
        List<Integer> numberList = new ArrayList<>();
        String[] stringArray = isNum(input);
        numberList = arrayToList(stringToInt(stringArray));
        return numberList;
    }

    public String[] isNum(String input) {
        String[] numbers = deleteComma(input);
        for (String number : numbers) {
            findText(number);
        }
        return numbers;
    }

    public String[] deleteComma(String input) {
        String[] inputArray = input.split(",");
        return inputArray;
    }

    public void findText(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isDigit(c))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
            }
        }
    }

    public Integer[] stringToInt(String[] stringArray) {
        Integer[] intArray = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    public List arrayToList(Integer[] intArray) {
        List<Integer> numberList = Arrays.asList(intArray);
        return numberList;
    }
}
