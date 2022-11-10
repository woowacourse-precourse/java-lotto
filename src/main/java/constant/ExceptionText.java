package constant;

public enum ExceptionText {
    NULL("입력값은 null일 수 없습니다."),
    NOT_INT("입력값이 정수가 아닙니다."),
    CAN_NOT_BE_DIVIDED("%d로 나눌 수 없습니다."),
    ;

    final String content;

    ExceptionText(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
