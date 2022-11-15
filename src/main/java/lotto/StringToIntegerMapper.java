package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class StringToIntegerMapper {

    public static int toInt(String split) {
        return Integer.parseInt(split);
    }

    public static List<Integer> toIntList(String userInput, String regex) {
        try {
            return Arrays.stream(splitString(userInput, regex)).map(s -> toInt(s)).collect(Collectors.toList());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(",를 사용해서 띄어서입력해주세요");
        }
    }

    private static String[] splitString(String userInput, String regex) {
        return userInput.split(regex);
    }
}
