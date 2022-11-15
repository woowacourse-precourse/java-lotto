package lotto.enums;

public enum Message {

    PRICE_ASK("구입금액을 입력해 주세요."),
    OUT_QUANTITY("개를 구매했습니다."),

    NUM_ASK("당첨 번호를 입력해 주세요."),
    BONUS_ASK("보너스 번호를 입력해 주세요."),

    OUT_STATISTIC("당첨 통계\n---"),


    REVENUE("총 수익률은 ");


    private final String message;

    Message(String message) {
        this.message = message;
    }


    public String getMessage(){
        return message;
    }
}
