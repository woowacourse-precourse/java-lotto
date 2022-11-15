package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static final String DELIMITER = ",";

    public static List <Integer> parseToIntegerList(String data) {
        return Arrays.stream(data.split(DELIMITER))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int parseToInt(String data) {
        try {
            return Integer.parseInt(data);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 입력이 불가능합니다.");
        }
    }
}
