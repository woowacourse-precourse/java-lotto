package lotto.domain.validator;

public class ValidatorExceptionMessageConstants {
    public static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 유틸 클래스입니다.";
    
    private ValidatorExceptionMessageConstants() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
}
