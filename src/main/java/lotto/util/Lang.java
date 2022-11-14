package lotto.util;

public class Lang {
    public final static String NON_NUMERIC_CHARACTER = "입력한 내용 중 숫자가 아닌 문자가 있어요.";
    public final static String ELEMENT_INSUFFICIENT = "%d개 이하의 숫자를 입력했어요. %d개 숫자를 입력해 주세요.";
    public final static String ELEMENT_DUPLICATE = "중복된 숫자를 입력했어요. 중복 없는 %d개 숫자를 입력해 주세요.";
    public final static String OUT_RANGE = "%d ~ %d 숫자를 입력해 주세요.";
    public static final String VARIABLE_NOT_DECLARE = "변수를 선언하지 않았어요.";

    public static String format(String message, Object ...args) {
        return String.format(message, args);
    }
}
