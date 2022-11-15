package lotto.UI;

public enum Text {
    BUDGET_INPUT("구입금액을 입력해 주세요."),
    BUY_LOTTO("%d개를 구매했습니다.\n"),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    STATISTICS_TITLE("당첨 통계\n---\n"),
    STATISTICS_DETAIL_WITHOUT_BONUS("%d개 일치 (%s원) - %d개\n"),
    STATISTICS_DETAIL_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.\n"),
    NONE("");

    private String message;
    Text (String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
