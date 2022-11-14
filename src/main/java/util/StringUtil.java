package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static final String BLANK = " ";
    public static final String NO_BLANK = "";
    public static final String DELIMITER = ",";

    public static String removeBlank(String data){
        return data.replace(BLANK, NO_BLANK);
    }

    public static List <Integer> parseToNumbers(String data){
        return Arrays.stream(data.split(DELIMITER)).map(Integer::parseInt).collect(Collectors.toList());
    }
}
