package lotto.Output;

public enum PrintOutput {
    BUY("%d개를 구매했습니다.%n"),
    WIN_THREE("당첨 통계%n" + "---%n" + "3개 일치 (5,000원) - %d개%n"),
    WIN_FOUR("4개 일치 (50,000원) - %d개%n"),
    WIN_FIVE_NOBALL("5개 일치 (1,500,000원) - %d개%n"),
    WIN_FIVE_YESBALL("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    WIN_SIX("6개 일치 (2,000,000,000원) - %d개%n"),
    PROFIT("총 수익률은 %.1f%입니다.%n");

    private final String message;

    PrintOutput(String message) {
        this.message = message;
    }


    public void printMessage(int number) {
        System.out.printf(message,number);
    }
}
