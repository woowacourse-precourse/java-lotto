package lotto.exception;

public class ExceptionValidation {

    public static void validateException(int input) {
        if ((input % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 복권 하나는 1000원입니다. 1000원 단위로 입력해주세요.");
        }
    }
}
