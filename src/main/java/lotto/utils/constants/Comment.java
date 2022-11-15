package lotto.utils.constants;

public enum Comment {

    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_AMOUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계");

    private final String comment;

    Comment(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

}
