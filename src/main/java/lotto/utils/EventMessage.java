package lotto.utils;

public enum EventMessage {

    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ISSUED_AMOUNT("%s개를 구매했습니다."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    STATISTICS_HEADER("당첨 통계\n---"),
    STATISTICS_BODY("%d개 일치 (%s원) - %s개"),
    STATISTICS_FOOTER("총 수익률은 %s%입니다."),
    NEW_LINE("\n");

    public final String message;
    EventMessage(String message){
        this.message = message;
    }

}
