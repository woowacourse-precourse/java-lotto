package lotto;

import java.util.*;


public class ProcessData {

    public List<Integer> pickedNumbers(String InputNumber) {
        List<String> InputList = new ArrayList(Arrays.asList(InputNumber.split(",")));
        List<Integer> pickedNumbers = new ArrayList<>();
        for (String s : InputList) {
            pickedNumbers.add(Integer.valueOf(s));
        }
        return pickedNumbers;
    }



}
