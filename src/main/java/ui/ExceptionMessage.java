package ui;

public enum ExceptionMessage {
    IS_NOT_ONLY_CONTAINS_NUMBER("돈에 문자열은 포함될 수 없습니다."),
    IS_NOT_DIVIDED_INTO_1000("돈은 1000원 단위여야 합니다.");

    private final String txt;

    ExceptionMessage(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return "[ERROR] " + txt;
    }
}
