package lotto.exception;

public class ViewClassCreateException extends IllegalStateException {
    public static final String VIEW_CLASS_CREATE_EXCEPTION_MESSAGE = "View 클래스는 생성할 수 없습니다.";
    
    public ViewClassCreateException() {
        super(VIEW_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
}
