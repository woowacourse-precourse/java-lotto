package lotto.enums;

public enum Message {

    PRICE_ASK("구입금액을 입력해 주세요."),
    OUT_QUANTITY("개를 구매했습니다."),

    NUM_ASK("당첨 번호를 입력해 주세요."),
    BONUS_ASK("보너스 번호를 입력해 주세요."),

    OUT_STATISTIC("당첨 통계\n---"),
    CORRECT_3("3개 일치 (5,0000원) - "),
    CORRECT_4("4개 일치 (50,000원) - "),
    CORRECT_5("5개 일치 (1,500,000원) - "),
    CORRECT_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CORRECT_6("6개 일치 (2,000,000,000원) - "),

    REVENUE("총 수익률은 ");


    private final String message;

    Message(String message) {
        this.message = message;
    }


    public String getMessage(){
        return message;
    }
}
