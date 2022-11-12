package lotto.system;

import java.util.regex.Pattern;

public class SystemValid {
    public static void validateForNumber(String text) {
        Pattern pattern = Pattern.compile(SystemValue.REGAX_ONLY_NUMBER);
        if (!pattern.matcher(text).matches()) {
            throw new IllegalArgumentException("[ERROR] 입력 금액이 숫자가 아닙니다.");
        }
    }
}
