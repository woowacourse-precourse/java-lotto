package lotto.enumtype;

public enum LottoInterfaceMsg {
    INSERT_MONEY("구입금액을 입력해 주세요."),
    PURCHASE_COMPLETE("%d개를 구매했습니다."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요"),
    WINNING_STATS_STRING("\n당첨 통계\n---"),
    WINNING_STATS("%d개 일치 (%s원) - %d개"),
    TOTAL_RETURN("총 수익률은 '%,.1%%'입니다.");

    private final String message;

    LottoInterfaceMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
