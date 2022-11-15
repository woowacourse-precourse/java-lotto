package lotto;

import java.util.*;


public class ProcessData {


    public List<Integer> pickedNumbers(String InputNumber) {
        List<String> InputList = new ArrayList(Arrays.asList(InputNumber.split(",")));
        List<Integer> pickedNumbers = new ArrayList<>();
        for (String s : InputList) {
            pickedNumbers.add(Integer.valueOf(s));
        }
        Collections.sort(pickedNumbers);

        return pickedNumbers;
    }

    public int money(String money) {
        return Integer.parseInt(money);
    }

    public int moneyChance(int money) {
        return money / 1000;
    }

    public String setCount(int count) {
        return String.valueOf(count);
    }

    public String outcomeNumber(int num, List<Integer> result){
        return setCount(result.get(num));

    }

    public String earningCount(double count){
        return String.valueOf(count);
    }




}
