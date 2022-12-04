package lotto.view;

public enum Views {

    REQUEST_MONEY("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATICS("당첨 통계"),
    DIVIDER("---"),
    ;

    private final String format;

    Views(String format) {
        this.format = format;
    }

    public String render() {
        return format;
    }

}
