package lotto.lib;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToIntDataStructure {
    public static int convertStringToInteger(String str){
        try {
            return Integer.parseInt(str);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }

    public static List<Integer> splitStringByComma(String str){
        List<String> splitted = Arrays.asList(str.split(","));
        try{
            return splitted.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 쉼표를 기준으로 구분되고 정수를 입력해야합니다.");
        }
    }
}
