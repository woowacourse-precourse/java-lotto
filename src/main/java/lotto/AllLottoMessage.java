package lotto;

public enum AllLottoMessage {
    WIN_STATISTICS ("당첨 통계"),
    TITLE_DISTINGUISHING_ROLE ("---"),
    FIFTH_GRADE_STATISTICS ("3개 일치 (5,000원) - %d개%n"),
    FOURTH_GRADE_STATISTICS ("4개 일치 (50,000원) - %d개%n"),
    THIRD_GRADE_STATISTICS ("5개 일치 (1,500,000원) - %d개%n"),
    SECOND_GRADE_STATISTICS ("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    FIRST_GRADE_STATISTICS ("6개 일치 (2,000,000,000원) - %d개%n"),
    RATE_OF_RETURNS ("총 수익률은 %2.1f%s입니다."),
    PERCENT_CHARACTER ("%"),
    LINE_BREAK_CHARACTER ("\n"),
    INVALIDATE_NUMBER_SIZE ("[ERROR] 로또 번호는 6개만 가능합니다."),
    INVALIDATE_DUPLICATION ("[ERROR] 중복되는 수를 입력할 수 없습니다."),
    INPUT_MONEY ("구입금액을 입력해 주세요."),
    BUY_LOTTO ("개를 구매했습니다."),
    INVALIDATE_PRICE_UNIT ("[ERROR] 구매금액은 1000원 단위여야 합니다."),
    INVALIDATE_NUMERIC ("[ERROR] 구매금액은 숫자여야 합니다."),
    INPUT_WINNING_NUMBERS ("당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER ("보너스 번호를 입력해 주세요."),
    WINNING_NUMBER_CLASSIFICATION_CRITERIA (","),
    INVALIDATE_RANGE ("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    private final String message;

    AllLottoMessage(String message) {
        this.message= message;
    }

    public String getMessage() {
        return message;
    }
}
