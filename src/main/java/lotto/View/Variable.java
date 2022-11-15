package lotto.View;

public enum Variable {
    Stat_Lotto("구입금액을 입력해 주세요."),
    Right_nbr("당첨 번호를 입력해 주세요."),
    Bonus_nbr("보너스 번호를 입력해 주세요."),

    Buy_lotto("개를 구매했습니다."),
    Winning_Rate("당첨 통계\n---"),
    Winning_money("%s개 일치 (%s원) - %d개"),
    No_bonus("%s개 일치, 보너스 볼 일치 (%s원) - %d개"),
    Earning_rate("총 수익률은 %.1f%%입니다.");


    private final String message;

    Variable(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}