package util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static final String BLANK = " ";
    public static final String NO_BLANK = "";
    public static final String DELIMITER = ",";

    public static String removeBlank(String data){
        return data.replace(BLANK, NO_BLANK);
    }

    public static List <String> parseToNumbers(String data){
        return Arrays.asList(data.split(DELIMITER));
    }
}
