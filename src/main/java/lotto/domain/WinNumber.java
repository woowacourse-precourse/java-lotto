package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinNumber {

    public static List<Integer> winNum(String str){
        List<Integer> numbers = change(str);
        return numbers;
    }

    private static List<Integer> change(String str) {
        List<Integer> num = new ArrayList<>();
        String[] splitStr = str.split(",");
        for (String s : splitStr) {
            num.add(Integer.valueOf(s));
        }
        return num;
    }
}
