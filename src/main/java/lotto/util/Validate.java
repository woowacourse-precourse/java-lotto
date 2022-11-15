package lotto.util;

public class Validate {
    public static final String ERROR_IS_NULL = "[ERROR] NULL 값은 허용하지 않습니다.";

    public static void isNull(Object number){
        if (number == null) {
            throw new IllegalArgumentException(ERROR_IS_NULL);
        }
    }
}