package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    
    public static Integer getNumberInput() {
        String line = readLine();
        validateNumberString(line);
        return Integer.parseInt(line);
    }
    
    public static List<Integer> getSplittingNumberList(String regex) {
        return splitNumberString(readLine(), regex);
    }
    
    public static List<Integer> splitNumberString(String input, String regex) {
        List<Integer> result = new ArrayList<>();
        
        for (String numberString : input.split(regex)) {
            String clearNumberString = numberString.trim();
            validateNumberString(clearNumberString);
            result.add(Integer.parseInt(clearNumberString));
        }
        
        return result;
    }
    
    private static void validateNumberString(String input) {
        for (Character c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    private static String readLine() {
        return Console.readLine().trim();
    }
}
