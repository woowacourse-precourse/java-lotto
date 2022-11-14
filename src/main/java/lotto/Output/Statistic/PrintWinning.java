package lotto.Output.Statistic;

public enum PrintWinning {
    WIN_THREE("당첨 통계%n" + "---%n" + "3개 일치 (5,000원) - %d개%n"),
    WIN_FOUR("4개 일치 (50,000원) - %d개%n"),
    WIN_FIVE_NOBONUS("5개 일치 (1,500,000원) - %d개%n"),
    WIN_SIX_YESBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    WIN_SIX("6개 일치 (2,000,000,000원) - %d개%n");

    private final String message;

    PrintWinning(String message) {
        this.message = message;
    }

    public String message() { return message; }

}
