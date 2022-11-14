package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static final String BLANK = " ";
    public static final String NO_BLANK = "";
    public static final String DELIMITER = ",";

    public static String removeBlank(String data) {
        return data.replace(BLANK, NO_BLANK);
    }

    public static List <Integer> parseToList(String data) {
        return Arrays.stream(data.split(DELIMITER)).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int parseToInt(String data) {
        try {
            return Integer.parseInt(data);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 입력이 불가능합니다.");
        }
    }
}
