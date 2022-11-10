package constant;

public enum ExceptionNumber {

    EXCEPTION_CODE(-1);


    final private int exception;

    ExceptionNumber(int exception) {
        this.exception = exception;
    }

    public int getCode() {
        return exception;
    }
}
