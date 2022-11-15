package ui;

public enum ExceptionMessage {
    IS_NOT_ONLY_CONTAINS_NUMBER("돈에 문자열은 포함될 수 없습니다."),
    IS_NOT_DIVIDED_INTO_1000("돈은 1000원 단위여야 합니다."),
    IS_NOT_VALID_WINNING_LOTTO("당첨 번호는 1~45 까지의 숫자로만 이루어져야 합니다."),
    IS_NOT_VALID_WINNING_LOTTO_PARSER("당첨 번호 구분은 \',\'로 이루어져야 합니다."),
    IS_NOT_UNIQUE_WINNING_LOTTO("당첨 번호는 중복되지 않아야 합니다."),
    IS_NOT_UNIQUE_LOTTO_NUMBER("로또 번호들은 서로 중복되지 않아야 합니다."),
    IS_NOT_VALID_LOTTO_LENGTH("로또 번호는 6개를 넘을 수 없습니다.");
    private final String txt;

    ExceptionMessage(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return "[ERROR] " + txt;
    }
}
