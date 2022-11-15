package lotto.printer;

public enum PrinterFormat {

    BOUGHT_LOTTO_COUNT("\n%d개를 구매했습니다."),
    BOUGHT_LOTTO_NUMBERS("[%d, %d, %d, %d, %d, %d]"),
    STATISTICS("\n당첨 통계\n"
            + "---\n"
            + "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - %d개\n"
            + "5개 일치 (1,500,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
            + "6개 일치 (2,000,000,000원) - %d개\n"
            + "총 수익률은 %.1f%%입니다.");

    private final String format;

    PrinterFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return this.format;
    }
    
}
