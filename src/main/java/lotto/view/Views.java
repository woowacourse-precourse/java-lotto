package lotto.view;

public enum Views {

    REQUEST_MONEY("구입금액을 입력해 주세요."),
    ;

    private final String format;

    Views(String format) {
        this.format = format;
    }

    public String render() {
        return format;
    }

}
