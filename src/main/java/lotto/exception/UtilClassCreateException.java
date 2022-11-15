package lotto.exception;

public class UtilClassCreateException extends IllegalStateException {
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "[ERROR] 생성할 수 없는 유틸 클래스입니다.";
    
    public UtilClassCreateException() {
        super(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
}
