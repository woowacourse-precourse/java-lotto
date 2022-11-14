package lotto.view;

public enum OutputString {
    TICKET_QUANTITY_MESSAGE("%s개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계\n---"),
    PHRASES_RANKING("%s개 일치%s (%s원) - "),
    PHRASES_RANKING_COUNT("%d개"),
    PHRASES_RANKING_BONUSNUMBER(", 보너스 볼 일치"),
    PRIZE_FORMAT("###,###"),
    RETURNRATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String content;

    OutputString(String content){
        this.content = content;
    }

    public String print(int num){
        return String.format(content, num);
    }

    public String print(double num){
        return String.format(content, num);
    }

    public String print(){
        return content;
    }
}

